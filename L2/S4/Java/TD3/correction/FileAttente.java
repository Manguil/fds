package genericiteSimple;

import java.util.ArrayList;

public class FileAttente<T>
{
     private String nomFile;
     private static int nbElementsEntresTotal = 0;
     private ArrayList<T> contenu;
     public FileAttente(){contenu=new ArrayList<>();}
     public void entre(T p){contenu.add(p); nbElementsEntresTotal++;}
     public T sort()
          {
               T p=null;
               if (!contenu.isEmpty())
                    {p=contenu.get(0);
                    contenu.remove(0);}
               return p;
          }
     public int nbElements(){return contenu.size();}
     public boolean estVide(){return contenu.isEmpty();}
     public String toString(){return ""+descriptionContenu();}
     private String descriptionContenu()
     {
    	 String resultat = "";
    	 for (T p:this.contenu)
    	      resultat += p + " ";
    	 return resultat;
     } 
     
     // paramètre de généricité non nécessaire
     public static int nbElementsEntreesToutesFiles() {
    	 return FileAttente.nbElementsEntresTotal;
     }
     
     // paramètre de généricité nécessaire
     public static <X> boolean Egalite(FileAttente<X> f1, FileAttente<X> f2) {
    	 return f1.equals(f2);
     }
     
     @Override
     public boolean equals(Object o) {
    	 if (! (o instanceof FileAttente))
    		 return false;
    	 else 
    		 return this.contenu
    				 .equals(((FileAttente)o).contenu);
     }
     
     // paramètre <T> nécessaire pour exprimer "de même type"
     public boolean memeContenu(FileAttente<T> f) {
    		 return this.contenu
    				 .equals(f.contenu);
     }
     
     // paramètre de généricité supplémentaire nécessaire
     public <X> boolean memeLongueur(FileAttente<X> f) {
    	 return this.contenu.size()==f.contenu.size();
     }
}