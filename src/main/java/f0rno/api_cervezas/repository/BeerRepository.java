package f0rno.api_cervezas.repository;

import f0rno.api_cervezas.model.Beers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beers, Integer> {
}
