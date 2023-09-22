package annotations;


public class Personne_avant_annotation {

public Personne_avant_annotation () {}
public Personne_avant_annotation (String nom,int age,int numrue,String nomrue,String ville,int codepostale)
{
	this.NomComplet = nom ; 
	this.Age = age ; 
	this.NumRue = numrue ; 
	this.NomRue = nomrue ; 
	this.Ville = ville ; 
	this.CodePostale = codepostale ;
}


public String NomComplet ; 
public int Age ;
public int NumRue ;
public String NomRue ;
public String Ville ;
public int CodePostale ;

public void AfficherAdresse()
{
    System.out.println("Numero de rue : "+NumRue);
    System.out.println("Nom de la rue : "+NomRue);
    System.out.println("Nom de la ville : "+Ville);
    System.out.println("CodePostale : "+CodePostale);
}
}
