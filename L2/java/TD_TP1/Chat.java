public class Chat {
	private String nom;
	private pelageChat pelage;
	private int anneeNaissance;
	private boolean pucé;

	public Chat(String nom, Couleur[] couleur, boolean multicolore, boolean poilLong, String description,
			int anneeNaissance, boolean pucé) {
		if ((couleur.length > 1 && multicolore == true) || (couleur.length == 1 && multicolore == false)) {
			this.nom = nom;
			this.pelage = new pelageChat(couleur, multicolore, poilLong, description);
			this.anneeNaissance = anneeNaissance;
			this.pucé = pucé;
		}
	}

	public String toString() {
		return "Chat [\n\tnom=" + nom + "\n\t" + pelage.toString() + "\n\tanneeNaissance=" + anneeNaissance
				+ "\n\tpucé=" + pucé + "\n]";
	}

}