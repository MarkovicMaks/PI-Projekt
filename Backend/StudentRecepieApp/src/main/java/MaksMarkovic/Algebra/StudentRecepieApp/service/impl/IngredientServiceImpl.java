package MaksMarkovic.Algebra.StudentRecepieApp.service.impl;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Ingredient;
import MaksMarkovic.Algebra.StudentRecepieApp.repos.IngredientRepo;
import MaksMarkovic.Algebra.StudentRecepieApp.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepo ingredientRepo;

    @Autowired
    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @Override
    public Optional<Ingredient> getIngredientById(Integer id) {
        return ingredientRepo.findById(id);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @Override
    public List<Ingredient> getIngredientsByName(String name) {
        return ingredientRepo.findByName(name);
    }

    @Override
    public Ingredient updateIngredient(Integer id, Ingredient ingredientDetails) {
        return ingredientRepo.findById(id).map(existingIngredient -> {
            existingIngredient.setName(ingredientDetails.getName());
            return ingredientRepo.save(existingIngredient);
        }).orElseThrow(() -> new RuntimeException("Ingredient not found with id " + id));
    }

    @Override
    public void deleteIngredient(Integer id) {
        if (!ingredientRepo.existsById(id)) {
            throw new RuntimeException("Ingredient not found with id " + id);
        }
        ingredientRepo.deleteById(id);
    }
}
