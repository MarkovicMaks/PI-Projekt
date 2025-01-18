package MaksMarkovic.Algebra.StudentRecepieApp.Service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import MaksMarkovic.Algebra.StudentRecepieApp.models.User;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.RecipeRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    @Mock
    private RecipeRepo recipeRepo;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test saveRecipe with a User object")
    public void testSaveRecipeWithUserObject() {
        // Given: Create a User object
        User user = new User();
        user.setId(1);
        user.setFullName("John Doe");
        user.setEmail("johndoe@example.com");
        user.setPassword("securepassword");
        user.setCreatedAt(Instant.now());
        user.setRole("user");

        // Create a Recipe object with the User object
        Recipe recipe = new Recipe.Builder()
                .id(1)
                .user(user) // Set the user object
                .title("Full Recipe")
                .description("This is a full recipe")
                .priceTag("Premium")
                .healthTag("Healthy")
                .preferenceTag("Vegan")
                .createdAt(Instant.now())
                .build();

        when(recipeRepo.save(any(Recipe.class))).thenReturn(recipe);

        // When
        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        // Then
        assertNotNull(savedRecipe, "The saved recipe should not be null.");
        assertEquals("Full Recipe", savedRecipe.getTitle(), "The title should match.");
        assertNotNull(savedRecipe.getUser(), "The user object should not be null.");
        assertEquals("John Doe", savedRecipe.getUser().getFullName(), "The user's full name should match.");
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test getRecipeById with existing recipe")
    public void testGetRecipeByIdWithExistingRecipe() {
        Recipe recipe = new Recipe.Builder().id(1).title("Test Recipe").build();
        when(recipeRepo.findById(1)).thenReturn(Optional.of(recipe));

        Optional<Recipe> result = recipeService.getRecipeById(1);

        assertTrue(result.isPresent(), "Recipe should be found");
        assertEquals("Test Recipe", result.get().getTitle(), "The title should match");
        verify(recipeRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test getRecipeById with non-existing recipe")
    public void testGetRecipeByIdWithNonExistingRecipe() {
        when(recipeRepo.findById(999)).thenReturn(Optional.empty());

        Optional<Recipe> result = recipeService.getRecipeById(999);

        assertFalse(result.isPresent(), "Recipe should not be found");
        verify(recipeRepo, times(1)).findById(999);
    }
    @Test
    @DisplayName("Test getAllRecipes returns a list of recipes")
    public void testGetAllRecipes() {
        Recipe recipe1 = new Recipe.Builder().id(1).title("Recipe 1").build();
        Recipe recipe2 = new Recipe.Builder().id(2).title("Recipe 2").build();

        when(recipeRepo.findAll()).thenReturn(List.of(recipe1, recipe2));

        List<Recipe> recipes = recipeService.getAllRecipes();

        assertNotNull(recipes, "Recipes list should not be null");
        assertEquals(2, recipes.size(), "Recipes list should contain 2 recipes");
        verify(recipeRepo, times(1)).findAll();
    }
    @Test
    @DisplayName("Test searchRecipesByTitle returns matching recipes")
    public void testSearchRecipesByTitle() {
        Recipe recipe = new Recipe.Builder().id(1).title("Chocolate Cake").build();
        when(recipeRepo.findByTitleContainingIgnoreCase("cake")).thenReturn(List.of(recipe));

        List<Recipe> recipes = recipeService.searchRecipesByTitle("cake");

        assertNotNull(recipes, "Recipes list should not be null");
        assertEquals(1, recipes.size(), "Recipes list should contain 1 recipe");
        assertEquals("Chocolate Cake", recipes.get(0).getTitle(), "The recipe title should match");
        verify(recipeRepo, times(1)).findByTitleContainingIgnoreCase("cake");
    }
    @Test
    @DisplayName("Test updateRecipe throws exception for null details")
    public void testUpdateRecipeWithNullDetails() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> recipeService.updateRecipe(1, null));
        assertEquals("Recipe details must not be null", exception.getMessage());
        verify(recipeRepo, never()).findById(any());
        verify(recipeRepo, never()).save(any());
    }
    @Test
    @DisplayName("Test updateRecipe throws exception for non-existing recipe")
    public void testUpdateRecipeWithNonExistingRecipe() {
        Recipe updatedDetails = new Recipe.Builder().title("Updated Title").build();
        when(recipeRepo.findById(999)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> recipeService.updateRecipe(999, updatedDetails));
        assertEquals("Recipe not found with id 999", exception.getMessage());
        verify(recipeRepo, times(1)).findById(999);
        verify(recipeRepo, never()).save(any());
    }

    @Test
    @DisplayName("Test getRecipesByUserId returns recipes for a user")
    public void testGetRecipesByUserId() {
        Recipe recipe = new Recipe.Builder().id(1).title("User's Recipe").build();
        when(recipeRepo.findByUserId(1)).thenReturn(List.of(recipe));

        List<Recipe> recipes = recipeService.getRecipesByUserId(1);

        assertNotNull(recipes, "Recipes list should not be null");
        assertEquals(1, recipes.size(), "Recipes list should contain 1 recipe");
        assertEquals("User's Recipe", recipes.get(0).getTitle(), "The recipe title should match");
        verify(recipeRepo, times(1)).findByUserId(1);
    }

    @Test
    @DisplayName("Test saveRecipe with missing optional fields")
    public void testSaveRecipeWithMissingOptionalFields() {
        // Given
        Recipe recipe = new Recipe.Builder()
                .id(2)
                .title("Partial Recipe")
                .build();

        when(recipeRepo.save(any(Recipe.class))).thenReturn(recipe);

        // When
        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        // Then
        assertNotNull(savedRecipe, "The saved recipe should not be null.");
        assertEquals("Partial Recipe", savedRecipe.getTitle(), "The title should match.");
        assertNull(savedRecipe.getDescription(), "The description should be null.");
        assertNull(savedRecipe.getUser(), "The user should be null.");
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test updateRecipe with partial updates")
    public void testUpdateRecipeWithPartialUpdates() {
        // Given
        Recipe existingRecipe = new Recipe.Builder()
                .id(1)
                .title("Original Title")
                .description("Original Description")
                .priceTag("Budget")
                .healthTag("Healthy")
                .preferenceTag("Vegetarian")
                .createdAt(Instant.now())
                .build();

        Recipe updatedDetails = new Recipe.Builder()
                .title("Updated Title")
                .priceTag("Premium")
                .build();

        when(recipeRepo.findById(1)).thenReturn(Optional.of(existingRecipe));
        when(recipeRepo.save(any(Recipe.class))).thenReturn(existingRecipe);

        // When
        Recipe updatedRecipe = recipeService.updateRecipe(1, updatedDetails);

        // Then
        assertNotNull(updatedRecipe, "The updated recipe should not be null.");
        assertEquals("Original Title", updatedRecipe.getTitle(), "The title should be updated.");
        assertEquals("Original Description", updatedRecipe.getDescription(), "The description should remain unchanged.");
        assertEquals("Budget", updatedRecipe.getPriceTag(), "The price tag should be updated.");
        verify(recipeRepo, times(1)).findById(1);
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }

    @Test
    @DisplayName("Test Builder with default values for unset fields")
    public void testBuilderWithDefaultValues() {
        // Given
        Instant now = Instant.now();
        Recipe recipe = new Recipe.Builder()
                .id(1)
                .title("Recipe With Defaults")
                .createdAt(now)
                .build();

        // When
        assertNull(recipe.getDescription(), "Description should be null when unset.");
        assertNull(recipe.getUser(), "User should be null when unset.");
        assertEquals("Recipe With Defaults", recipe.getTitle(), "The title should match.");
        assertEquals(now, recipe.getCreatedAt(), "The creation timestamp should match.");
    }

    @Test
    @DisplayName("Test deleteRecipe with valid ID")
    public void testDeleteRecipeWithValidId() {
        // Given
        when(recipeRepo.existsById(1)).thenReturn(true);

        // When
        recipeService.deleteRecipe(1);

        // Then
        verify(recipeRepo, times(1)).existsById(1);
        verify(recipeRepo, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("Test deleteRecipe with invalid ID")
    public void testDeleteRecipeWithInvalidId() {
        // Given
        when(recipeRepo.existsById(999)).thenReturn(false);

        // When / Then
        Exception exception = assertThrows(RuntimeException.class, () -> recipeService.deleteRecipe(999));
        assertEquals("Recipe not found with id 999", exception.getMessage(), "The exception message should match.");
        verify(recipeRepo, times(1)).existsById(999);
        verify(recipeRepo, never()).deleteById(any());
    }
}
