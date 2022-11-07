import java.util.ArrayList;

public class gestionPret {
    private ArrayList<Ordinateur> stockOrdi = new ArrayList<Ordinateur>();


    public void ajoutOrdi(Ordinateur o){
        if (!(stockOrdi.contains(o))){
            System.out.println("ajout ordinateur");
            stockOrdi.add(o);
        }
    }

    public void suprOrdi(Ordinateur o){
        if (stockOrdi.contains(o)){
            System.out.println("supression ordinateur");
            stockOrdi.remove(o);
        }
    }

    public ArrayList<Ordinateur> recherche(String m, boolean disponible){
        ArrayList<Ordinateur> listeOrdiParMarque = new ArrayList<Ordinateur>();
        for (Ordinateur o : stockOrdi){
            if (m=="all"){
                listeOrdiParMarque = stockOrdi;
            }
            else {
                if (o.getMarque().equals(m)){
                    listeOrdiParMarque.add(o);
               }
            }
        }
        return listeOrdiParMarque;
    }
}