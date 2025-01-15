package MaksMarkovic.Algebra.StudentRecepieApp.service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    Optional<Recipe> getRecipeById(Integer id);
    List<Recipe> getAllRecipes();
    List<Recipe> getRecipesByUserId(Integer userId);
    List<Recipe> searchRecipesByTitle(String title);
    Recipe updateRecipe(Integer id, Recipe recipeDetails);
    void deleteRecipe(Integer id);
}
