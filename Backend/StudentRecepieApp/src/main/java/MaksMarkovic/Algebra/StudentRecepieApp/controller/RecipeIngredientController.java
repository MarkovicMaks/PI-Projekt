package MaksMarkovic.Algebra.StudentRecepieApp.controller;

import MaksMarkovic.Algebra.StudentRecepieApp.models.RecipeIngredient;
import MaksMarkovic.Algebra.StudentRecepieApp.service.RecipeIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @PostMapping
    public ResponseEntity<RecipeIngredient> createRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        return ResponseEntity.ok(recipeIngredientService.saveRecipeIngredient(recipeIngredient));
    }

    @GetMapping("/{recipeId}/{ingredientId}")
    public ResponseEntity<RecipeIngredient> getRecipeIngredientById(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        Optional<RecipeIngredient> recipeIngredient = recipeIngredientService.getRecipeIngredientById(recipeId, ingredientId);
        return recipeIngredient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RecipeIngredient>> getAllRecipeIngredients() {
        return ResponseEntity.ok(recipeIngredientService.getAllRecipeIngredients());
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<RecipeIngredient>> getRecipeIngredientsByRecipeId(@PathVariable Long recipeId) {
        return ResponseEntity.ok(recipeIngredientService.getRecipeIngredientsByRecipeId(recipeId));
    }

    @DeleteMapping("/{recipeId}/{ingredientId}")
    public ResponseEntity<Void> deleteRecipeIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        recipeIngredientService.deleteRecipeIngredient(recipeId, ingredientId);
        return ResponseEntity.noContent().build();
    }
}
