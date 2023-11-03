package f0rno.api_cervezas.repository;

import f0rno.api_cervezas.model.Styles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Styles, Integer> {
}
