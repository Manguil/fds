package streamsIterateurs;

public class mainDirectionLycee {
	public static void main(String[] args) {
		
		EmployeLycee jeanne = 
				new EmployeLycee("Laforet","jeanne",40,2010,Categorie.A,
								"personnel de direction","classe normale",4);
		EmployeLycee amine = 
				new EmployeLycee("Sahraoui","Amine",50,1999,Categorie.A,
								"personnel de direction","hors classe",6);
		EmployeLycee max = 
				new EmployeLycee("Johnson","Max",37,2015,Categorie.B,
								"professeur","classe ordinaire",3);
		EmployeLycee luigi = 
				new EmployeLycee("Santiago","luigi",29,2018,Categorie.B,
								"agent administratif","classe ordinaire",2);
		EmployeLycee josette = 
				new EmployeLycee("Duchateau","Josette",55,2000,Categorie.A,
								"cadre administratif","classe exceptionelle",7);
		
		DirectionLycee directionLyceeSimoneVeil= new DirectionLycee();
		directionLyceeSimoneVeil.setProviseur(jeanne);
		directionLyceeSimoneVeil.setProviseurAdjoint(amine);
		directionLyceeSimoneVeil.setConseillerPrincipaldEducation(luigi);
		directionLyceeSimoneVeil.setGestionnaire(josette);
		directionLyceeSimoneVeil.setChefDeTravaux(max);
		
		System.out.println(directionLyceeSimoneVeil);
		
		// Test des méthodes écrites sans itérateur ni stream
		
		System.out.println("age moyen ="+directionLyceeSimoneVeil.ageMoyen());
		
		System.out.println("noms des membres de la direction : ");
		directionLyceeSimoneVeil.afficheNoms();		
		
		System.out.println("recrutes apres 2010"+directionLyceeSimoneVeil.recruteApres(2010));		

		System.out.println("age moyen cat. A recrutes avant 2000 : ");
		System.out.println(directionLyceeSimoneVeil
				.ageMoyenCategorieAvant(Categorie.A,2000));
		
		System.out.println("annee recrutement plus ancienne pers. de direction : ");
		System.out.println(directionLyceeSimoneVeil
				.anneeRecrutementPlusAnciennePourCorps("personnel de direction"));
		
		// Test des méthodes écrites avec itérateur
		
		/*	 
		System.out.println("******** methodes utilisant un itérateur");
		
		System.out.println("age moyen ="
				+directionLyceeSimoneVeil.ageMoyenIte());
		

		System.out.println("noms des membres de la direction : ");
		directionLyceeSimoneVeil.afficheNomsIte();		

		System.out.println("recrutes apres 2010"+directionLyceeSimoneVeil.recruteApresIte(2010));		

		System.out.println("age moyen cat. A recrutes avant 2000 : ");
		System.out.println(directionLyceeSimoneVeil
				.ageMoyenCategorieAvantIte(Categorie.A,2000));
		
		System.out.println("annee recrutement plus ancienne pers. de direction : ");
		System.out.println(directionLyceeSimoneVeil
				.anneeRecrutementPlusAnciennePourCorpsIte("personnel de direction"));
		*/
		
		// Test des méthodes écrites avec stream	
		
		/*
		
		System.out.println("******** methodes utilisant un stream");
		
		System.out.println("age moyen ="
				+directionLyceeSimoneVeil.ageMoyenStream());
		
		System.out.println("noms des membres de la direction : ");
		directionLyceeSimoneVeil.afficheNomsStream();		

		System.out.println("recrutes apres 2010"+directionLyceeSimoneVeil.recruteApresStream(2010));		

		System.out.println("age moyen cat. A recrutes avant 2000 : ");
		System.out.println(directionLyceeSimoneVeil
				.ageMoyenCategorieAvantStream(Categorie.A,2000));
		
		System.out.println("annee recrutement plus ancienne pers. de direction : ");
		System.out.println(directionLyceeSimoneVeil
				.anneeRecrutementPlusAnciennePourCorpsStream("personnel de direction"));
		*/
	}
}
