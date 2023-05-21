package ucb.internship.backend.services.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.models.User;
import org.springframework.stereotype.Service;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.FileStorageService;
import ucb.internship.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public User authenticate(String email, String password) {

        var user = repository.findByEmailAndIsApprovedIs(email, 1).orElse(null);

        if (user != null && user.authenticate(password)) {
            return user;
        }

        return null;
    }

    public User createUser(String email, String password, MultipartFile profilePicture) throws FileStorageException {
        // check if the user already exists
        if(userExists(email)) {
            throw new RuntimeException("El usuario ya existe");
        }
        // hash the password
        String hashedPassword = BCrypt
                .withDefaults()
                .hashToString(12, password.toCharArray());
        S3Object savedS3Object = null;
        if(profilePicture != null) {
            savedS3Object = fileStorageService.createObject(profilePicture);
        }
        // save the user in the database
        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setS3ProfilePicture(savedS3Object);
        user.setIsApproved(0);
        user.setStatus(true);

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
        this.repository.save(user);
    }
}