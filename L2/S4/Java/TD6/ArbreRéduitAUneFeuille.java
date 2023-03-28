package org.example;

public class ArbreRéduitAUneFeuille<T> implements Arbre<T>{
    private T etiquette;

    public ArbreRéduitAUneFeuille(T etiquette) {
        this.etiquette = etiquette;
    }

    @Override
    public Arbre<T> composer(T etiquette, Arbre<T> vrai, Arbre<T> faux) {
        return new ArbreRéduitAUneFeuille<T>(etiquette);
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
        return this.getEtiquette()==null;
    }

    @Override
    public boolean estFeuille() {
        return true;
    }

    @Override
    public T getEtiquette() {
        return this.etiquette;
    }

    @Override
    public String toString() {
        return "\nArbreRéduitAUneFeuille{" +
                "etiquette=" + etiquette +
                '}';
    }
}
