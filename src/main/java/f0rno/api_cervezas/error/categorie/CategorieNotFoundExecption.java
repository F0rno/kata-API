package f0rno.api_cervezas.error.categorie;

public class CategorieNotFoundExecption extends Exception {
    public CategorieNotFoundExecption(int id) {super("Categorie with " + id + " not found");}
}
