package ucb.internship.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import ucb.internship.backend.models.User;
import org.springframework.stereotype.Service;
import ucb.internship.backend.repositories.UsersRepository;

import java.util.List;

@Service
public class PGUserService implements UserService
{
    @Autowired
    private UsersRepository repository;

    @Override
    public User authenticate(String email, String password) {

        var user = repository.findByEmail(email).orElse(null);

        if (user != null && user.authenticate(password))
        {
            return user;
        }

        return null;
    }

    @Override
    public User getUser(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    @Override
    public Iterable<User> getAllUsers() {

        return repository.findAll();
    }
}