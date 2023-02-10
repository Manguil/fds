public class PaireEtiquetee<A,B,E> extends Paire<A,B>{
    private E etiquette;

    public PaireEtiquetee(A a, B b, E e)
    {
        super(a, b);
        this.etiquette = e;
    }
}
