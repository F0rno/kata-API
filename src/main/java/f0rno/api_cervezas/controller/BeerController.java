package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.model.Beer;
import f0rno.api_cervezas.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class BeerController {
    private BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
    @GetMapping("/beer")
    public Beer getBeer(@RequestParam int id) {
        Optional beer = beerService.getBeer(id);
        if (beer.isPresent()) {
            return (Beer) beer.get();
        }
        return null;
    }
}
