@Refactoring(nomPersonne = "Mat", nomRefactoring = RefactoringName.rename, Commentaire = "mettre Majuscule aux attributs")
public class Personne {
    
    public Personne (String nom,int age,int numrue,String nomrue,
    String ville,int codepostale)
    {
        this.NomComplet = nom ;
        this.Age = age ;
        this.NumRue = numrue ;
        this.NomRue = nomrue ;
        this.Ville = ville ;
        this.CodePostale = codepostale ;
    }
    
    @Refactoring(nomPersonne = "Mat", nomRefactoring = RefactoringName.encapsulatedField, Commentaire = "mettre en privee les   attributs")
    public String NomComplet ;
    public int Age ;
    public int NumRue ;
    public String NomRue ;
    public String Ville ;
    public int CodePostale ;
    @Refactoring(nomPersonne = "Mat", nomRefactoring = RefactoringName.extractClass, Commentaire = "creer un classe Adresse")
    public void AfficherAdresse()
    {
        System.out.println("Numero de rue : "+NumRue);
        System.out.println("Nom de la rue : "+NomRue);
        System.out.println("Nom de la ville : "+Ville);
        System.out.println("CodePostale : "+CodePostale);
    }
}

/*
— de renommer les attributs (dont les noms devraient commencer par des majuscules),
— d’encapsuler les attributs (en les rendant priv ́es),
— d’extraire une classe Adresse.
*/