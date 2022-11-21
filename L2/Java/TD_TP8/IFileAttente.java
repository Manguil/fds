public interface IFileAttente {
    void mettreEnFile(Personne p);
    Personne defiler();
    boolean estVide();
    int taille();
    public default void vider() {
        while (!estVide()) {
            defiler();
        }
    }
}
