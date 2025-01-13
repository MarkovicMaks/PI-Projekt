package MaksMarkovic.Algebra.StudentRecepieApp.service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
}
