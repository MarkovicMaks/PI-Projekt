package MaksMarkovic.Algebra.StudentRecepieApp.repos;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Ingredient;
import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

    // jap doda ti basic cruud

    List<Ingredient> findByName(String name);
}