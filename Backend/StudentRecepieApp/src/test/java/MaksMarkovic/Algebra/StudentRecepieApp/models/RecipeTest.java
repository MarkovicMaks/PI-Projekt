package MaksMarkovic.Algebra.StudentRecepieApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Recipe model test")
public class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    public void setup() {
        // Use the builder to create a default Recipe instance
        recipe = new Recipe.Builder()
                .id(1)
                .title("Default Title")
                .description("Default Description")
                .priceTag("$0")
                .healthTag("Healthy")
                .preferenceTag("Vegetarian")
                .createdAt(Instant.now())
                .build();
    }

    @Test
    @DisplayName("Test setting and getting ID")
    public void testSetAndGetId() {
        // Given
        Integer id = 2;

        // When
        recipe = new Recipe.Builder()
                .id(id)
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .priceTag(recipe.getPriceTag())
                .healthTag(recipe.getHealthTag())
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(recipe.getCreatedAt())
                .build();

        // Then
        assertEquals(id, recipe.getId(), "The ID should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Title")
    public void testSetAndGetTitle() {
        // Given
        String title = "Healthy Salad";

        // When
        recipe = new Recipe.Builder()
                .id(recipe.getId())
                .title(title)
                .description(recipe.getDescription())
                .priceTag(recipe.getPriceTag())
                .healthTag(recipe.getHealthTag())
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(recipe.getCreatedAt())
                .build();

        // Then
        assertEquals(title, recipe.getTitle(), "The title should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Description")
    public void testSetAndGetDescription() {
        // Given
        String description = "A delicious and healthy salad recipe.";

        // When
        recipe = new Recipe.Builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(description)
                .priceTag(recipe.getPriceTag())
                .healthTag(recipe.getHealthTag())
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(recipe.getCreatedAt())
                .build();

        // Then
        assertEquals(description, recipe.getDescription(), "The description should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Price Tag")
    public void testSetAndGetPriceTag() {
        // Given
        String priceTag = "$10";

        // When
        recipe = new Recipe.Builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .priceTag(priceTag)
                .healthTag(recipe.getHealthTag())
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(recipe.getCreatedAt())
                .build();

        // Then
        assertEquals(priceTag, recipe.getPriceTag(), "The price tag should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Health Tag")
    public void testSetAndGetHealthTag() {
        // Given
        String healthTag = "Low Calories";

        // When
        recipe = new Recipe.Builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .priceTag(recipe.getPriceTag())
                .healthTag(healthTag)
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(recipe.getCreatedAt())
                .build();

        // Then
        assertEquals(healthTag, recipe.getHealthTag(), "The health tag should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Preference Tag")
    public void testSetAndGetPreferenceTag() {
        // Given
        String preferenceTag = "Vegan";

        // When
        recipe = new Recipe.Builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .priceTag(recipe.getPriceTag())
                .healthTag(recipe.getHealthTag())
                .preferenceTag(preferenceTag)
                .createdAt(recipe.getCreatedAt())
                .build();

        // Then
        assertEquals(preferenceTag, recipe.getPreferenceTag(), "The preference tag should match the value that was set.");
    }

    @Test
    @DisplayName("Test setting and getting Created At")
    public void testSetAndGetCreatedAt() {
        // Given
        Instant createdAt = Instant.now();

        // When
        recipe = new Recipe.Builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .priceTag(recipe.getPriceTag())
                .healthTag(recipe.getHealthTag())
                .preferenceTag(recipe.getPreferenceTag())
                .createdAt(createdAt)
                .build();

        // Then
        assertEquals(createdAt, recipe.getCreatedAt(), "The createdAt timestamp should match the value that was set.");
    }

    @Test
    @DisplayName("Test no-args constructor")
    public void testNoArgsConstructor() {
        // Given & When
        Recipe recipe = new Recipe();

        // Then
        assertNotNull(recipe, "The recipe object should not be null.");
        assertNull(recipe.getId(), "The ID should be null when using the no-args constructor.");
        assertNull(recipe.getUser(), "The user should be null when using the no-args constructor.");
        assertNull(recipe.getTitle(), "The title should be null when using the no-args constructor.");
        assertNull(recipe.getDescription(), "The description should be null when using the no-args constructor.");
        assertNull(recipe.getPriceTag(), "The price tag should be null when using the no-args constructor.");
        assertNull(recipe.getHealthTag(), "The health tag should be null when using the no-args constructor.");
        assertNull(recipe.getPreferenceTag(), "The preference tag should be null when using the no-args constructor.");
        assertNull(recipe.getCreatedAt(), "The createdAt timestamp should be null when using the no-args constructor.");
    }
}
