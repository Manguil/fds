package correction.genericiteSimple;

public class BouteilleEtiquetee<TypeEtiquette> extends Bouteille {
	private TypeEtiquette etiquette;
	public BouteilleEtiquetee() {}
	public BouteilleEtiquetee(TypeEtiquette etiquette) {this.etiquette = etiquette;}
	public TypeEtiquette getEtiquette() {return etiquette;}
	public void setEtiquette(TypeEtiquette etiquette) {this.etiquette = etiquette;}
	
	public static void main (String[] a)
	{
		BouteilleEtiquetee<Etiquette> b1 = new BouteilleEtiquetee<Etiquette>(
				new Etiquette(0,"LaPetiteFerme","chemin des Alpes","sirop de fraise",1));
		BouteilleEtiquetee<String> b2 = new BouteilleEtiquetee<String>("sirop de fraise");		
	}
}

