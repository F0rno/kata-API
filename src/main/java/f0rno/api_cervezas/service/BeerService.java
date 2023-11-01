package f0rno.api_cervezas.service;

import f0rno.api_cervezas.model.Beers;
import f0rno.api_cervezas.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {
    BeerRepository beerRepository;
    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }
    public Beers getBeer(int id) {
        return beerRepository.findById(id).orElse(null);
    }
}
