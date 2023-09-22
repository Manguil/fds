package correction.genericiteBornee;

public class Personne implements Invitable, Comparable<Personne>{
	private String nom="", prenom="";
	private boolean invite;
	private int age;

	public Personne() {
	}

	public Personne(String prenom, String nom, boolean inv, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.invite = inv;
		this.age = age;
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
	
	public boolean isInvite() {
		return invite;
	}

	public void setInvite(boolean invite) {
		this.invite = invite;
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){return nom+" "+ prenom +" "+ this.invite;}

	@Override
	public boolean estInvite() {
		return this.invite;
	}

	@Override
	public int compareTo(Personne o) {
		return this.getNom().compareTo(o.getNom());
	}
}
