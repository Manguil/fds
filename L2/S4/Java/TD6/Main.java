public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*Droite du dep*/
        ArbreRéduitAUneFeuille<String> a3f2 = new ArbreRéduitAUneFeuille<>("            Poisson/reptile");
        ArbreRéduitAUneFeuille<String> a3v2 = new ArbreRéduitAUneFeuille<>("            mammifère");

        ArbreAvecDesSousArbres<String> a2f1 = new ArbreAvecDesSousArbres<>("        Poils ?", a3v2, a3f2);

        ArbreRéduitAUneFeuille<String> a2v1 = new ArbreRéduitAUneFeuille<>("        oiseau");

        ArbreAvecDesSousArbres<String> a1v = new ArbreAvecDesSousArbres<>(" Plumes ?", a2v1,a2f1);

        /*Gauche du dep*/

        ArbreRéduitAUneFeuille<String> a2f2 = new ArbreRéduitAUneFeuille<>("        arthropode");
        ArbreRéduitAUneFeuille<String> a2v2 = new ArbreRéduitAUneFeuille<>("        mollusque");

        ArbreAvecDesSousArbres<String> a1f = new ArbreAvecDesSousArbres<>(" Coquille ?", a2v2, a2f2);

        /*dep*/
        ArbreAvecDesSousArbres<String> a0 = new ArbreAvecDesSousArbres<>("Vertébré ?", a1v,a1f);

        System.out.println(a0.toString());
        System.out.println("====================365=====================");

        ArbreRéduitAUneFeuille<String> j3f = new ArbreRéduitAUneFeuille<>("         Année tout ce qu'il y a de plus normale quoi");
        ArbreRéduitAUneFeuille<String> j3v = new ArbreRéduitAUneFeuille<>("         Année Bissextil");


        ArbreAvecDesSousArbres<String> j2f = new ArbreAvecDesSousArbres<>("     Divisible par 100 ?", j3f, j3f);

        ArbreRéduitAUneFeuille<String> j2v = new ArbreRéduitAUneFeuille<>("     Année tout ce qu'il y a de plus normale quoi");

        ArbreAvecDesSousArbres<String> j1f = new ArbreAvecDesSousArbres<>(" Divisible par 100 ?", j2v, j2f);

        ArbreRéduitAUneFeuille<String> j1v = new ArbreRéduitAUneFeuille<>(" Année Bissextil");

        /*dep*/
        ArbreAvecDesSousArbres<String> j0 = new ArbreAvecDesSousArbres<>("Divisible par 400 ?", j1v,j1f);

        System.out.println(j0.toString());
        System.out.println("====================Recherche=====================");

        String cible = " Divisible par 100 ?";


    }
}