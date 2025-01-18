package MaksMarkovic.Algebra.StudentRecepieApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RecipeIngredientId model test")
public class RecipeIngredientIdTest {

    private RecipeIngredientId recipeIngredientId;

    @BeforeEach
    public void setup() {
        recipeIngredientId = new RecipeIngredientId();
    }

    @Test
    @DisplayName("Test setting and getting Recipe ID")
    public void testSetAndGetRecipeId() {
        // Given
        Integer recipeId = 1;

        // When
        recipeIngredientId.setRecipeId(recipeId);

        // Then
        assertEquals(recipeId, recipeIngredientId.getRecipeId(), "The Recipe ID should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Ingredient ID")
    public void testSetAndGetIngredientId() {
        // Given
        Integer ingredientId = 2;

        // When
        recipeIngredientId.setIngredientId(ingredientId);

        // Then
        assertEquals(ingredientId, recipeIngredientId.getIngredientId(), "The Ingredient ID should match the value that was set.");
    }

    @Test
    @DisplayName("Test equals() method")
    public void testEqualsMethod() {
        // Given
        RecipeIngredientId id1 = new RecipeIngredientId();
        id1.setRecipeId(1);
        id1.setIngredientId(2);

        RecipeIngredientId id2 = new RecipeIngredientId();
        id2.setRecipeId(1);
        id2.setIngredientId(2);

        // When & Then
        assertEquals(id1, id2, "Two RecipeIngredientId objects with the same values should be equal.");
    }

    @Test
    @DisplayName("Test hashCode() method")
    public void testHashCodeMethod() {
        // Given
        RecipeIngredientId id1 = new RecipeIngredientId();
        id1.setRecipeId(1);
        id1.setIngredientId(2);

        RecipeIngredientId id2 = new RecipeIngredientId();
        id2.setRecipeId(1);
        id2.setIngredientId(2);

        // When & Then
        assertEquals(id1.hashCode(), id2.hashCode(), "Two RecipeIngredientId objects with the same values should have the same hashCode.");
    }

    @Test
    @DisplayName("Test equals() with different objects")
    public void testEqualsWithDifferentObjects() {
        // Given
        RecipeIngredientId id1 = new RecipeIngredientId();
        id1.setRecipeId(1);
        id1.setIngredientId(2);

        RecipeIngredientId id2 = new RecipeIngredientId();
        id2.setRecipeId(1);
        id2.setIngredientId(3);

        // When & Then
        assertNotEquals(id1, id2, "Two RecipeIngredientId objects with different values should not be equal.");
    }

    @Test
    @DisplayName("Test no-args constructor")
    public void testNoArgsConstructor() {
        // Given & When
        RecipeIngredientId recipeIngredientId = new RecipeIngredientId();

        // Then
        assertNotNull(recipeIngredientId, "The RecipeIngredientId object should not be null.");
        assertNull(recipeIngredientId.getRecipeId(), "The Recipe ID should be null when using the no-args constructor.");
        assertNull(recipeIngredientId.getIngredientId(), "The Ingredient ID should be null when using the no-args constructor.");
    }

    @Test
    @DisplayName("Test equals() with null")
    public void testEqualsWithNull() {
        // Given
        RecipeIngredientId id = new RecipeIngredientId();
        id.setRecipeId(1);
        id.setIngredientId(2);

        // When & Then
        assertNotEquals(id, null, "A RecipeIngredientId object should not be equal to null.");
    }

}
