package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RecipeCategoryId implements java.io.Serializable {
    private static final long serialVersionUID = 1299991109641937517L;
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeCategoryId entity = (RecipeCategoryId) o;
        return Objects.equals(this.recipeId, entity.recipeId) &&
                Objects.equals(this.categoryId, entity.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, categoryId);
    }

}