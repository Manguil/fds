package streamsIterateurs;

import java.util.ArrayList;

public class DirectionLycee implements Iterable <EmployeLycee>{
	private EmployeLycee proviseur,
						proviseurAdjoint,
						conseillerPrincipaldEducation,
						gestionnaire,
						chefDeTravaux;

	public DirectionLycee() {
	}

	public Iterator iterator() {
		ArrayList<EmployeLycee> ListeEmploye = new ArrayList<>();
		ListeEmploye.add(proviseur);
		ListeEmploye.add(proviseurAdjoint);
		ListeEmploye.add(conseillerPrincipaldEducation);
		ListeEmploye.add(gestionnaire);
		ListeEmploye.add(chefDeTravaux);
		//voir corrige
		return ListeEmploye.iterator;
	}

	public EmployeLycee getProviseur() {
		return proviseur;
	}

	public void setProviseur(EmployeLycee proviseur) {
		this.proviseur = proviseur;
	}

	public EmployeLycee getProviseurAdjoint() {
		return proviseurAdjoint;
	}

	public void setProviseurAdjoint(EmployeLycee proviseurAdjoint) {
		this.proviseurAdjoint = proviseurAdjoint;
	}

	public EmployeLycee getConseillerPrincipaldEducation() {
		return conseillerPrincipaldEducation;
	}

	public void setConseillerPrincipaldEducation(EmployeLycee conseillerPrincipaldEducation) {
		this.conseillerPrincipaldEducation = conseillerPrincipaldEducation;
	}

	public EmployeLycee getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(EmployeLycee gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public EmployeLycee getChefDeTravaux() {
		return chefDeTravaux;
	}

	public void setChefDeTravaux(EmployeLycee chefDeTravaux) {
		this.chefDeTravaux = chefDeTravaux;
	}
	
	public String toString() {
		String res ="Direction du lycee "
				+"\nproviseur "+this.getProviseur()
				+"\nproviseur adjoint "+this.getProviseurAdjoint()	
				+"\ngestionnaire "+this.getGestionnaire()		
				+"\nCPE "+this.getConseillerPrincipaldEducation()	
				+"\nChef de travaux "+this.getChefDeTravaux();
		return res;
	}
	
	public int ageMoyen() {
		 return (this.getProviseur().getAge()+
				this.getProviseurAdjoint().getAge()+
				this.getConseillerPrincipaldEducation().getAge()+
				this.getGestionnaire().getAge()+
				this.getChefDeTravaux().getAge())/5;
	}
		
	// Methode qui affiche les noms des employés sur la sortie standard 
	
	public void afficheNoms() {
		System.out.println(proviseur.getNom()+" - "+
		proviseurAdjoint.getNom()+" - "+
		conseillerPrincipaldEducation.getNom()+" - "+
		gestionnaire.getNom()+" - "+
		chefDeTravaux.getNom());
	}
	
	// Methode qui retourne la liste des employes recrutes 
	// apres une certaine annee passee en parametre
	
	public ArrayList<EmployeLycee> recruteApres(int annee) {
		ArrayList<EmployeLycee> res = new ArrayList<>();
		if (proviseur.anneeRecrutement >= annee) {res.add(proviseur);}
		if (proviseurAdjoint >= annee) {res.add(proviseurAdjoint);} 
		if (conseillerPrincipaldEducation >= annee) {res.add(conseillerPrincipaldEducation);}
		if (gestionnaire >= annee) {res.add(gestionnaire);}
		if (chefDeTravaux >= annee) {res.add(chefDeTravaux);}
		return res;
	}

	// Methode qui retourne l'age moyen 
	// des membres d'une certaine categorie recrutes
	// avant une certaine annee	
	
	public double ageMoyenCategorieAvant(Categorie a, int annee)
	{
		moy = 0;
		nbEmploye = 0;
		if (proviseur.getAnneeRecrutement() <= annee && proviseur.getCategorie() == a ) 
		{
			moy += proviseur.getAge();
			nbEmploye++;
		}
		if (proviseurAdjoint.getAnneeRecrutement() <= annee && proviseurAdjoint.getCategorie() == a )
		{
			moy += proviseurAdjoint.getAge();
			nbEmploye++;
		}
		if (conseillerPrincipaldEducation.getAnneeRecrutement() <= annee && conseillerPrincipaldEducation.getCategorie() == a )
		{
			moy += conseillerPrincipaldEducation.getAge();
			nbEmploye++;
		}
		if (gestionnaire.getAnneeRecrutement() <= annee && gestionnaire.getCategorie() == a )
		{
			moy += gestionnaire.getAge();
			nbEmploye++;
		}
		if (chefDeTravaux.getAnneeRecrutement() <= annee && chefDeTravaux.getCategorie() == a )
		{
			moy += chefDeTravaux.getAge();
			nbEmploye++;
		}
		return moy/nbEmploye;		
	}
	
	// Methode qui retourne l'annee de recrutement
	// la plus ancienne pour les employes 
	// d'un certain corps

	public int anneeRecrutementPlusAnciennePourCorps(String corps)
	{
		anneeRecrutementMax = 9999999;
		if (proviseur.getAnneeRecrutement() <= anneeRecrutementMax && proviseur.getCorp() == corps ) 
		{
			anneeRecrutementMax = proviseur.getAnneeRecrutement();
		}
		if (proviseurAdjoint.getAnneeRecrutement() <= annee && proviseurAdjoint.getCorp() == corps )
		{
			anneeRecrutementMax = proviseurAdjoint.getAnneeRecrutement();
		}
		if (conseillerPrincipaldEducation.getAnneeRecrutement() <= annee && conseillerPrincipaldEducation.getCorp() == corps)
		{
			anneeRecrutementMax = conseillerPrincipaldEducation.getAnneeRecrutement();
		}
		if (gestionnaire.getAnneeRecrutement() <= annee && gestionnaire.getCorp() == corps )
		{
			anneeRecrutementMax = gestionnaire.getAnneeRecrutement();
		}
		if (chefDeTravaux.getAnneeRecrutement() <= annee && chefDeTravaux.getCorp() == corps )
		{
			anneeRecrutementMax = chefDeTravaux.getAnneeRecrutement();
		}
		return 0;		
	}
	
	//********* ITERATEUR ******************

	// Après avoir écrit l'itérateur et avoir transformé la
	// classe DirectionLycee en classe Iterable ...
	
	int ageMoyenIte()
	{
		Iterator <EmployeLycee> ListeEmploye = this.iterator();
		moy = 0;
		nbEmploye = 0;
		for (EmployeLycee employe : ListeEmploye)
		{
			moy += employe.getAge();
			nbEmploye ++;
		}
	}
	// Ecrire afficheNoms avec for (quand l'iterateur existe)
	void afficheNomsIte() 
	{
		Iterator <EmployeLycee> ListeEmploye = this.iterator();
		for (EmployeLycee employe : ListeEmploye)
		{
			System.out.print(employe.getNom());
		}
	}
		
	// Ecrire recruteApres avec for (quand l'iterateur existe)
	ArrayList<EmployeLycee> recruteApresIte(int annee)
	{
		Iterator <EmployeLycee> ListeEmploye = this.iterator();
		ArrayList <EmployeLycee> res = new ArrayList<>();
		for (EmployeLycee employe : ListeEmploye)
		{
			if (employe.getAnneeRecrutement() >= annee) {res.add(employe);}
		}	
	}
	// Ecrire ageMoyenCategorieAvant avec for (quand l'iterateur existe)
	double ageMoyenCategorieAvantIte(Categorie cat, int annee)
	{
		Iterator <EmployeLycee> ListeEmploye = this.iterator();
		moy = 0;
		nbEmploye = 0;
		for (EmployeLycee employe : ListeEmploye)
		{
			if (employe.getAnneeRecrutement() <= annee && employe.getCategorie == cat)
			{
				moy += employe.getAge();
				nbEmploye ++;
			}
		}
	}
	// Ecrire anneeRecrutementPlusAnciennePourCorps avec for (quand l'iterateur existe)
	int anneeRecrutementPlusAnciennePourCorpsIte(String corps)
	{
		Iterator <EmployeLycee> ListeEmploye = this.iterator();
		anneeRecrutementMax = 0;
		if (employe.getAnneeRecrutement() >= anneeRecrutementMax && employe.getCorp() == corps ) 
		{
			anneeRecrutementMax = employe.getAnneeRecrutement();
		}
	}
	//********* STREAM ******************
	
	// Stream 1 - Ecrire une methode retournant une liste contenant les membres de la direction
	// la liste peut être utilisée ci-dessous pour obtenir un stream puis
	// le naviguer
	
	// Stream 2 - Ecrire aussi une methode retournant un stream sur les membres
	// de la direction à partir de l'itérateur
	
	// Ecrire ageMoyen avec les 2 streams obtenus comme indiqué précédemment 
	
	// Ecrire afficheNoms avec l'un des 2 streams
	
	// Ecrire recruteApres avec l'un des 2 streams
			
	// Ecrire ageMoyenCategorieAvant avec l'un des 2 streams
	
	// Ecrire anneeRecrutementPlusAnciennePourCorps avec l'un des 2 streams
	
}
