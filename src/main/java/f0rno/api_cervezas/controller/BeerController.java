package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.error.DateParseException;
import f0rno.api_cervezas.error.beer.BeerAlreadyExistsException;
import f0rno.api_cervezas.error.beer.BeerNotFoundException;
import f0rno.api_cervezas.model.Beers;
import f0rno.api_cervezas.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {
    private BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
    @GetMapping("/beers")
    public ResponseEntity<Page<Beers>> getAllBeers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")  int size) {
        Page<Beers> beers = beerService.getAllBeers(page, size);
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }
    @GetMapping("/beer/{id}")
    public ResponseEntity<Beers> getBeer(@PathVariable int id) throws BeerNotFoundException {
        return beerService.getBeer(id);
    }
    @PostMapping("/beer")
    public ResponseEntity<Beers> postBeer(@RequestParam int brewery_id, @RequestParam String name, @RequestParam int cat_id, @RequestParam int style_id, @RequestParam float abv, @RequestParam int ibu, @RequestParam float srm, @RequestParam int upc, @RequestParam String filepath, @RequestParam String descript, @RequestParam String last_mod) throws BeerAlreadyExistsException, DateParseException {
        return beerService.postBeer(brewery_id, name, cat_id, style_id, abv, ibu, srm, upc, filepath, descript, last_mod);
    }
    @PutMapping("/beer/{id}")
    public ResponseEntity<Beers> putBeer(@PathVariable int id, @RequestParam int brewery_id, @RequestParam String name, @RequestParam int cat_id, @RequestParam int style_id, @RequestParam float abv, @RequestParam int ibu, @RequestParam float srm, @RequestParam int upc, @RequestParam String filepath, @RequestParam String descript, @RequestParam String last_mod) throws BeerNotFoundException {
        return beerService.putBeer(id, brewery_id, name, cat_id, style_id, abv, ibu, srm, upc, filepath, descript, last_mod);
    }
    // TODO PATCH
    @DeleteMapping("/beer/{id}")
    public void deleteBeer(@PathVariable int id) {
        beerService.deleteBeer(id);
    }
}
