package MaksMarkovic.Algebra.StudentRecepieApp.controllers;

import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RecipeServiceImpl recipeService;


//    @Test
//    void createRecipe() throws Exception {
//        String recipeJson = "{\"title\":\"Test Recipe\",\"description\":\"Delicious test recipe\",\"priceTag\":\"$\",\"healthTag\":\"Day to day\",\"preferenceTag\":\"Omnivore\"}";
//
//        // Perform POST request
//        mockMvc.perform(post("/api/recipes")
//                        .content(recipeJson)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(content().encoding(StandardCharsets.UTF_8));
//
//        // Verify the recipe is created in the database
//        List<Recipe> recipes = RecipeRepo.findAll();
//        assertEquals(1, recipes.size());
//        Recipe createdRecipe = recipes.get(0);
//        assertEquals("Test Recipe", createdRecipe.getTitle());
//        assertEquals("Delicious test recipe", createdRecipe.getDescription());
//    }


    @Test
    void getRecipeById_Found() throws Exception {
        int recipeId = 11;

        mockMvc.perform(get("/api/recipes/" + recipeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Spaghetti Bolognese"));
    }

    @Test
    void getRecipeById_NotFound() throws Exception {
        mockMvc.perform(get("/api/recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    void getAllRecipes() throws Exception {
        mockMvc.perform(get("/api/recipes")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer some_token")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding(StandardCharsets.UTF_8));
    }


//    @Test
//    void deleteRecipe() throws Exception {
//        int recipeId = 1;
//
//        // Ensure the database has a recipe with ID 1
//        Recipe recipe = new Recipe();
//        recipe.setId(recipeId);
//        recipe.setTitle("Test Recipe");
//        recipe.setDescription("This is a test recipe.");
//        recipe.setPriceTag("$");
//        recipe.setHealthTag("Day to day");
//        recipe.setPreferenceTag("Omnivore");
//        recipe.setCreatedAt(Instant.now());
//        recipeRepo.save(recipe); // Use your repository to save test data
//
//        // Perform DELETE request
//        mockMvc.perform(delete("/api/recipes/" + recipeId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//
//        // Verify the recipe is deleted
//        assertFalse(recipeRepository.findById(recipeId).isPresent());
//    }
}
