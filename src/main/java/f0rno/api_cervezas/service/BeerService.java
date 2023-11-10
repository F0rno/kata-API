package f0rno.api_cervezas.service;

import f0rno.api_cervezas.error.beer.BeerNotFoundException;
import f0rno.api_cervezas.model.Beers;
import f0rno.api_cervezas.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BeerService {
    BeerRepository beerRepository;
    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }
    public ResponseEntity<List<Beers>> getAllBeers() {
        return ResponseEntity.ok(beerRepository.findAll());
    }
    public ResponseEntity<Beers> getBeer(int id) throws BeerNotFoundException {
        return beerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }
    public Beers postBeer(int brewery_id, String name, int cat_id, int style_id, float abv, int ibu, float srm, int upc, String filepath, String descript, String last_mod) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(last_mod);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Beers beer = Beers.builder()
                .brewery_id(brewery_id)
                .name(name)
                .cat_id(cat_id)
                .style_id(style_id)
                .abv(abv)
                .ibu(ibu)
                .srm(srm)
                .upc(upc)
                .filepath(filepath)
                .descript(descript)
                .last_mod(date)
                .build();
        return beerRepository.save(beer);
    }
    public Beers putBeer(int id, int brewery_id, String name, int cat_id, int style_id, float abv, int ibu, float srm, int upc, String filepath, String descript, String last_mod) {
        if (!beerRepository.existsById(id)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(last_mod);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Beers beer = Beers.builder()
                .id(id)
                .brewery_id(brewery_id)
                .name(name)
                .cat_id(cat_id)
                .style_id(style_id)
                .abv(abv)
                .ibu(ibu)
                .srm(srm)
                .upc(upc)
                .filepath(filepath)
                .descript(descript)
                .last_mod(date)
                .build();
        return beerRepository.save(beer);
    }
    public void deleteBeer(int id) {
        beerRepository.deleteById(id);
    }
}
