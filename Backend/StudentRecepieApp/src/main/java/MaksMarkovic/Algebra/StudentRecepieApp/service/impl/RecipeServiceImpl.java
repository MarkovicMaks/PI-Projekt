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
        // Use Builder to ensure immutability and set creation timestamp if necessary
        Recipe builtRecipe = new Recipe.Builder()
                .id(recipe.getId())
                .user(recipe.getUser())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .priceTag(recipe.getPriceTag())
                .healthTag(recipe.getHealthTag())
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(recipe.getCreatedAt() != null ? recipe.getCreatedAt() : Instant.now())
                .build();

        return recipeRepo.save(builtRecipe);
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
        if (recipeDetails == null) {
            throw new IllegalArgumentException("Recipe details must not be null");
        }

        return recipeRepo.findById(id).map(existingRecipe -> {
            // Use Builder to create an updated recipe while preserving existing fields
            Recipe updatedRecipe = new Recipe.Builder()
                    .id(existingRecipe.getId())
                    .user(existingRecipe.getUser())
                    .title(recipeDetails.getTitle() != null ? recipeDetails.getTitle() : existingRecipe.getTitle())
                    .description(recipeDetails.getDescription() != null ? recipeDetails.getDescription() : existingRecipe.getDescription())
                    .priceTag(recipeDetails.getPriceTag() != null ? recipeDetails.getPriceTag() : existingRecipe.getPriceTag())
                    .healthTag(recipeDetails.getHealthTag() != null ? recipeDetails.getHealthTag() : existingRecipe.getHealthTag())
                    .preferenceTag(recipeDetails.getPreferenceTag() != null ? recipeDetails.getPreferenceTag() : existingRecipe.getPreferenceTag())
                    .createdAt(existingRecipe.getCreatedAt())
                    .build();

            return recipeRepo.save(updatedRecipe);
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
