import java.util.Arrays;

public class pelageChat {
	private Couleur[] couleur;
	private boolean multicolore;
	private boolean poilLong;
	private String description;

	public pelageChat(Couleur[] couleur, boolean multicolore, boolean poilLong, String description) {
		this.couleur = couleur;
		this.multicolore = multicolore;
		this.poilLong = poilLong;
		this.description = description;
	}

	public String toString() {
		return "couleur=" + Arrays.toString(couleur) + "\n\tmulticolore=" + multicolore + "\n\tpoilLong=" + poilLong
				+ "\n\tdescription=" + description;
	}
}