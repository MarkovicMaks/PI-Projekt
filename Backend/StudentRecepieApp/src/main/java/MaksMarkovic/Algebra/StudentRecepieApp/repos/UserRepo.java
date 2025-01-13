package MaksMarkovic.Algebra.StudentRecepieApp.repos;

import MaksMarkovic.Algebra.StudentRecepieApp.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Recipe, Integer> {

    // jap doda ti basic cruud
}
