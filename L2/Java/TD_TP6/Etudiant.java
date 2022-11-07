public class Etudiant{
    private String nom;
    private Ordinateur OrdiEmprunte;
    
    public Etudiant(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }
    
    public Ordinateur getOrdiEmprunte(){
        return OrdiEmprunte;
    }
    
    public void emprunterOrd(Ordinateur ordi){
        OrdiEmprunte = ordi;
    }
}