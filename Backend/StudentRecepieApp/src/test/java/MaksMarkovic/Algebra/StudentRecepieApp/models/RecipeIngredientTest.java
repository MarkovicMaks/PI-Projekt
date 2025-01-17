package MaksMarkovic.Algebra.StudentRecepieApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RecipeIngredient model test")
public class RecipeIngredientTest {

    private RecipeIngredient recipeIngredient;

    @BeforeEach
    public void setup() {
        recipeIngredient = new RecipeIngredient();
    }



    @Test
    @DisplayName("Test setting and getting Recipe")
    public void testSetAndGetRecipe() {
        // Given
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setTitle("Healthy Salad");

        // When
        recipeIngredient.setRecipe(recipe);

        // Then
        assertEquals(recipe, recipeIngredient.getRecipe(), "The Recipe should match the value that was set.");
        assertEquals(1, recipeIngredient.getRecipe().getId(), "The Recipe ID should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Ingredient")
    public void testSetAndGetIngredient() {
        // Given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(2);
        ingredient.setName("Tomato");

        // When
        recipeIngredient.setIngredient(ingredient);

        // Then
        assertEquals(ingredient, recipeIngredient.getIngredient(), "The Ingredient should match the value that was set.");
        assertEquals(2, recipeIngredient.getIngredient().getId(), "The Ingredient ID should match the value that was set.");
    }

    @Test
    @DisplayName("Test no-args constructor")
    public void testNoArgsConstructor() {
        // Given & When
        RecipeIngredient recipeIngredient = new RecipeIngredient();

        // Then
        assertNotNull(recipeIngredient, "The RecipeIngredient object should not be null.");
        assertNull(recipeIngredient.getId(), "The RecipeIngredientId should be null when using the no-args constructor.");
        assertNull(recipeIngredient.getRecipe(), "The Recipe should be null when using the no-args constructor.");
        assertNull(recipeIngredient.getIngredient(), "The Ingredient should be null when using the no-args constructor.");
    }
}
