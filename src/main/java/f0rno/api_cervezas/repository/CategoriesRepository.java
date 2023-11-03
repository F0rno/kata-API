package f0rno.api_cervezas.repository;

import f0rno.api_cervezas.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}