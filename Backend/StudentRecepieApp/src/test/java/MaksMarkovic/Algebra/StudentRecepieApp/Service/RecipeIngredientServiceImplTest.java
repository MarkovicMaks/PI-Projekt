package MaksMarkovic.Algebra.StudentRecepieApp.Service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredient;
import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredientId;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.RecipeIngredientRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.RecipeIngredientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("RecipeIngredientServiceImpl Test")
public class RecipeIngredientServiceImplTest {

    private RecipeIngredientRepo recipeIngredientRepo;
    private RecipeIngredientServiceImpl recipeIngredientService;

    @BeforeEach
    public void setUp() {
        recipeIngredientRepo = Mockito.mock(RecipeIngredientRepo.class);
        recipeIngredientService = new RecipeIngredientServiceImpl(recipeIngredientRepo);
    }

    @Test
    @DisplayName("Test saveRecipeIngredient")
    public void testSaveRecipeIngredient() {
        // Given
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(1);
        id.setIngredientId(2);
        recipeIngredient.setId(id);

        when(recipeIngredientRepo.save(recipeIngredient)).thenReturn(recipeIngredient);

        // When
        RecipeIngredient savedRecipeIngredient = recipeIngredientService.saveRecipeIngredient(recipeIngredient);

        // Then
        assertNotNull(savedRecipeIngredient, "The saved RecipeIngredient should not be null.");
        assertEquals(id, savedRecipeIngredient.getId(), "The ID should match.");
        verify(recipeIngredientRepo, times(1)).save(recipeIngredient);
    }

    @Test
    @DisplayName("Test getRecipeIngredientById - Found")
    public void testGetRecipeIngredientByIdFound() {
        // Given
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(1);
        id.setIngredientId(2);

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setId(id);

        when(recipeIngredientRepo.findById(id)).thenReturn(Optional.of(recipeIngredient));

        // When
        Optional<RecipeIngredient> foundRecipeIngredient = recipeIngredientService.getRecipeIngredientById(1L, 2L);

        // Then
        assertTrue(foundRecipeIngredient.isPresent(), "The RecipeIngredient should be found.");
        assertEquals(id, foundRecipeIngredient.get().getId(), "The ID should match.");
        verify(recipeIngredientRepo, times(1)).findById(id);
    }

    @Test
    @DisplayName("Test getRecipeIngredientById - Not Found")
    public void testGetRecipeIngredientByIdNotFound() {
        // Given
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(1);
        id.setIngredientId(2);

        when(recipeIngredientRepo.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<RecipeIngredient> foundRecipeIngredient = recipeIngredientService.getRecipeIngredientById(1L, 2L);

        // Then
        assertFalse(foundRecipeIngredient.isPresent(), "The RecipeIngredient should not be found.");
        verify(recipeIngredientRepo, times(1)).findById(id);
    }

    @Test
    @DisplayName("Test getAllRecipeIngredients")
    public void testGetAllRecipeIngredients() {
        // Given
        RecipeIngredient ingredient1 = new RecipeIngredient();
        RecipeIngredient ingredient2 = new RecipeIngredient();

        when(recipeIngredientRepo.findAll()).thenReturn(Arrays.asList(ingredient1, ingredient2));

        // When
        List<RecipeIngredient> ingredients = recipeIngredientService.getAllRecipeIngredients();

        // Then
        assertNotNull(ingredients, "The list of RecipeIngredients should not be null.");
        assertEquals(2, ingredients.size(), "The list size should match.");
        verify(recipeIngredientRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getRecipeIngredientsByRecipeId")
    public void testGetRecipeIngredientsByRecipeId() {
        // Given
        RecipeIngredient ingredient = new RecipeIngredient();

        when(recipeIngredientRepo.findByRecipeId(1L)).thenReturn(Arrays.asList(ingredient));

        // When
        List<RecipeIngredient> ingredients = recipeIngredientService.getRecipeIngredientsByRecipeId(1L);

        // Then
        assertNotNull(ingredients, "The list of RecipeIngredients should not be null.");
        assertEquals(1, ingredients.size(), "The list size should match.");
        verify(recipeIngredientRepo, times(1)).findByRecipeId(1L);
    }

    @Test
    @DisplayName("Test deleteRecipeIngredient")
    public void testDeleteRecipeIngredient() {
        // Given
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(1);
        id.setIngredientId(2);

        doNothing().when(recipeIngredientRepo).deleteById(id);

        // When
        recipeIngredientService.deleteRecipeIngredient(1L, 2L);

        // Then
        verify(recipeIngredientRepo, times(1)).deleteById(id);
    }
}
