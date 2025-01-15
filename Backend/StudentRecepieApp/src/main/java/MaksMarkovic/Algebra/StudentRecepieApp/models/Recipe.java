package MaksMarkovic.Algebra.StudentRecepieApp.models;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public Recipe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(String priceTag) {
        this.priceTag = priceTag;
    }

    public String getHealthTag() {
        return healthTag;
    }

    public void setHealthTag(String healthTag) {
        this.healthTag = healthTag;
    }

    public String getPreferenceTag() {
        return preferenceTag;
    }

    public void setPreferenceTag(String preferenceTag) {
        this.preferenceTag = preferenceTag;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
