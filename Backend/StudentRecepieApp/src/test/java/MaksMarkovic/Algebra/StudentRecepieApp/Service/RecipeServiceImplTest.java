package MaksMarkovic.Algebra.StudentRecepieApp.Service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.RecipeRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("RecipeServiceImpl Test")
public class RecipeServiceImplTest {

    private RecipeRepo recipeRepo;
    private RecipeServiceImpl recipeService;

    @BeforeEach
    public void setUp() {
        recipeRepo = Mockito.mock(RecipeRepo.class);
        recipeService = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    @DisplayName("Test saveRecipe preserves existing createdAt")
    public void testSaveRecipePreservesExistingCreatedAt() {
        // Given
        Instant existingTimestamp = Instant.now();
        Recipe recipe = new Recipe.Builder()
                .title("Healthy Salad")
                .createdAt(existingTimestamp)
                .build();

        when(recipeRepo.save(any(Recipe.class))).thenReturn(recipe);

        // When
        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        // Then
        assertEquals(existingTimestamp, savedRecipe.getCreatedAt(), "The existing createdAt timestamp should be preserved.");
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test saveRecipe sets createdAt if null")
    public void testSaveRecipeSetsCreatedAtIfNull() {
        // Given
        Recipe recipe = new Recipe.Builder()
                .title("Healthy Salad")
                .build();

        Recipe recipeWithCreatedAt = new Recipe.Builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .createdAt(Instant.now())
                .build();

        when(recipeRepo.save(any(Recipe.class))).thenReturn(recipeWithCreatedAt);

        // When
        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        // Then
        assertNotNull(savedRecipe.getCreatedAt(), "The createdAt timestamp should be set.");
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test getRecipeById - Found")
    public void testGetRecipeByIdFound() {
        // Given
        Recipe recipe = new Recipe.Builder()
                .id(1)
                .title("Healthy Salad")
                .build();

        when(recipeRepo.findById(1)).thenReturn(Optional.of(recipe));

        // When
        Optional<Recipe> foundRecipe = recipeService.getRecipeById(1);

        // Then
        assertTrue(foundRecipe.isPresent(), "The recipe should be found.");
        assertEquals(recipe.getId(), foundRecipe.get().getId(), "The ID should match.");
        verify(recipeRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test getRecipeById - Not Found")
    public void testGetRecipeByIdNotFound() {
        // Given
        when(recipeRepo.findById(1)).thenReturn(Optional.empty());

        // When
        Optional<Recipe> foundRecipe = recipeService.getRecipeById(1);

        // Then
        assertFalse(foundRecipe.isPresent(), "The recipe should not be found.");
        verify(recipeRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test getAllRecipes")
    public void testGetAllRecipes() {
        // Given
        Recipe recipe1 = new Recipe.Builder()
                .id(1)
                .title("Healthy Salad")
                .build();

        Recipe recipe2 = new Recipe.Builder()
                .id(2)
                .title("Tasty Soup")
                .build();

        when(recipeRepo.findAll()).thenReturn(Arrays.asList(recipe1, recipe2));

        // When
        List<Recipe> recipes = recipeService.getAllRecipes();

        // Then
        assertNotNull(recipes, "The list of recipes should not be null.");
        assertEquals(2, recipes.size(), "The list size should match.");
        verify(recipeRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getRecipesByUserId")
    public void testGetRecipesByUserId() {
        // Given
        Recipe recipe = new Recipe.Builder()
                .id(1)
                .title("Healthy Salad")
                .build();

        when(recipeRepo.findByUserId(1)).thenReturn(Arrays.asList(recipe));

        // When
        List<Recipe> recipes = recipeService.getRecipesByUserId(1);

        // Then
        assertNotNull(recipes, "The list of recipes should not be null.");
        assertEquals(1, recipes.size(), "The list size should match.");
        verify(recipeRepo, times(1)).findByUserId(1);
    }

    @Test
    @DisplayName("Test searchRecipesByTitle")
    public void testSearchRecipesByTitle() {
        // Given
        Recipe recipe = new Recipe.Builder()
                .id(1)
                .title("Healthy Salad")
                .build();

        when(recipeRepo.findByTitleContainingIgnoreCase("Salad")).thenReturn(Arrays.asList(recipe));

        // When
        List<Recipe> recipes = recipeService.searchRecipesByTitle("Salad");

        // Then
        assertNotNull(recipes, "The list of recipes should not be null.");
        assertEquals(1, recipes.size(), "The list size should match.");
        verify(recipeRepo, times(1)).findByTitleContainingIgnoreCase("Salad");
    }

    @Test
    @DisplayName("Test updateRecipe")
    public void testUpdateRecipe() {
        // Given
        Recipe existingRecipe = new Recipe.Builder()
                .id(1)
                .title("Old Title")
                .build();

        Recipe updatedDetails = new Recipe.Builder()
                .title("New Title")
                .build();

        Recipe updatedRecipe = new Recipe.Builder()
                .id(existingRecipe.getId())
                .title(updatedDetails.getTitle())
                .build();

        when(recipeRepo.findById(1)).thenReturn(Optional.of(existingRecipe));
        when(recipeRepo.save(any(Recipe.class))).thenReturn(updatedRecipe);

        // When
        Recipe result = recipeService.updateRecipe(1, updatedDetails);

        // Then
        assertNotNull(result, "The updated recipe should not be null.");
        assertEquals("New Title", result.getTitle(), "The title should match the updated value.");
        verify(recipeRepo, times(1)).findById(1);
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test deleteRecipe - Found")
    public void testDeleteRecipeFound() {
        // Given
        when(recipeRepo.existsById(1)).thenReturn(true);

        // When
        recipeService.deleteRecipe(1);

        // Then
        verify(recipeRepo, times(1)).existsById(1);
        verify(recipeRepo, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("Test deleteRecipe - Not Found")
    public void testDeleteRecipeNotFound() {
        // Given
        when(recipeRepo.existsById(1)).thenReturn(false);

        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            recipeService.deleteRecipe(1);
        }, "Expected exception when recipe is not found.");

        assertEquals("Recipe not found with id 1", exception.getMessage(), "The exception message should match.");
        verify(recipeRepo, times(1)).existsById(1);
    }
    @Test
    @DisplayName("Test updateRecipe preserves existing fields when details are null")
    public void testUpdateRecipePreservesExistingFields() {
        // Given
        Recipe existingRecipe = new Recipe.Builder()
                .id(1)
                .title("Old Title")
                .description("Old Description")
                .priceTag("$10")
                .healthTag("Healthy")
                .preferenceTag("Vegetarian")
                .createdAt(Instant.now())
                .build();

        Recipe updateDetails = new Recipe.Builder()
                .title("New Title") // Only update title
                .build();

        Recipe updatedRecipe = new Recipe.Builder()
                .id(existingRecipe.getId())
                .title(updateDetails.getTitle())
                .description(existingRecipe.getDescription())
                .priceTag(existingRecipe.getPriceTag())
                .healthTag(existingRecipe.getHealthTag())
                .preferenceTag(existingRecipe.getPreferenceTag())
                .createdAt(existingRecipe.getCreatedAt())
                .build();

        when(recipeRepo.findById(1)).thenReturn(Optional.of(existingRecipe));
        when(recipeRepo.save(any(Recipe.class))).thenReturn(updatedRecipe);

        // When
        Recipe result = recipeService.updateRecipe(1, updateDetails);

        // Then
        assertNotNull(result, "The updated recipe should not be null.");
        assertEquals("New Title", result.getTitle(), "The title should match the updated value.");
        assertEquals("Old Description", result.getDescription(), "The description should remain unchanged.");
        assertEquals("$10", result.getPriceTag(), "The price tag should remain unchanged.");
        verify(recipeRepo, times(1)).findById(1);
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test deleteRecipe throws exception for null ID")
    public void testDeleteRecipeThrowsExceptionForNullId() {
        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            recipeService.deleteRecipe(null);
        }, "Expected exception when recipe ID is null.");

        assertEquals("Recipe not found with id null", exception.getMessage(), "The exception message should match.");
        verify(recipeRepo, times(0)).deleteById(any());
    }


}
