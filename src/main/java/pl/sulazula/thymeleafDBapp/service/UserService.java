package pl.sulazula.thymeleafDBapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sulazula.thymeleafDBapp.model.User;
import pl.sulazula.thymeleafDBapp.repos.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
