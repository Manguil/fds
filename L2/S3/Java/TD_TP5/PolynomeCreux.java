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
                    case 1: res += "x "; break;
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
                max = coeff.get(i).getDegre();
            }
        }
        return max;
    }

    public void ajoutMonome(Monome x) {
        coeff.set(x.getDegre(), new Monome(x.getCoeff(),x.getDegre()));
    }
    /*
    public PolynomeCreux derivee(){
        PolynomeCreux res = new PolynomeCreux();
        if (degreMax()==0){                         // Si c'est le polynome null alors renvoie 0
            res.coeff.add(0);
        }
        else {
            res.coeff.add(coeff.get(1));
            for (int i = 1;i<degreMax();i++) {
                res.coeff.add(coeff.get(i+1)*(i+1));  //Calcule la derivee de chaque monomes
            }
        }
    }
    */

    
    public PolynomeDense polCreuxADense() {
        PolynomeDense res = new PolynomeDense(0*degreMax());
        for (int i = 0; i < degreMax(); i++) {
            System.out.println("degreI "+coeff.get(i).getDegre());
            if (coeff.get(i).getDegre() == i) {
                res.ajoutMonome(coeff.get(i));
            } else {
                res.ajoutMonome(new Monome(0, i));
            }
        }
        return res;
    }
    
}