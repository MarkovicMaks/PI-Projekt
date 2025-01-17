package MaksMarkovic.Algebra.StudentRecepieApp.Service;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Ingredient;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.IngredientRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("IngredientServiceImpl Test")
public class IngredientServiceImplTest {

    private IngredientRepo ingredientRepo;
    private IngredientServiceImpl ingredientService;

    @BeforeEach
    public void setUp() {
        ingredientRepo = Mockito.mock(IngredientRepo.class);
        ingredientService = new IngredientServiceImpl(ingredientRepo);
    }

    @Test
    @DisplayName("Test saveIngredient")
    public void testSaveIngredient() {
        // Given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("Tomato");

        when(ingredientRepo.save(ingredient)).thenReturn(ingredient);

        // When
        Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);

        // Then
        assertNotNull(savedIngredient, "The saved ingredient should not be null.");
        assertEquals(ingredient.getId(), savedIngredient.getId(), "The ID should match.");
        assertEquals(ingredient.getName(), savedIngredient.getName(), "The name should match.");
        verify(ingredientRepo, times(1)).save(ingredient);
    }

    @Test
    @DisplayName("Test getIngredientById - Found")
    public void testGetIngredientByIdFound() {
        // Given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("Tomato");

        when(ingredientRepo.findById(1)).thenReturn(Optional.of(ingredient));

        // When
        Optional<Ingredient> foundIngredient = ingredientService.getIngredientById(1);

        // Then
        assertTrue(foundIngredient.isPresent(), "The ingredient should be found.");
        assertEquals(ingredient.getId(), foundIngredient.get().getId(), "The ID should match.");
        verify(ingredientRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test getIngredientById - Not Found")
    public void testGetIngredientByIdNotFound() {
        // Given
        when(ingredientRepo.findById(1)).thenReturn(Optional.empty());

        // When
        Optional<Ingredient> foundIngredient = ingredientService.getIngredientById(1);

        // Then
        assertFalse(foundIngredient.isPresent(), "The ingredient should not be found.");
        verify(ingredientRepo, times(1)).findById(1);
    }

    @Test
    @DisplayName("Test getAllIngredients")
    public void testGetAllIngredients() {
        // Given
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1);
        ingredient1.setName("Tomato");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2);
        ingredient2.setName("Potato");

        when(ingredientRepo.findAll()).thenReturn(Arrays.asList(ingredient1, ingredient2));

        // When
        List<Ingredient> ingredients = ingredientService.getAllIngredients();

        // Then
        assertNotNull(ingredients, "The ingredient list should not be null.");
        assertEquals(2, ingredients.size(), "The list size should match.");
        verify(ingredientRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getIngredientsByName")
    public void testGetIngredientsByName() {
        // Given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("Tomato");

        when(ingredientRepo.findByName("Tomato")).thenReturn(Arrays.asList(ingredient));

        // When
        List<Ingredient> ingredients = ingredientService.getIngredientsByName("Tomato");

        // Then
        assertNotNull(ingredients, "The ingredient list should not be null.");
        assertEquals(1, ingredients.size(), "The list size should match.");
        verify(ingredientRepo, times(1)).findByName("Tomato");
    }

    @Test
    @DisplayName("Test updateIngredient")
    public void testUpdateIngredient() {
        // Given
        Ingredient existingIngredient = new Ingredient();
        existingIngredient.setId(1);
        existingIngredient.setName("Old Name");

        Ingredient updatedDetails = new Ingredient();
        updatedDetails.setName("New Name");

        when(ingredientRepo.findById(1)).thenReturn(Optional.of(existingIngredient));
        when(ingredientRepo.save(existingIngredient)).thenReturn(existingIngredient);

        // When
        Ingredient updatedIngredient = ingredientService.updateIngredient(1, updatedDetails);

        // Then
        assertNotNull(updatedIngredient, "The updated ingredient should not be null.");
        assertEquals("New Name", updatedIngredient.getName(), "The name should match the updated value.");
        verify(ingredientRepo, times(1)).findById(1);
        verify(ingredientRepo, times(1)).save(existingIngredient);
    }

    @Test
    @DisplayName("Test deleteIngredient - Found")
    public void testDeleteIngredientFound() {
        // Given
        when(ingredientRepo.existsById(1)).thenReturn(true);

        // When
        ingredientService.deleteIngredient(1);

        // Then
        verify(ingredientRepo, times(1)).existsById(1);
        verify(ingredientRepo, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("Test deleteIngredient - Not Found")
    public void testDeleteIngredientNotFound() {
        // Given
        when(ingredientRepo.existsById(1)).thenReturn(false);

        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ingredientService.deleteIngredient(1);
        }, "Expected exception when ingredient is not found.");

        assertEquals("Ingredient not found with id 1", exception.getMessage(), "The exception message should match.");
        verify(ingredientRepo, times(1)).existsById(1);
    }
}
