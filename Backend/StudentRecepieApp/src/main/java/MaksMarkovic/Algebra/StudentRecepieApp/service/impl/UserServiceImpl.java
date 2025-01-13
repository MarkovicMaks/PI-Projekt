package MaksMarkovic.Algebra.StudentRecepieApp.service.impl;

import MaksMarkovic.Algebra.StudentRecepieApp.models.User;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.UserRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok auto-generates constructor for final fields
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo; // Lombok initializes this

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public User createUser(User user) {
        user.setCreatedAt(Instant.now()); // Ensure Lombok is generating setters
        return userRepo.save(user);
    }

    @Override
    public User updateUser(Integer id, User userDetails) {
        return userRepo.findById(id).map(existingUser -> {
            existingUser.setFullName(userDetails.getFullName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setRole(userDetails.getRole());
            return userRepo.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }
}
