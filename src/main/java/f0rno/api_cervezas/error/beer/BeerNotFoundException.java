package f0rno.api_cervezas.error.beer;

public class BeerNotFoundException extends Exception {
    public BeerNotFoundException(int id) {super("Beer with id " + id + " not found");}
}
