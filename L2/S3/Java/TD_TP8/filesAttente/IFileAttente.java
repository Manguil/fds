package filesAttente;

public interface IFileAttente {
	public abstract void mettreEnFile(Personne p);
	Personne defiler();
	boolean estVide();
	int taille();
	String toString(); 
	default public void vider(){
		while(!estVide()) {
			this.defiler();
		}
	}
}
