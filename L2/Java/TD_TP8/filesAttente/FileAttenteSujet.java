package filesAttente;

import java.util.ArrayList;

public class FileAttenteSujet {
	private String nomFile;
	private static String reglementationFile = "sans priorité";
	private ArrayList<Personne> contenu;
	public FileAttenteSujet(){
		contenu=new ArrayList<Personne>();
	}
	public void mettreEnFile(Personne p){
		contenu.add(p);
	}
	public Personne defiler(){
		Personne p=null;
		if (!contenu.isEmpty())
		{p=contenu.get(0);      
		contenu.remove(0);}
		return p;
	}

	public boolean estVide(){
		return contenu.isEmpty();
	}
	public int taille(){
		return contenu.size();
	}

	public void vider(){
		while(!estVide()) {
			this.defiler();
		}
	}

	public String toString(){
		return ""+descriptionContenu();
	}
	private String descriptionContenu(){
		String resultat = "";
		for (Personne p:this.contenu)
			resultat += p + " ";
		return resultat;
	}
}
