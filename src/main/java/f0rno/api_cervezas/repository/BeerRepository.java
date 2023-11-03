package f0rno.api_cervezas.repository;

import f0rno.api_cervezas.model.Beers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface BeerRepository extends JpaRepository<Beers, Integer> {
}
