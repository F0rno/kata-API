package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.model.Beers;
import f0rno.api_cervezas.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {
    private BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
    @GetMapping("/beer")
    public Beers getBeer(@RequestParam int id) {
        return beerService.getBeer(id);
    }
}
