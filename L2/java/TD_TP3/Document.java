public class Document {
    private String titre;
    private String texte;

    public Document(String titre, String texte) {
        this.titre = titre;
        this.texte = texte;
    }

    public int nbCars() {
        return titre.length() + texte.length();
    }

    public String export() {
        return "#" + titre + "\t\n\n" + texte;
    }

    public String getTitre() {
        return titre;
    }

    public String getTexte() {
        return texte;
    }
}

class DocumentAvecMentionsLegales extends Document {
    private String mentionsLegales;

    public DocumentAvecMentionsLegales(String titre, String texte, String mentionsLegales) {
        super(titre, texte);
        this.mentionsLegales = mentionsLegales;
    }

    @Override
    public String export() {
        return getTitre() + "\t\n\n" + getTexte();
    }
}

class DocumentCrypté extends Document {

    public DocumentCrypté(String titre, String texte) {
        super(titre, texte);
    }

    public static String crypter(String s) {
        String sCrypter = "";
        for (int i = 0; i < s.length(); i++) {
            sCrypter += (s.charAt(i)+ 0);
        }
        return sCrypter;
    }

    public static String decrypter(String s) {
        String sDecrypter = "";
        for (int i = 0; i < s.length(); i++) {
            sDecrypter += (s.charAt(i)+"");
        }
        return sDecrypter;
    }
}
