package MaksMarkovic.Algebra.StudentRecepieApp.service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    Ingredient saveIngredient(Ingredient ingredient);
    Optional<Ingredient> getIngredientById(Integer id);
    List<Ingredient> getAllIngredients();
    List<Ingredient> getIngredientsByName(String name);
    Ingredient updateIngredient(Integer id, Ingredient ingredientDetails);
    void deleteIngredient(Integer id);
}
