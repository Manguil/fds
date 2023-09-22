public class ManipulationCompte {
    public static void main(String[] args){
        compteRemunere c1 = new compteRemunere(1234567890, 100, 1000);
        c1.deposer(20);
        c1.prelevement(10);
        System.out.println(c1.toString());
    }
}
