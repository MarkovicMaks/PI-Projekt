package MaksMarkovic.Algebra.StudentRecepieApp.controllers;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import MaksMarkovic.Algebra.StudentRecepieApp.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RecipeService recipeService;

    @Test
    public void testGetAllRecipes() throws Exception {
        // Mock data
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setTitle("Test Recipe");
        recipe.setDescription("This is a test recipe");
        recipe.setPriceTag("$");
        recipe.setHealthTag("Healthy");
        recipe.setPreferenceTag("Vegan");
        when(recipeService.getAllRecipes()).thenReturn(Collections.singletonList(recipe));

        // Perform GET request
        mockMvc.perform(get("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Test Recipe")))
                .andExpect(jsonPath("$[0].description", is("This is a test recipe")));
    }

    @Test
    public void testGetRecipeById() throws Exception {
        // Mock data
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setTitle("Test Recipe");
        when(recipeService.getRecipeById(1)).thenReturn(Optional.of(recipe));

        // Perform GET request
        mockMvc.perform(get("/api/recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Test Recipe")));
    }

    @Test
    public void testCreateRecipe() throws Exception {
        // Mock data
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setTitle("Test Recipe");
        recipe.setDescription("A test recipe for testing");

        // Perform POST request
        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recipe)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Test Recipe")));
    }

    @Test
    public void testDeleteRecipe() throws Exception {
        // Mock the delete behavior
        doNothing().when(recipeService).deleteRecipe(1);

        // Perform DELETE request
        mockMvc.perform(delete("/api/recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
