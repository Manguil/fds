import java.util.Hashtable;
import java.util.ArrayList;

public class noticeBibliographique {
    private String titre;
    private String ISBN;
    private Hashtable<Role, ArrayList<Contributeur>> contributeurs = new Hashtable<>();

    public noticeBibliographique(String titre, String ISBN) {
        this.titre = titre;
        this.ISBN = ISBN;
    }   
}