public class ManipulationChats {
	public static void main(String[] args) {
		Chat Azrael = new Chat("Azraël", "roux et blanc", false, 2017, false);
		Chat Grosminet = new Chat("Grosminet", "gris", true, 2020, true);
		System.out.println(Azrael.toString() + Grosminet.toString());
	}
}