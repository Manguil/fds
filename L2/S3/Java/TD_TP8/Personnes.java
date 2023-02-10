public class Personnes {
	private String nom;
	private String prenom;
	
	public Personnes(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	
	
	public String getPrenom() {
		return prenom;
	}
	
	
	public String toString(){
		return this.getNom() + " "+this.getPrenom();
	}
}