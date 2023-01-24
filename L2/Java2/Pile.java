import java.util.ArrayList;

public class Pile implements IPile{
    // structure de stockage interne des  ́el ́ements
    private ArrayList<Object> elements;
    // Mise en oeuvre des op ́erations
    public Pile(){initialiser();}

    public Object depiler() throws PileVideException{
        if (this.estVide())
            throw new PileVideException("en d ́epilant");
        int temp = elements.size();
        Object sommet = elements.get(elements.size()-1);
        elements.remove(sommet);
        int temp2 = elements.size();
        assert temp-temp2==1;
        return sommet;
    }

    public void empiler(Object t) throws PileVideException {
        int temp = elements.size();
        elements.add(t);
        assert this.sommet()==t : "dernier empile ="+this.sommet();
        int temp2 = elements.size();
        assert temp2-temp==1;
    }

    public boolean estVide() {return elements.isEmpty();}

    public void initialiser() {
        assert this.estVide();
        elements = new ArrayList<T>();
    }

    public Object sommet() throws PileVideException{
        if (this.estVide())
            throw new PileVideException("en d ́epilant");
        return elements.get(elements.size()-1);
    }

    public int taille(){return elements.size();}

    public String toString(){return "Pile = "+ elements;}
}

/*Q1 
grace a l'execption; elements.get(elements.size()-1)==t
*/

/*Q2

*/