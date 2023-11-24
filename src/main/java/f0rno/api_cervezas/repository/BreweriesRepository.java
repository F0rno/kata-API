package f0rno.api_cervezas.repository;

import f0rno.api_cervezas.model.Breweries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweriesRepository  extends JpaRepository<Breweries, Integer> {
    Page<Breweries> findAll(Pageable pageable);
}
