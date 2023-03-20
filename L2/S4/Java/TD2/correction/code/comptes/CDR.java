package comptes;


interface CompteBancaire {
	double getSolde();
	void setSolde(double solde);
	default void fermeture() {
		System.out.println("solde rendu "+this.getSolde());
	}
}

interface CompteRemunere extends CompteBancaire{
	
	@Override
	default void fermeture() {
		this.setSolde(this.getSolde()*1.1);
		CompteBancaire.super.fermeture();
	}
}

interface CompteDepot extends CompteBancaire{
	
	@Override
	default void fermeture() {
		this.setSolde(this.getSolde()-100);
	}
}

interface CompteDepotRemunere extends CompteRemunere,CompteDepot{

	@Override
	default void fermeture() {
		CompteDepot.super.fermeture();
		CompteRemunere.super.fermeture();
	}
}

public class CDR implements CompteDepotRemunere{
	
	private double solde;
	public CDR() {}
	public CDR(double solde) {this.setSolde(solde);}

	@Override
	public double getSolde() {
		return this.solde;
	}

	@Override
	public void setSolde(double solde) {
		this.solde = solde;
		
	}
	
	public static void main(String[] argv) {
		CompteBancaire c1 = new CDR(400);
		c1.fermeture();
	}
}
