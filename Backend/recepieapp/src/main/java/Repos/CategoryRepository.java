package Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Add custom query methods if needed
}
