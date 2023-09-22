import java.util.ArrayList;

public class FileAttente {
	private String nomFile;
	private static String reglementationFile = "sans priorité";
	private ArrayList<Personnes> contenu;
	public FileAttente(){
		contenu=new ArrayList<Personnes>();
	}
	public void mettreEnFile(Personnes p){
		contenu.add(p);
	}
	public Personnes defiler(){
		Personnes p=null;
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
		for (Personnes p:this.contenu)
			resultat += p + " ";
		return resultat;
	}
}