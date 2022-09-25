public class ManipulationVecteur {
    public static void main(String[] args) {
        Vecteur v1=new Vecteur(1, 2);
        Vecteur v2=new Vecteur(2, 1);
        Vecteur v3=new Vecteur(3, 3);
        Vecteur v4=v1.sommeAvec(v2);
        Vecteur v5=v3;
        System.out.println(v5==v3);
        System.out.println(v4==v3);
    }
}
