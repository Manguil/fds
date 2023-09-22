package annotations;

@Refactoring(
		nomReviseur="marianne",
		nomRefactoring=RefactoringName.extractClass,
		commentaire="extraire une classe adresse",
		existeDansEclipse=true,
		nbCasApplication=1
)
public class Personne {

public Personne () {}
public Personne (String nom,int age,int numrue,String nomrue,String ville,int codepostale)
{
	this.NomComplet = nom ; 
	this.Age = age ; 
	this.NumRue = numrue ; 
	this.NomRue = nomrue ; 
	this.Ville = ville ; 
	this.CodePostale = codepostale ;
}

@Refactoring(
		nomReviseur="marianne",
		nomRefactoring=RefactoringName.encapsulatedField,
		commentaire="rendre privé",
		existeDansEclipse=true,
		nbCasApplication=1
)
@Refactoring(
		nomReviseur="marianne",
		nomRefactoring=RefactoringName.rename,
		commentaire="mettre une minuscule : nomComplet",
		existeDansEclipse=true,
		nbCasApplication=1
)
public String NomComplet ; 
@Refactoring(
		nomReviseur="marianne",
		nomRefactoring=RefactoringName.encapsulatedField,
		commentaire="rendre privé",
		existeDansEclipse=true,
		nbCasApplication=1
)
@Refactoring(
		nomReviseur="marianne",
		nomRefactoring=RefactoringName.rename,
		commentaire="mettre une minuscule : age",
		existeDansEclipse=true,
		nbCasApplication=1
)
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
