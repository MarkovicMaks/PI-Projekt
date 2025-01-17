package MaksMarkovic.Algebra.StudentRecepieApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ingredient model test")
public class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setup() {
        ingredient = new Ingredient();
    }

    @Test
    @DisplayName("Test setting and getting ID")
    public void testSetAndGetId() {
        // Given
        Integer id = 1;

        // When
        ingredient.setId(id);

        // Then
        assertEquals(id, ingredient.getId(), "The ID should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting name")
    public void testSetAndGetName() {
        // Given
        String name = "Tomato";

        // When
        ingredient.setName(name);

        // Then
        assertEquals(name, ingredient.getName(), "The name should match the value that was set.");
    }

    @Test
    @DisplayName("Test no-args constructor")
    public void testNoArgsConstructor() {
        // Given & When
        Ingredient ingredient = new Ingredient();

        // Then
        assertNotNull(ingredient, "The ingredient object should not be null.");
        assertNull(ingredient.getId(), "The ID should be null when using the no-args constructor.");
        assertNull(ingredient.getName(), "The name should be null when using the no-args constructor.");
    }
}
