package genericiteBornee;

public class Livre implements ObjetAvecEtiquette{
	private String titre;

	public Livre() {}

	public Livre(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String etiquette() {
		return titre;
	}
	
}
