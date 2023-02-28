package genericiteBornee;

public class Adulte extends Personne {
	
	private String categorie;

	public Adulte() {
		// TODO Auto-generated constructor stub
	}

	public Adulte(String nom, String prenom, boolean inv, int a) {
		super(nom, prenom, inv, a);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
