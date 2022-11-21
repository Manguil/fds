public interface IFileAttente {
    void mettreEnFile(Personnes p);
    Personnes defiler();
    boolean estVide();
    int taille();
    public default void vider() {
        while (!estVide()) {
            defiler();
        }
    }
}
