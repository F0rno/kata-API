package f0rno.api_cervezas.error.beer;

public class BeerAlreadyExistsException extends Exception {
    public BeerAlreadyExistsException() {
        super("Beer already exists");
    }
}
