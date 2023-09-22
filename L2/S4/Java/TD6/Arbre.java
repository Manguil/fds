public interface Arbre<T>{
    Arbre<T> composer(T etiquette, Arbre<T> vrai, Arbre<T> faux);
    Arbre<T> sousArbreVrai();
    Arbre<T> sousArbreFaux();
    boolean estVide();
    boolean estFeuille();
    T getEtiquette();

    @Override
    String toString();

    String toStringIndente();

    default int nbFeuille(){
        if (estFeuille()) {return 1;}

        else {return sousArbreVrai().nbFeuille() + sousArbreFaux().nbFeuille();}
    }

}
