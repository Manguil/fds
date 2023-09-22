package correction.genericiteSimple;

public class Etiquette {
	private double degreAlcool;
	private String nomProducteur;
	private String adresse;
	private String description;
	private double quantité; // en litres
	public Etiquette(double degreAlcool, String nomProducteur, String adresse,
			String description, double quantité) {
		this.degreAlcool = degreAlcool;
		this.nomProducteur = nomProducteur;
		this.adresse = adresse;
		this.description = description;
		this.quantité = quantité;
	}	
}
