package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.error.brewery.BreweryNotFoundException;
import f0rno.api_cervezas.model.Breweries;
import f0rno.api_cervezas.service.BreweriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BreweriesController {
    BreweriesService breweriesService;
    @Autowired
    public BreweriesController(BreweriesService breweriesService) {
        this.breweriesService = breweriesService;
    }
    @GetMapping("/breweries")
    public ResponseEntity<Page<Breweries>> getAllBreweries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")  int size) {
        Page<Breweries> breweries = breweriesService.getAllBreweries(page, size);
        return ResponseEntity.ok(breweries);
    }
    @GetMapping("/brewerie/{id}")
    public ResponseEntity<Breweries> getBrewery(@PathVariable int id) throws BreweryNotFoundException {
        return breweriesService.getBrewery(id);
    }
}
