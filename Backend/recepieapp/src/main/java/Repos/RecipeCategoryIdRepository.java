package Repos;

import Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryIdRepository extends JpaRepository<Category, Integer> {
    // Add custom query methods if needed
}
