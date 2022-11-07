public class Ordinateur{
    private String numero;
    private String marque;
    private Etudiant emprunteur = null;

    public Ordinateur(String numero, String marque) {
        this.numero = numero;
        this.marque = marque;
    }

    public String getNumero() {
        return numero;
    }

    public String getMarque() {
        return marque;
    }

    public Etudiant getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Etudiant emprunteur) {
        if (this.emprunteur == null) {
            this.emprunteur = emprunteur;
        }
    }

    @Override
    public String toString() {
        return "Ordinateur{numero=" + numero + ", marque=" + marque + '}';
    }
}