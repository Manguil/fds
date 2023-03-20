package introspection;

import java.io.Serializable;
import java.util.Scanner;

public class Appartement implements Cloneable, Serializable{
	   private String adresse; private int anneeConstruction;
	    private int nbPieces; private double superficie;
	    public static final double taxeFonciereAuM2 = 5;
	    public Appartement() {}
	    public double loyer(){return valLocBase() * coeffModerateur();}
	    public double valLocBase() {return superficie*5*(1.0 + this.nbPieces / 10.0);}
	    public double coeffModerateur() {return 1;}	
	    public String feuilleLoyer(){
	        return "adresse = "+this.adresse + " val loc base = "+ this.valLocBase()
	            + " coeff moderateur = "+ this.coeffModerateur()+ " loyer = " + this.loyer();
	    }	
	    private void saisie(Scanner sc){
	        System.out.println("Entrer l'adresse"); adresse = sc.next();
	        System.out.println("Entrer l'annee de construction"); anneeConstruction = sc.nextInt();
	        System.out.println("Entrer le nombre de pieces"); nbPieces = sc.nextInt();
	        System.out.println("Entrer la superficie"); superficie = sc.nextDouble();
	    }
	    public static double getTaxefonciereaum2() {
	        return taxeFonciereAuM2;
	    }	
}

