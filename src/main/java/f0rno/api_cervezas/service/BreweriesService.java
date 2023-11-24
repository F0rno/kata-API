package f0rno.api_cervezas.service;

import f0rno.api_cervezas.error.brewery.BreweryNotFoundException;
import f0rno.api_cervezas.model.Breweries;
import f0rno.api_cervezas.repository.BreweriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweriesService {
    BreweriesRepository breweriesRepository;
    @Autowired
    public BreweriesService(BreweriesRepository breweriesRepository) {
        this.breweriesRepository = breweriesRepository;
    }
    public Page<Breweries> getAllBreweries(int page, int size) {
        return breweriesRepository.findAll(PageRequest.of(page, size));
    }
    public ResponseEntity<Breweries> getBrewery(int id) throws BreweryNotFoundException {
        return breweriesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BreweryNotFoundException(id));
    }
}
