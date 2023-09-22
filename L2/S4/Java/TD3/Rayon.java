import java.util.ArrayList;

public class Rayon{
    private ArrayList<Produit> contenu=new ArrayList<Produit>();

    public String listingContenu()
    {
        String listing="";
        for (Produit c:contenu)
        listing += c.getEtiquette();
        return listing;
    }
}