public class ManipulationDocument {
    public static void main(String[] args){
        DocumentCrypté d1 = new DocumentCrypté("titre", "texte");
        System.out.println(d1.export()+"\n");
        String sCrypter = DocumentCrypté.crypter(d1.getTexte());
        String sDecrypter = DocumentCrypté.decrypter(sCrypter);
        System.out.println("texte original : "+d1.getTexte()+"\ntexte crypté : "+sCrypter+"\ntexte décrypté : "+sDecrypter);
    }
}
