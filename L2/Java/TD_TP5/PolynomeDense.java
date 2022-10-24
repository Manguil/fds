import java.util.ArrayList;
import java.util.Collections;

public class PolynomeDense {
    private ArrayList<Integer> coeff;

    public PolynomeDense(Integer... coeff) {
        this.coeff = new ArrayList<>();
        Collections.addAll(this.coeff, coeff);
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < coeff.size(); i++) {
            int coeffI = coeff.get(i);
            if (coeffI != 0) {
                if (coeffI > 0) {
                    res += "+"+coeffI;
                }
                else {
                    res += coeffI;
                }
                switch (i) {
                    case 0: res += " "; break;
                    case 1: res+= "x "; break;
                    default: res += "x^"+i+" ";
                }
            }
        }
        return res;
    }

    public boolean estNul() {
        boolean res = true;
        for (int i = 0; i < coeff.size(); i++) {
            if (coeff.get(i) != 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public int degreMax() {
        int max = 0;
        for (int i = 0; i < coeff.size(); i++) {
            if (coeff.get(i) != 0) {
                max = i;
            }
        }
        return max;
    }

    public void ajoutMonome(Monome x) {
        coeff.set(x.getDegre(), x.getCoeff());
    }

    public PolynomeDense derivee(){
        PolynomeDense res = new PolynomeDense();
        if (degreMax()==0){                         // Si c'est le polynome null alors renvoie 0
            res.coeff.add(0);
        }
        else {
            res.coeff.add(coeff.get(1));
            for (int i = 1;i<degreMax();i++){
                res.coeff.add(coeff.get(i+1)*(i+1));  //Calcule la derivee de chaque monomes
            }
        }
        return res;
    }

    public PolynomeCreux polDenseACreux() {
        PolynomeCreux res = new PolynomeCreux();
        return res;
    }
}