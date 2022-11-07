public class ManipulationPret {
    public void main(String[] args){
        Ordinateur o1 = new Ordinateur("1","HP");
        Ordinateur o2 = new Ordinateur("2","HP");
        Ordinateur o3 = new Ordinateur("3","DELL");
        Ordinateur o4 = new Ordinateur("3","Lenovo");
    
        Etudiant e1 = new Etudiant("Dupont");
        Etudiant e2 = new Etudiant("Durand");
        Etudiant e3 = new Etudiant("azerty");
        Etudiant e4 = new Etudiant("Normand");
        Etudiant e5 = new Etudiant("Blabla");

        gestionPret g = new gestionPret();
        g.ajoutOrdi(o1);
        g.ajoutOrdi(o2);
        g.ajoutOrdi(o3);
        g.ajoutOrdi(o4);
        g.suprOrdi(o4);
        System.out.println(g.recherche("all",true));
        
    }
}
