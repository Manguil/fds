import java.util.ArrayList;
import java.util.Collections;

public class PolynomeCreux {
    private ArrayList<Monome> coeff;

    public PolynomeCreux(Monome... coeff) {
        this.coeff = new ArrayList<>();
        Collections.addAll(this.coeff, coeff);
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < coeff.size(); i++) {
            int coeffI = coeff.get(i).getCoeff();
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
            if (coeff.get(i).getCoeff() != 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public int degreMax() {
        int max = 0;
        for (int i = 0; i < coeff.size(); i++) {
            if (coeff.get(i).getCoeff() != 0) {
                max = i;
            }
        }
        return max;
    }

    public void ajoutMonome(Monome x) {
        coeff.set(x.getDegre(), new Monome(x.getCoeff(),x.getDegre()));
    }

    public PolynomeCreux derivee() {
        PolynomeCreux pol = new PolynomeCreux();
        for (int i = 0; i < coeff.size(); i++) {
            //pol.coeff.set(i, coeff.get(i).getCoeff()*(i+1));
        }
        return pol;
    }
}