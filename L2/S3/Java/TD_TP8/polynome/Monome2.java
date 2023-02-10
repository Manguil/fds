public class Monome2 {
    private int coeff;
    private int degre;

    public Monome2(int coeff, int degre) {
        this.coeff = coeff;
        this.degre = degre;
        if (degre<0){this.degre=0; System.out.println("les degrés ne peuvent pas être négatifs");}
    }

    // pour la question sur les effets de la modification d'un monome référencé par un polynome
    public Monome2(Monome2 m){
        this(m.coeff, m.getDegre());
    }

    public int getCoeff() {
        return coeff;
    }

    public int getDegre() {
        return degre;
    }

    public void ajoutAuCoeff(int valeur){
        coeff+=valeur;
    }

    public static Monome2 produit(Monome2 m1, Monome2 m2){
        return new Monome2 (m1.getCoeff()*m2.getCoeff(),
                m1.getDegre()+m2.getDegre());
    }

    public Monome2 derivee(){
    	if (degre==0) return new Monome2(0,0);
        return new Monome2(this.coeff*this.degre, this.degre-1);
    }

    public double eval(double valeur){
        return coeff*Math.pow(valeur, degre);
    }

    public String toString(){
        String result;
        if (coeff>0) {
            result ="+";} else {
            result ="";}
        result+=String.valueOf(coeff);
        if (degre==1) {result+="x";}
        else if (degre>1) {result +="x^"+degre;}
        return result;
    }
}
