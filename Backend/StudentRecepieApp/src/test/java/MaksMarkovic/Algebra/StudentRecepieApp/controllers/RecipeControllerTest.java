package MaksMarkovic.Algebra.StudentRecepieApp.controllers;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import MaksMarkovic.Algebra.StudentRecepieApp.service.RecipeService;
import MaksMarkovic.Algebra.StudentRecepieApp.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RecipeServiceImpl recipeService;

    @Test
    void createRecipe() throws Exception {
        String recipeJson = "{\"title\":\"Test Recipe\",\"description\":\"Delicious test recipe\"}";

        mockMvc.perform(post("/api/recipes")
                        .content(recipeJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding(StandardCharsets.UTF_8));
    }

    @Test
    void getRecipeById_Found() throws Exception {
        int recipeId = 1;
        Mockito.when(recipeService.getRecipeById(recipeId)).thenReturn(Optional.of(new Recipe(recipeId, "Test Recipe", "Test Description")));

        mockMvc.perform(get("/api/recipes/" + recipeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(jsonPath("$.title").value("Test Recipe"));
    }

    @Test
    void getRecipeById_NotFound() throws Exception {
        int recipeId = 11;
        Mockito.when(recipeService.getRecipeById(recipeId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/recipes/" + recipeId)
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

    @Test
    void deleteRecipe() throws Exception {
        int recipeId = 1;

        mockMvc.perform(delete("/api/recipes/" + recipeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
