package f0rno.api_cervezas.repository;

import f0rno.api_cervezas.model.Beers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeerRepository extends JpaRepository<Beers, Integer> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Beers b WHERE b.name = :name")
    boolean existsByName(String name);
}
