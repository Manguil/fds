public class Stage {
    private String sujet;
    private Entreprise entreprise;
    private Stagiaire stagiaire;
    private Referent referent;
    private Theme theme;

    public Stage(String sujet, Entreprise entreprise, Stagiaire stagiaire, Referent referent, Theme theme) {
        this.sujet = sujet;
        this.entreprise = entreprise;
        this.stagiaire = stagiaire;
        this.referent = referent;
        stagiaire.setMail((stagiaire.getPrenom() + "." + stagiaire.getNom()).toLowerCase() + entreprise.getsuffixeMailStagiaire());
        referent.setMail((referent.getPrenom() + "." + referent.getNom()).toLowerCase() + entreprise.getsuffixeMailReferent());
        this.theme = theme;
    }

    public String toString() {
        return "le sujet du stage est '" + sujet + "' dans le domaine de " + theme + " à " + entreprise + " realisé par " + stagiaire + " et supervisé par " + referent;
    }
}
