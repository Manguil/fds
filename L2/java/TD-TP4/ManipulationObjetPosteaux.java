public class ManipulationObjetPosteaux {
    public static void main(String[] args) throws InterruptedException {
        Lettre l1 = new Lettre(null, "famille Kirik, igloo 5 banquise nord", 7742, 0, 0, 1, "urgent");
        System.out.println(l1.toString());
        Colis c1 = new Colis(null, "famille Kaya, igloo 10, terres ouest", 7854, 10, 0.01, 2, null, 10);
        System.out.println(c1.toString());
        ColisExpress cE1 = new ColisExpress(null, "famille Kaya, igloo 10, terres ouest", 7854, 10, 0.01, 0, null, 10,
                true);
        System.out.println(cE1.toString()+" "+cE1.Envoi());
        Thread.sleep(10000);
        ColisExpress cE2 = new ColisExpress(null, "famille Pola, igloo 01, terres est", 7134, 100, 0.1, 1, null, 108,
                true);
        System.out.println(cE2.toString()+" "+cE2.Envoi());
    }
}
