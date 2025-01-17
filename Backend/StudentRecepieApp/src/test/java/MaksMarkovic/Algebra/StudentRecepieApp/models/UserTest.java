package MaksMarkovic.Algebra.StudentRecepieApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User model test")
public class UserTest {

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
    }

    @Test
    @DisplayName("Test getting ID")
    public void testGetId() {
        // Given
        user.setId(1);

        // When
        Integer id = user.getId();

        // Then
        assertEquals(1, id, "The ID should match the value that was set.");
    }


    @Test
    @DisplayName("Test setting and getting Full Name")
    public void testSetAndGetFullName() {
        // Given
        String fullName = "John Doe";

        // When
        user.setFullName(fullName);

        // Then
        assertEquals(fullName, user.getFullName(), "The full name should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Email")
    public void testSetAndGetEmail() {
        // Given
        String email = "john.doe@example.com";

        // When
        user.setEmail(email);

        // Then
        assertEquals(email, user.getEmail(), "The email should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Password")
    public void testSetAndGetPassword() {
        // Given
        String password = "securepassword";

        // When
        user.setPassword(password);

        // Then
        assertEquals(password, user.getPassword(), "The password should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Created At")
    public void testSetAndGetCreatedAt() {
        // Given
        Instant createdAt = Instant.now();

        // When
        user.setCreatedAt(createdAt);

        // Then
        assertEquals(createdAt, user.getCreatedAt(), "The createdAt timestamp should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Role")
    public void testSetAndGetRole() {
        // Given
        String role = "admin";

        // When
        user.setRole(role);

        // Then
        assertEquals(role, user.getRole(), "The role should match the value that was set.");
    }

    @Test
    @DisplayName("Test default Role value")
    public void testDefaultRole() {
        // Given
        User user = new User();

        // When
        String defaultRole = user.getRole();

        // Then
        assertNull(defaultRole, "The role should be null by default, as it is not set in the constructor.");
    }

    @Test
    @DisplayName("Test no-args constructor")
    public void testNoArgsConstructor() {
        // Given & When
        User user = new User();

        // Then
        assertNotNull(user, "The user object should not be null.");
        assertNull(user.getId(), "The ID should be null when using the no-args constructor.");
        assertNull(user.getFullName(), "The full name should be null when using the no-args constructor.");
        assertNull(user.getEmail(), "The email should be null when using the no-args constructor.");
        assertNull(user.getPassword(), "The password should be null when using the no-args constructor.");
        assertNull(user.getCreatedAt(), "The createdAt timestamp should be null when using the no-args constructor.");
        assertNull(user.getRole(), "The role should be null when using the no-args constructor.");
    }
}

