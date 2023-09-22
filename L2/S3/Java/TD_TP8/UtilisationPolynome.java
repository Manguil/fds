public class UtilisationPolynome {
    public static void afficheDerivee(IPolynome p) {
        if (!p.estNul()) {
            System.out.println(p.derivee());
        }
    }

    public static void main (String[] args) {
        PolynomeCreux2 polC = new PolynomeCreux2();     
    }
}