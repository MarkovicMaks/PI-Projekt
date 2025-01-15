package MaksMarkovic.Algebra.StudentRecepieApp.service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredient;

import java.util.List;
import java.util.Optional;

public interface RecipeIngredientService {
    RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient);
    Optional<RecipeIngredient> getRecipeIngredientById(Long recipeId, Long ingredientId);
    List<RecipeIngredient> getAllRecipeIngredients();
    List<RecipeIngredient> getRecipeIngredientsByRecipeId(Long recipeId);
    void deleteRecipeIngredient(Long recipeId, Long ingredientId);
}
