package f0rno.api_cervezas.error.brewery;

public class BreweryNotFoundException extends Exception {
    public BreweryNotFoundException(int id) {super("Brewery with " + id + " not found");}
}
