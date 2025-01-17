package MaksMarkovic.Algebra.StudentRecepieApp.Service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.User;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.UserRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("UserServiceImpl Test")
public class UserServiceImplTest {

    private UserRepo userRepo;
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userRepo = Mockito.mock(UserRepo.class);
        userService = new UserServiceImpl(userRepo);
    }

    @Test
    @DisplayName("Test getAllUsers")
    public void testGetAllUsers() {
        // Given
        User user1 = new User();
        user1.setId(1);
        user1.setFullName("John Doe");

        User user2 = new User();
        user2.setId(2);
        user2.setFullName("Jane Doe");

        when(userRepo.findAll()).thenReturn(Arrays.asList(user1, user2));

        // When
        List<User> users = userService.getAllUsers();

        // Then
        assertNotNull(users, "The list of users should not be null.");
        assertEquals(2, users.size(), "The list size should match.");
        verify(userRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getUserById - Found")
    public void testGetUserByIdFound() {
        // Given
        User user = new User();
        user.setId(1);
        user.setFullName("John Doe");

        when(userRepo.findById(1)).thenReturn(Optional.of(user));

        // When
        Optional<User> foundUser = userService.getUserById(1);

        // Then
        assertTrue(foundUser.isPresent(), "The user should be found.");
        assertEquals(user.getId(), foundUser.get().getId(), "The ID should match.");
        verify(userRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test getUserById - Not Found")
    public void testGetUserByIdNotFound() {
        // Given
        when(userRepo.findById(1)).thenReturn(Optional.empty());

        // When
        Optional<User> foundUser = userService.getUserById(1);

        // Then
        assertFalse(foundUser.isPresent(), "The user should not be found.");
        verify(userRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test createUser")
    public void testCreateUser() {
        // Given
        User user = new User();
        user.setFullName("John Doe");
        user.setEmail("john@example.com");

        when(userRepo.save(user)).thenReturn(user);

        // When
        User createdUser = userService.createUser(user);

        // Then
        assertNotNull(createdUser, "The created user should not be null.");
        assertNotNull(createdUser.getCreatedAt(), "The createdAt timestamp should be set.");
        verify(userRepo, times(1)).save(user);
    }

    @Test
    @DisplayName("Test updateUser")
    public void testUpdateUser() {
        // Given
        User existingUser = new User();
        existingUser.setId(1);
        existingUser.setFullName("Old Name");

        User updatedDetails = new User();
        updatedDetails.setFullName("New Name");
        updatedDetails.setEmail("new@example.com");
        updatedDetails.setPassword("securepassword");
        updatedDetails.setRole("admin");

        when(userRepo.findById(1)).thenReturn(Optional.of(existingUser));
        when(userRepo.save(existingUser)).thenReturn(existingUser);

        // When
        User updatedUser = userService.updateUser(1, updatedDetails);

        // Then
        assertNotNull(updatedUser, "The updated user should not be null.");
        assertEquals("New Name", updatedUser.getFullName(), "The name should match the updated value.");
        assertEquals("new@example.com", updatedUser.getEmail(), "The email should match the updated value.");
        assertEquals("admin", updatedUser.getRole(), "The role should match the updated value.");
        verify(userRepo, times(1)).findById(1);
        verify(userRepo, times(1)).save(existingUser);
    }

    @Test
    @DisplayName("Test deleteUser")
    public void testDeleteUser() {
        // Given
        doNothing().when(userRepo).deleteById(1);

        // When
        userService.deleteUser(1);

        // Then
        verify(userRepo, times(1)).deleteById(1);
    }
}
