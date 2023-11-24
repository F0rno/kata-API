package f0rno.api_cervezas.service;

import f0rno.api_cervezas.error.style.StyleNotFoundException;
import f0rno.api_cervezas.model.Styles;
import f0rno.api_cervezas.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StylesService {
    StyleRepository styleRepository;
    @Autowired
    public StylesService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }
    public List<Styles> getAllStyles() {
        return styleRepository.findAll();
    }
    public ResponseEntity<Styles> getStyle(int id) throws StyleNotFoundException {
        return styleRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElseThrow(() -> new StyleNotFoundException(id));
    }
}
