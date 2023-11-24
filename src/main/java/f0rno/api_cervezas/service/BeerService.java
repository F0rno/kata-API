package f0rno.api_cervezas.service;

import f0rno.api_cervezas.error.DateParseException;
import f0rno.api_cervezas.error.beer.BeerAlreadyExistsException;
import f0rno.api_cervezas.error.beer.BeerNotFoundException;
import f0rno.api_cervezas.model.Beers;
import f0rno.api_cervezas.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
    public Page<Beers> getAllBeers(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return beerRepository.findAll(pageable);
    }
    public ResponseEntity<Beers> getBeer(int id) throws BeerNotFoundException {
        return beerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }
    public ResponseEntity<Beers> postBeer(int brewery_id, String name, int cat_id, int style_id, float abv, int ibu, float srm, int upc, String filepath, String descript, String last_mod) throws DateParseException, BeerAlreadyExistsException {
        if (beerRepository.existsByName(name)) {
            throw new BeerAlreadyExistsException();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(last_mod);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new DateParseException(last_mod);
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
        return ResponseEntity.status(HttpStatus.CREATED).body(beerRepository.save(beer));
    }
    public ResponseEntity<Beers> putBeer(int id, int brewery_id, String name, int cat_id, int style_id, float abv, int ibu, float srm, int upc, String filepath, String descript, String last_mod) throws BeerNotFoundException {
        if (!beerRepository.existsById(id)) {
            throw new BeerNotFoundException(id);
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
        return ResponseEntity.ok(beerRepository.save(beer));
    }
    public void deleteBeer(int id) {
        beerRepository.deleteById(id);
    }
}
