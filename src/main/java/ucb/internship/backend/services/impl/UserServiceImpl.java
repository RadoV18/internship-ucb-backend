package ucb.internship.backend.services.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import ucb.internship.backend.dtos.UserDTO;
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

        var user = repository.findByEmail(email).orElse(null);

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
        Long s3ObjectId = null;
        if(profilePicture != null) {
            S3Object savedS3Object = fileStorageService.createObject(profilePicture);
            s3ObjectId = savedS3Object.getS3ObjectId();
        }
        // save the user in the database
        User user = new User(
                email,
                hashedPassword,
                s3ObjectId,
                0,
                true
        );
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
    public void requestApproved(Long id, Integer state) {
        User user = this.repository.findById(id).orElseThrow();
        user.setApproved(state);
        User updateUser = user;
        System.out.println("El usuario es"+ updateUser.getApproved());
        this.repository.save(updateUser);
    }
}