package MaksMarkovic.Algebra.StudentRecepieApp.models;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
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

    // Public no-arg constructor for JPA
    public Recipe() {}

    // Private constructor for Builder
    private Recipe(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.title = builder.title;
        this.description = builder.description;
        this.priceTag = builder.priceTag;
        this.healthTag = builder.healthTag;
        this.preferenceTag = builder.preferenceTag;
        this.createdAt = builder.createdAt;
    }

    // Getters (No Setters to maintain immutability)
    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public String getHealthTag() {
        return healthTag;
    }

    public String getPreferenceTag() {
        return preferenceTag;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    // Builder class remains the same
    public static class Builder {
        private Integer id;
        private User user;
        private String title;
        private String description;
        private String priceTag;
        private String healthTag;
        private String preferenceTag;
        private Instant createdAt;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder priceTag(String priceTag) {
            this.priceTag = priceTag;
            return this;
        }

        public Builder healthTag(String healthTag) {
            this.healthTag = healthTag;
            return this;
        }

        public Builder preferenceTag(String preferenceTag) {
            this.preferenceTag = preferenceTag;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }
    }
}
