package streamsIterateurs;

public class EmployeLycee {
	
	private String nom = "";
	private String prenom = "";
	private int age;
	private int anneeRecrutement;
	private Categorie categorie;
	private String corps, grade;
	private int echelon;
	
	public EmployeLycee() {
	}
	public EmployeLycee(String nom, String prenom, int age, int anneeRecrutement, Categorie categorie, String corps,
			String grade, int echelon) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.anneeRecrutement = anneeRecrutement;
		this.categorie = categorie;
		this.corps = corps;
		this.grade = grade;
		this.echelon = echelon;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAnneeRecrutement() {
		return anneeRecrutement;
	}
	public void setAnneeRecrutement(int anneeRecrutement) {
		this.anneeRecrutement = anneeRecrutement;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getEchelon() {
		return echelon;
	}
	public void setEchelon(int echelon) {
		this.echelon = echelon;
	}
	public String toString() {
		return "\n"+prenom+" "+nom+" "+anneeRecrutement+" "+categorie
				+" "+ corps +" "+grade+ " "+echelon;
	}
}
