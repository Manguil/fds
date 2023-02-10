public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected String mail;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String toString(){
        return nom + " - " + prenom + " - " + mail;
    }
}

class Stagiaire extends Personne {    
    public Stagiaire(String nom, String prenom) {
        super(nom, prenom);
    }

    public Stagiaire(String nom, String prenom, String mail) {
        super(nom, prenom);
        this.mail = mail;
    }

}

class Referent extends Personne {

    public Referent(String nom, String prenom) {
        super(nom, prenom);
    }

    public Referent(String nom, String prenom, String mail) {
        super(nom, prenom);
        this.mail = mail;
    }
}