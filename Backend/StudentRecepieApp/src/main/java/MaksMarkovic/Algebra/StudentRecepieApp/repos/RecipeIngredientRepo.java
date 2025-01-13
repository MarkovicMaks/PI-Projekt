package MaksMarkovic.Algebra.StudentRecepieApp.repos;

import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredient;
import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, RecipeIngredientId> {

    List<RecipeIngredient> findByRecipeId(Long recipeId);
}
