public class ManipulationChats {
	public static void main(String[] args) {
		Couleur[] couleur = {Couleur.NOIR, Couleur.BLANC};
		Chat Azrael = new Chat("Azraël", couleur, true, false, "il est tros beau", 2017, false);
		System.out.println(Azrael.toString());
		//Chat Azbis = Azrael;
	}
}