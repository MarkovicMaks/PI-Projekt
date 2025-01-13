package MaksMarkovic.Algebra.StudentRecepieApp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private MaksMarkovic.Algebra.StudentRecepieApp.User user;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "price_tag", length = Integer.MAX_VALUE)
    private String priceTag;

    @Column(name = "health_tag", length = Integer.MAX_VALUE)
    private String healthTag;

    @Column(name = "preference_tag", length = Integer.MAX_VALUE)
    private String preferenceTag;

    @Column(name = "created_at")
    private Instant createdAt;

}