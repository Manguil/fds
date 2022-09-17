public class Personnage {
    private String nom;
    private int nbPieces;
    private int ptsVie;

    public Personnage(String nom, int nbPieces, int ptsVie) {
        this.nom = nom;
        this.nbPieces = nbPieces;
        this.ptsVie = ptsVie;
    }

    public void donnerPiecesA(Personnage p, int nbP) {
        nbPieces = nbPieces - nbP;
        p.nbPieces = p.nbPieces + nbP;
    }
}