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

    public PolynomeDense derivee() {
        PolynomeDense pol = new PolynomeDense();
        for (int i = 0; i < coeff.size(); i++) {
            pol.coeff.set(i, coeff.get(i)*(i+1));
        }
        return pol;
    }
}