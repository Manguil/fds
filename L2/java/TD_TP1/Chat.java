public class Chat {
	private String nom;
	private int anneeNaissance;
	private boolean pucé;

	public Chat(String nom, int anneeNaissance, boolean pucé) {
		this.nom = nom;
		this.anneeNaissance = anneeNaissance;
		this.pucé = pucé;
	}

	public String toString() {
		return "Chat [nom=" + nom + ", pelage=" + pelage + ", poilLong=" + poilLong + ", anneeNaissance="
				+ anneeNaissance + ", pucé=" + pucé + "]";
	}

}

private class pelageChat {
	private Couleur[] couleur;
	private boolean multicolore;
	private boolean poilLong;
	private String description;

	public pelageChat(Couleur[] couleur, boolean multicolore, boolean poilLong, String description)	
		this.couleur = couleur;
		this.multicolore = multicolore;
		this.poilLong = poilLong;
		this.description = description;
	}
}