package genericiteSimple;

public class MainFileAttente {
	public static void main(String[] args) {
		FileAttente<Personne> f_personnes = new FileAttente<>();
		FileAttente<Rectangle> f_rectangles = new FileAttente<>();
		
		f_personnes.entre(new Personne());
		f_personnes.entre(new Personne());
		f_personnes.entre(new Personne());
		
		f_rectangles.entre(new Rectangle());
		f_rectangles.entre(new Rectangle());
		f_rectangles.entre(new Rectangle());
		
		System.out.println(f_personnes);
		System.out.println(f_rectangles);
		
		System.out.println(f_rectangles.equals(f_personnes));	
		
		Personne p1 = new Personne();
		Personne p2 = new Personne();
		Personne p3 = new Personne();
		FileAttente<Personne> f_personnes1 = new FileAttente<>();
		f_personnes1.entre(p1);
		f_personnes1.entre(p2);
		f_personnes1.entre(p3);
		FileAttente<Personne> f_personnes2 = new FileAttente<>();
		f_personnes2.entre(p1);
		f_personnes2.entre(p2);
		f_personnes2.entre(p3);
		
		System.out.println(f_personnes1.equals(f_personnes2));
		System.out.println(f_personnes1.memeContenu(f_personnes2));
	
		System.out.println(f_personnes1.memeLongueur(f_rectangles));

		System.out.println(FileAttente.nbElementsEntreesToutesFiles());	
	}
}
