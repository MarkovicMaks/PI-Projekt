package MaksMarkovic.Algebra.StudentRecepieApp.service.impl;

import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredient;
import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredientId;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.RecipeIngredientRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.RecipeIngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientRepo recipeIngredientRepo;

    public RecipeIngredientServiceImpl(RecipeIngredientRepo recipeIngredientRepo) {
        this.recipeIngredientRepo = recipeIngredientRepo;
    }

    @Override
    public RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepo.save(recipeIngredient);
    }

    @Override
    public Optional<RecipeIngredient> getRecipeIngredientById(Long recipeId, Long ingredientId) {
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(recipeId.intValue());
        id.setIngredientId(ingredientId.intValue());
        return recipeIngredientRepo.findById(id);
    }

    @Override
    public List<RecipeIngredient> getAllRecipeIngredients() {
        return recipeIngredientRepo.findAll();
    }

    @Override
    public List<RecipeIngredient> getRecipeIngredientsByRecipeId(Long recipeId) {
        return recipeIngredientRepo.findByRecipeId(recipeId);
    }

    @Override
    public void deleteRecipeIngredient(Long recipeId, Long ingredientId) {
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(recipeId.intValue());
        id.setIngredientId(ingredientId.intValue());
        recipeIngredientRepo.deleteById(id);
    }
}
