public class ArbreAvecUneEtiquette<T> implements Arbre<T>{
    private T etiquette;
    private Arbre<T> vrai;
    private Arbre<T> faux;

    public ArbreAvecUneEtiquette(T etiquette, Arbre<T> vrai, Arbre<T> faux) {
        this.etiquette = etiquette;
        this.vrai = vrai;
        this.faux = faux;
    }

    @Override
    public Arbre<T> composer(T etiquette, Arbre<T> vrai, Arbre<T> faux) {
        return new ArbreAvecUneEtiquette<T>(etiquette, vrai, faux);
    }

    @Override
    public Arbre<T> sousArbreVrai() {
        return this.vrai;
    }

    @Override
    public Arbre<T> sousArbreFaux() {
        return this.faux;
    }

    @Override
    public boolean estVide() {
        return this.getEtiquette()==null;
    }

    @Override
    public boolean estFeuille() {
        return this.vrai == null && this.faux == null;
    }

    @Override
    public T getEtiquette() {
        return this.etiquette;
    }

    @Override
    public String toString() {
        return "\nArbreAvecUneEtiquette{" +
                "etiquette=" + etiquette +
                ", vrai=" + vrai +
                ", faux=" + faux +
                '}';
    }
}
