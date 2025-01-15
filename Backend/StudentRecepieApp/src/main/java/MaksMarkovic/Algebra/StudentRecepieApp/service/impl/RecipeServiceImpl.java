package MaksMarkovic.Algebra.StudentRecepieApp.service.impl;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.RecipeRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;

    @Autowired
    public RecipeServiceImpl(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        // Set creation timestamp if it's a new recipe
        if (recipe.getCreatedAt() == null) {
            recipe.setCreatedAt(Instant.now());
        }
        return recipeRepo.save(recipe);
    }

    @Override
    public Optional<Recipe> getRecipeById(Integer id) {
        return recipeRepo.findById(id);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    @Override
    public List<Recipe> getRecipesByUserId(Integer userId) {
        return recipeRepo.findByUserId(userId);
    }

    @Override
    public List<Recipe> searchRecipesByTitle(String title) {
        return recipeRepo.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Recipe updateRecipe(Integer id, Recipe recipeDetails) {
        return recipeRepo.findById(id).map(existingRecipe -> {
            existingRecipe.setTitle(recipeDetails.getTitle());
            existingRecipe.setDescription(recipeDetails.getDescription());
            existingRecipe.setPriceTag(recipeDetails.getPriceTag());
            existingRecipe.setHealthTag(recipeDetails.getHealthTag());
            existingRecipe.setPreferenceTag(recipeDetails.getPreferenceTag());
            return recipeRepo.save(existingRecipe);
        }).orElseThrow(() -> new RuntimeException("Recipe not found with id " + id));
    }

    @Override
    public void deleteRecipe(Integer id) {
        if (!recipeRepo.existsById(id)) {
            throw new RuntimeException("Recipe not found with id " + id);
        }
        recipeRepo.deleteById(id);
    }
}
