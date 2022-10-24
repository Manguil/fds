public class ManipulationPolynome {
    public static void main(String[] args) {
        //PolynomeDense p1 = new PolynomeDense(1,0,3);
        //System.out.println(p1.derivee());
        Monome m0 = new Monome(3,0);
        Monome m2 = new Monome(1,2);
        Monome m3 = new Monome(-2,3);
        PolynomeCreux p2 = new PolynomeCreux(m0,m2,m3);
        System.out.println(p2.polCreuxADense());
    }
}
