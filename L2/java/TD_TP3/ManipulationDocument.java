import java.io.Serial;

public class ManipulationDocument {
    public static void main(String[] args){
        DocumentCrypté d1 = new DocumentCrypté("titre", "texte");
        System.out.println(d1.decrypter(d1.crypter(d1.getTexte())));
    }
}
