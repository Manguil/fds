package filesAttente;

public class TestFiles {

	public static void main(String[] args) {
		IFileAttente fileBoulangerie=new FileAttente();
		System.out.println("la file est vide à la création : "+fileBoulangerie.estVide());
		Personne mmeMichu=new Personne("Michu", "Josette");
		Personne mMichu=new Personne("Michu", "Robert");
		Personne gerardMichu=new Personne("Michu", "Gerard");
		fileBoulangerie.mettreEnFile(mmeMichu);
		System.out.println("Mme Michu entre");
		System.out.println("la file contient maintenant une personne : "+(fileBoulangerie.taille()==1));
		fileBoulangerie.mettreEnFile(mMichu);
		System.out.println("M Michu entre");
//		System.out.println("la file contient maintenant deux personnes : "+(fileBoulangerie.taille()==2));
		fileBoulangerie.mettreEnFile(gerardMichu);	
//		Personne p=fileBoulangerie.sort();
	//	System.out.println("Une personne sort, ce doit être Mme Michu "+p.equals(mmeMichu));
	//	System.out.println ("Mais alors qui est sorti ? "+p);
		
		fileBoulangerie.vider();
		System.out.println("on vide la file, elle doit maintenant être vide : "+fileBoulangerie.estVide());
		
	}

}
