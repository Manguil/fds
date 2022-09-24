
public class ManipulationCompteur {

	public static void main(String[] args) {
		System.out.println("On crée un premier compteur");
		Compteur c1=new Compteur();
		System.out.println("Compteur 1 : "+c1.toString());
		System.out.println("On crée un deuxième compteur");
		Compteur c2=new Compteur();
		System.out.println("Compteur 2 : "+c2.toString());
		System.out.println("On incrémente c1");
		c1.incrVal();
		System.out.println("Compteur 1 : "+c1.toString());
		System.out.println("Compteur 2 : "+c2.toString());
		System.out.println("On incrémente c2");
		c2.incrVal();
		System.out.println("Compteur 1 : "+c1.toString());
		System.out.println("Compteur 2 : "+c2.toString());
		System.out.println("On crée un troisième compteur");
		Compteur c3=new Compteur();
		System.out.println("Compteur 1 : "+c1.toString());
		System.out.println("Compteur 2 : "+c2.toString());
		System.out.println("Compteur 3 : "+c3.toString());
	}
}
