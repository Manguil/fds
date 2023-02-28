package genericiteBornee;

import java.util.ArrayList;

public class RayonG<E extends ObjetAvecEtiquette> {
    private ArrayList<E> contenu=new ArrayList<E>(); 
    public RayonG(){}
    public void MetEnRayon(E p)
    {
    	if (!contenu.contains(p))
    		contenu.add(p);
    }
    public String listingContenu()
    {
         String listing="";
         for (E c:contenu)
              listing += c.etiquette()+" ";
         return listing;
    } 

    public static void main(String[] argv){
    	RayonG<Produit> rp = new RayonG<>();
    	rp.MetEnRayon(new Produit("lait", "34999"));
    	rp.MetEnRayon(new Produit("cannelle", "88009"));   
    	System.out.println(rp.listingContenu());
    	RayonG<Livre> rl = new RayonG<>();
    	rl.MetEnRayon(new Livre("Otto et Etta"));
    	rl.MetEnRayon(new Livre("Un amour impossible"));
    	rl.MetEnRayon(new Livre("Au revoir là-haut")); 
    	System.out.println(rl.listingContenu());
    }
}
