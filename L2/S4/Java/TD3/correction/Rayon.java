package genericiteBornee;

import java.util.ArrayList;

public class Rayon{
    private ArrayList<Produit> contenu=new ArrayList<Produit>(); 
    public Rayon(){}
    public void MetEnRayon(Produit p)
    {
    	if (!contenu.contains(p))
    		contenu.add(p);
    }
    public String listingContenu()
    {
         String listing="";
         for (Produit c:contenu)
              listing += c.etiquette();
         return listing;
    } 
}
