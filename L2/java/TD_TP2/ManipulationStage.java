public class ManipulationStage {
    public static void main(String[] args) {
        Stagiaire sr1 = new Stagiaire("NORMAND", "Mathis");
        Referent r1 = new Referent("ZINCK", "Tom");
        Entreprise e1 = new Entreprise("Bugisoft", "Bugville & incrVal", "@Stage.Bugisoft.fr", "@Bugisoft.fr");
        Stage s1 = new Stage("c'est trop bien l'IA", e1, sr1, r1, Theme.IA);
        System.out.println(s1.toString());
    }
}
