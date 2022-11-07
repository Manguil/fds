public class Etudiant{
    private String nom;
    private Ordinateur OrdiEmprunte = null;
    
    public Etudiant(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }
    
    public Ordinateur getOrdiEmprunte(){
        return OrdiEmprunte;
    }
    
    public void setEmprunterOrd(Ordinateur o){
        if (o)
        OrdiEmprunte = o;
    }
}