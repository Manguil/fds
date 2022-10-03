public class Compte {
	private final int numeroCompte;
	private double Solde;

	public Compte(int numeroCompte, double Solde){
		this.numeroCompte = numeroCompte;
		this.Solde = Solde;
	}

	public double getSolde(){
		return Solde;
	}

	public void deposer(double argentADeposer){
		Solde += argentADeposer;
	}

	public void prelevement(double argentAPrelever){
		if (Solde >= argentAPrelever){
			Solde -= argentAPrelever;
		} else {
			System.out.println("Le montant a prelever est supérier au solde");
		}
	}

	public String toString(){
		return "Le compte "+numeroCompte+" à "+Solde+" sur son compte";
	}
}

class compteRemunere extends Compte {
	private static int pourcentageRemuneration = 10;
	private int plafond;

	public compteRemunere(int numeroCompte, double Solde,int plafond){
		super(numeroCompte, Solde);
		this.plafond = plafond;
	}

	public void Interet(){
		super.deposer(getSolde()*pourcentageRemuneration);
	}

	@Override
	public void deposer(double argentADeposer){
		if ((getSolde() + argentADeposer) <= plafond){
			super.deposer(argentADeposer);
		} else {
			System.out.println("Le montant a deposer depasse le plafond");
		}
	}

	@Override
	public String toString(){
		return super.toString()+" avec un pourcentage de remuneration de "+pourcentageRemuneration+" et un plafond de "+plafond;
	}
}