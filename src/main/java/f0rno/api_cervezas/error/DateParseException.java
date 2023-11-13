package f0rno.api_cervezas.error;

public class DateParseException extends Exception {
    public DateParseException(String date) {super("Date " + date + " could not be parsed");}
}
