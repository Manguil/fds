public class Personne {
    private String nom;
    private String prenom;

    private Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public class Stagiaire extends Personne {
        private String mail;
    
        public Stagiaire(String nom, String prenom) {
            super(nom, prenom);
            mail = prenom + "." + nom;
        }

        public Stagiaire(String nom, String prenom, String mail) {
            super(nom, prenom);
            this.mail = mail;
        }
    }
/*
    public class Referent extends Personne {
        private String mail;
    }
*/
}