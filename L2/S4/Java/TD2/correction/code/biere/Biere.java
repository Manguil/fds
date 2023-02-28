package biere;

public class Biere{
	  public void description() {System.out.print("Biere ");this.couleur();}
	  public void couleur() {System.out.println("variee");}

		public static void main(String[] args) {
			 Biere biere1 = new Biere();   biere1.description();                     // main1
			 
			 Biere biere2 = new Lambic();  biere2.description();                     // main2
			 
			 Biere biereA1 = new MortSubiteKriek();  biereA1.description();          // main3		
			 BiereAcidulee biereA2 = new MortSubiteKriek();  biereA2.description();  // main4	 
			 MortSubiteKriek biereA3 = new MortSubiteKriek();  biereA3.description();// main5
			}
}

class BiereAcidulee extends Biere{}

class Lambic extends BiereAcidulee{
	  public void description() {super.description(); System.out.println("Lambic ");}
	  public void couleur() {System.out.println("blond cuivre");}
	}
	
class MortSubiteKriek extends Lambic{
	  public void description()  {System.out.print("Biere Kriek "); 
	                              super.couleur(); System.out.println("Lambic ");}
	  public void couleur() {System.out.println("rouge vif");}
	}



