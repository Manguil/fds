public class ManipulationDocument {
    public static void main(String[] args){
        DocumentCrypté d1 = new DocumentCrypté("titre", "texte");
        System.out.println(DocumentCrypté.decrypter(DocumentCrypté.crypter(d1.getTexte())));
        System.out.println(d1.export());
    }
}
