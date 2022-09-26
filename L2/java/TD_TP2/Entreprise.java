public class Entreprise {
    private String nom;
    private String adresse;
    private String suffixeMailStagiaire;
    private String suffixeMailReferent;

    public Entreprise(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.suffixeMailStagiaire = "@etu.umontpellier.fr";
        this.suffixeMailReferent = "@umontpellier";
    }

    public Entreprise(String nom, String adresse, String suffixeMailStagiaire, String suffixeMailReferent) {
        this.nom = nom;
        this.adresse = adresse;
        this.suffixeMailStagiaire = suffixeMailStagiaire;
        this.suffixeMailReferent = suffixeMailReferent;
    }

    public String getsuffixeMailStagiaire(){
        return suffixeMailStagiaire;
    }

    public String getsuffixeMailReferent(){
        return suffixeMailReferent;
    }

    public String toString(){
        return  nom + " est situé à " + adresse;
    }
}
