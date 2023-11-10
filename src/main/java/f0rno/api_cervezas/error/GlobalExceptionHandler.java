package f0rno.api_cervezas.error;

import f0rno.api_cervezas.error.beer.BeerAlreadyExistsException;
import f0rno.api_cervezas.error.beer.BeerNotFoundException;
import f0rno.api_cervezas.error.brewery.BreweryNotFoundException;
import f0rno.api_cervezas.error.categorie.CategorieNotFoundExecption;
import f0rno.api_cervezas.error.style.StyleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BeerNotFoundException.class})
    public ResponseEntity<Object> handleBeerNotFoundException(BeerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BeerAlreadyExistsException.class})
    public ResponseEntity<Object> handleBeerAlreadyExistsException(BeerAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {BreweryNotFoundException.class})
    public ResponseEntity<Object> handleBreweryNotFoundException(BreweryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CategorieNotFoundExecption.class})
    public ResponseEntity<Object> handleCategorieNotFoundException(CategorieNotFoundExecption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {StyleNotFoundException.class})
    public ResponseEntity<Object> handleStyleNotFoundException(StyleNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
