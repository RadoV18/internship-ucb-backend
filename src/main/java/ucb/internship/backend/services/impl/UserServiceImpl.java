package ucb.internship.backend.services.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import ucb.internship.backend.dtos.AuthDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.jwt.models.ERole;
import ucb.internship.backend.jwt.models.Role;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.models.User;
import org.springframework.stereotype.Service;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.FileStorageService;
import ucb.internship.backend.services.UserService;

import ucb.internship.backend.jwt.repository.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ucb.internship.backend.jwt.security.services.UserDetailsImpl;
import ucb.internship.backend.jwt.security.jwt.JwtUtils;
import java.util.List;
import java.util.stream.Collectors;
import ucb.internship.backend.jwt.security.services.RefreshTokenService;
import ucb.internship.backend.jwt.models.RefreshToken;
import ucb.internship.backend.jwt.payload.response.MessageResponse;
import ucb.internship.backend.jwt.payload.response.TokenRefreshResponse;
import ucb.internship.backend.jwt.payload.request.TokenRefreshRequest;
import ucb.internship.backend.jwt.exception.TokenRefreshException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @Override
    public AuthDto authenticate(String email, String password) {
        User user = repository.findByEmailAndIsApprovedIs(email, 1).orElse(null);

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        if (user != null && user.authenticate(password)) {
            AuthDto authDto = new AuthDto();
            authDto.setUserId(user.getUserId());
            authDto.setEmail(user.getEmail());
            authDto.setProfilePictureUrl(user.getS3ProfilePicture().getUrl());
            authDto.setToken(jwt);
            authDto.setRefreshToken(refreshToken.getToken());
            authDto.setRoles(roles);
            Institution institution = user.getInstitution();
            if (institution != null) {
                authDto.setId(institution.getInstitutionId());
                authDto.setName(institution.getName());
                authDto.setAccountType(1);
                return authDto;
            }
            Person person = user.getPerson();
            if (person != null) {
                authDto.setId(person.getPersonId());
                authDto.setName(person.getFirstName() + " " + person.getLastName());
                authDto.setAccountType(2);
                return authDto;
            }
            authDto.setAccountType(0);
            return authDto;
        }
        return null;
    }

    public User createUser(String email, String password, MultipartFile profilePicture, String role)
            throws FileStorageException {
        // check if the user already exists
        if (userExists(email)) {
            throw new RuntimeException("El usuario ya existe");
        }
        // hash the password
        String hashedPassword = BCrypt
                .withDefaults()
                .hashToString(12, password.toCharArray());
        S3Object savedS3Object = null;
        if (profilePicture != null) {
            savedS3Object = fileStorageService.createObject(profilePicture);
        }
        // save the user in the database
        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setS3ProfilePicture(savedS3Object);
        user.setIsApproved(0);
        user.setStatus(true);

        // set role
        if (role.equals("institution")) {
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_INSTITUTION)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
        } else if (role.equals("graduate")) {
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_GRADUATE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
        } else if (role.equals("student")) {
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
        }

        return repository.save(user);
    }

    @Override
    public User getUser(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public boolean userExists(String email) {
        User user = repository.findByEmail(email).orElse(null);
        return user != null;
    }

    @Override
    public void setRequestStatus(Long id, Integer state) {
        User user = this.repository.findById(id).orElseThrow();
        user.setIsApproved(state);
        // TODO: send email to student or institution
        this.repository.save(user);
    }

    @Override
    public TokenRefreshResponse getRefreshtoken(TokenRefreshRequest request) throws TokenRefreshException {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromEmail(user.getEmail());
                    return new TokenRefreshResponse(token, requestRefreshToken);
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @Override
    public MessageResponse getLogoutUser() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Long userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);
        return new MessageResponse("Log out successful!");
    }
}