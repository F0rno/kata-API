package f0rno.api_cervezas.error.style;

public class StyleNotFoundException extends Exception {
    public StyleNotFoundException(int id) {super("Style with id " + id + " not found");}
}
