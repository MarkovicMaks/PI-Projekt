package MaksMarkovic.Algebra.StudentRecepieApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_name", length = 255)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("'user'")
    @Column(name = "role", nullable = false, length = 50)
    private String role;
}
