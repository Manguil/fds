import java.util.ArrayList;

public class PolynomeDense2 implements IPolynome {

    private ArrayList<Integer> coefficients; // on maintient la liste des coefficients pour tous les degrés (ici le degré est l'indice)

    public PolynomeDense2() {
        coefficients = new ArrayList<>();
    }

    public String toString() {
        String result = "";
        for (int i=0;i<coefficients.size();i++) {

            if (coefficients.get(i)!=0) {
                Monome2 m=new Monome2(coefficients.get(i), i);
                result += m;

            }
        }
        if (result.equals("")) {// si result chaine vide ?
            result = "polynôme nul";
        }
        return result;
    }

    public boolean estNul() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public int degreMax() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return 0;
    }

    public void ajoutMonome(Monome2 m) {
        if (m.getDegre() < coefficients.size()) {
            coefficients.set(m.getDegre(), coefficients.get(m.getDegre()) + m.getCoeff());
        } else {
            int nbCasesARajouter=m.getDegre()-coefficients.size();
            for (int i = 0; i <nbCasesARajouter; i++) {
                coefficients.add(0);
            }
            coefficients.add(m.getCoeff());
        }

    }

            // ce serait mieux de le faire avec Horner
            public double evalNaif(double valeur){
                double result=0;
                for (int i=0; i<coefficients.size();i++){
                    result+=coefficients.get(i)*Math.pow(valeur, i);
                }
                return result;
            }

            public PolynomeDense2 derivee(){
                PolynomeDense2 derivee=new PolynomeDense2();
                for (int i=0;i<coefficients.size();i++){
                    if (coefficients.get(i)!=0){
                        Monome2 m=new Monome2(coefficients.get(i), i);
                        derivee.ajoutMonome(m.derivee());
                    }
                }
                return derivee;
            }

    public PolynomeDense2 produit(Monome2 facteur){
        PolynomeDense2 result=new PolynomeDense2();
        for (int i=0;i<coefficients.size();i++){
            result.ajoutMonome(Monome2.produit(new Monome2(coefficients.get(i), i),facteur));
        }
        return result;
    }
    public PolynomeDense2 somme(PolynomeDense2 terme){
                // il y a plus efficace ...
        PolynomeDense2 result=new PolynomeDense2();
        for (int i=0;i<coefficients.size();i++){
            result.ajoutMonome(new Monome2(coefficients.get(i), i));
        }
        for (int i=0;i<terme.coefficients.size();i++){
            result.ajoutMonome(new Monome2(terme.coefficients.get(i), i));
        }
        return result;
    }
    public PolynomeDense2 produit(PolynomeDense2 facteur){
        PolynomeDense2 result=new PolynomeDense2();
        for (int i=0;i<coefficients.size();i++){
            result=result.somme(facteur.produit(new Monome2(coefficients.get(i),i)));
        }
        return result;
    }

    public static void main(String[] args) {
        PolynomeDense2 p1 = new PolynomeDense2();
        p1.ajoutMonome(new Monome2(1, 10));
        p1.ajoutMonome(new Monome2(-1, 10));
        p1.ajoutMonome(new Monome2(1, 7));
        p1.ajoutMonome(new Monome2(1, 3));
        p1.ajoutMonome(new Monome2(1, 1));

        p1.ajoutMonome(new Monome2(1, 5));
        p1.ajoutMonome(new Monome2(1, 3));
        p1.ajoutMonome(new Monome2(-1, 7));
        System.out.println(p1);
        //p1.mult(new Monome(3, 2));

        //System.out.println(p1);
        System.out.println(p1.evalNaif(1));
        System.out.println(p1.derivee());

        Monome2 m1=new Monome2(3,1);
        Monome2 m2=new Monome2(5,5);
        PolynomeDense2 p=new PolynomeDense2();
        p.ajoutMonome(m1);
        p.ajoutMonome(m2);

        System.out.println(p1.produit(new Monome2(3, 1)));
        System.out.println(p1.produit(new Monome2(5, 5)));
        System.out.println(p1.produit(new Monome2(3, 1)).somme(p1.produit(new Monome2(5, 5))));
        System.out.println(p1.produit(p));

    }
}

