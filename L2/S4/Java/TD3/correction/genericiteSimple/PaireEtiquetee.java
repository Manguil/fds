package correction.genericiteSimple;

public class PaireEtiquetee<A,B,TypeEtiquette> extends Paire<A,B> {
	private TypeEtiquette etiquette;
	public PaireEtiquetee() {}
	public PaireEtiquetee(A f, B s, TypeEtiquette etiquette) {
		super(f, s);
		this.etiquette = etiquette;
	}
	public TypeEtiquette getEtiquette() {return etiquette;}
	public void setEtiquette(TypeEtiquette etiquette) {this.etiquette = etiquette;}
	
	public static void main(String[] args) {
		PaireEtiquetee<String,Personne,String> p1=
				new PaireEtiquetee<String,Personne,String>("sarah",new Personne(),"prenom");
		PaireEtiquetee<String,Personne,Integer> p2=
				new PaireEtiquetee<String,Personne,Integer>("sarah",new Personne(),20021004);
	}
}
