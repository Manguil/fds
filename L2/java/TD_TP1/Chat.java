public class Chat {
	private String nom;
	private String pelage;
	private boolean poilLong;
	private int anneeNaissance;
	private boolean pucé;

	public Chat(String nom, String pelage, boolean poilLong, int anneeNaissance, boolean pucé) {
		this.nom = nom;
		this.pelage = pelage;
		this.poilLong = poilLong;
		this.anneeNaissance = anneeNaissance;
		this.pucé = pucé;
	}

	public String toString() {
		return "Chat [nom=" + nom + ", pelage=" + pelage + ", poilLong=" + poilLong + ", anneeNaissance="
				+ anneeNaissance + ", pucé=" + pucé + "]";
	}

}