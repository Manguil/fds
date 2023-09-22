public class Monome{
    private int coeff;

    public int getCoeff() {
        return coeff;
    }

    private int degre;

    public int getDegre() {
        return degre;
    }

    public Monome(int coeff, int degre) {
        this.coeff = coeff;
        this.degre = degre;
    }

    public String toString() {
        String res = ""+coeff;
        if (coeff > 0) {
            res = "+"+res;
        }
        switch (degre) {
            case 0: break;
            case 1: {
                res += "x";
                break;
            }
            default : {
                res += "x^"+degre;
                break;
            }
        }
        return res;
    }

    public void ajoutAuCoeff(int nb) {
        coeff += nb;
    }

    public double eval(double nb) {
        return coeff*(Math.pow(nb,degre));
    }

    public Monome derivee() {
        if (degre == 0) {
            return new Monome(coeff*degre, degre);
        }
        return new Monome(coeff*degre, degre-1);
    }
}
