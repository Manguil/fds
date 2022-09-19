public class ManipulationPoint {
    public static void main(String[] args) {
        Point o = new Point();
        Point p1 = new Point(3, 4);

        System.out.println("le module de " + o.toString() + "est " + o.module());
        System.out.println("le module de " + p1.toString() + "est " + p1.module());
        Point p2 = p1.symetrique();
        System.out.println(p1.distanceDe(p2));
    }
}