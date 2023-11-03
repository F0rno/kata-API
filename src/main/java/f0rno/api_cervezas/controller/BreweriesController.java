package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.model.Breweries;
import f0rno.api_cervezas.service.BreweriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<Breweries> getAllBreweries() {
        return breweriesService.getAllBreweries();
    }
    @GetMapping("/brewerie/{id}")
    public Breweries getBrewery(@PathVariable int id) {
        return breweriesService.getBrewery(id);
    }
}
