
public class Compteur {
	// COMPLETER ICI


	public Compteur() {
		nbCompteurs++;
	}
	
	// pour incrémenter la valeur du compteur
	public void incrVal() {
		valeur++;
	}

	// pour decrémenter la valeur du compteur
	public void decrVal() {
		valeur--;
	}

	public String toString() {
		return "valeur=" + valeur + " ; nombre de compteurs = "+nbCompteurs;
	}
	
	public int getValeur() {
		return valeur;
	}
}
