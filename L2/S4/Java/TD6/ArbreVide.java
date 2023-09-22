public class ArbreVide<T> implements Arbre<T>{
    public ArbreVide() {
    }

    @Override
    public Arbre<T> composer(T etiquette, Arbre<T> vrai, Arbre<T> faux) {
        return null;
    }

    @Override
    public Arbre<T> sousArbreVrai() {
        return null;
    }

    @Override
    public Arbre<T> sousArbreFaux() {
        return null;
    }

    @Override
    public boolean estVide() {
        return true;
    }

    @Override
    public boolean estFeuille() {
        return false;
    }

    @Override
    public T getEtiquette() {
        return null;
    }

    @Override
    public String toString() {
        return "\nArbreVide{}";
    }

    public int nbFeuille() {return 0;}
}
