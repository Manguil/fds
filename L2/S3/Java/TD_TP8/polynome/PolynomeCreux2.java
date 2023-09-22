import java.util.ArrayList;

public class PolynomeCreux2 implements IPolynome{
    private ArrayList<Monome2> monomes; // on maintient la liste par ordre de degrés croissants

    public PolynomeCreux2() {
        monomes=new ArrayList<>();
    }

    public String toString(){
        String result="";
        for (Monome2 m:monomes){
            result+=m;
        }
        if (monomes.isEmpty()){result="polynôme nul";}
        return result;
    }

    public boolean estNul() {
        boolean res = true;
        for (int i = 0; i < monomes.size(); i++) {
            if (monomes.get(i).getCoeff() != 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public int degreMax() {
        int max = 0;
        for (int i = 0; i < monomes.size(); i++) {
            if (monomes.get(i).getCoeff() != 0) {
                max = monomes.get(i).getDegre();
            }
        }
        return max;
    }
    public void ajoutMonome(Monome2 m){
        // ajout d'un clone de m au polynome
        if (!monomes.isEmpty()) {
            int posCourante=0;
            Monome2 courant=monomes.get(posCourante);
            // on cherche la position d'insertion
            while (courant.getDegre()<m.getDegre() && posCourante< monomes.size()-1){
                // on passe au monome suivant
                posCourante++;
                courant=monomes.get(posCourante);
            }
            if (courant.getDegre()==m.getDegre()){
                // on avait déjà un monome de même degré, on ajoute les coeff
                courant.ajoutAuCoeff(m.getCoeff());
                if (courant.getCoeff()==0){
                    // on retire le monome nul de la liste
                    monomes.remove(courant);
                }
            }else if (courant.getDegre()>m.getDegre()){
                // on a dépassé la position d'insertion, insertion de m avant le monome courant
                monomes.add(posCourante, new Monome2(m)); // juste m dans les premières questions
            } else {
                // on insère à la fin
                monomes.add(new Monome2(m)); // juste m dans les premières questions
            }
        }else{ // premier monome du polynome
            monomes.add(new Monome2(m)); // juste m dans les premières questions
        }
    }

    /**
     * Multiplication par un monome
     * @param facteur monome par lequel on multiplie le polynome
     * @return le produit du polynpome receveur par facteur
     */
    public PolynomeCreux2 produit(Monome2 facteur){
        PolynomeCreux2 result=new PolynomeCreux2();
        for (Monome2 m:monomes){
            result.ajoutMonome(Monome2.produit(m,facteur));
        }
        return result;
    }
    public PolynomeCreux2 somme(PolynomeCreux2 terme){
            PolynomeCreux2 result=new PolynomeCreux2();
            // on duplique this dans result (prévoir un autre constructeur par copie !!)
            for (Monome2 m:monomes){
                result.ajoutMonome(m);
            }
            // on ajoute les monomes de terme
            for (Monome2 mterme:terme.monomes){
                result.ajoutMonome(mterme);
            }
            return result;
}
    public PolynomeCreux2 produit(PolynomeCreux2 facteur){
        PolynomeCreux2 result=new PolynomeCreux2();
        for (Monome2 m:monomes){
            result=result.somme(facteur.produit(m));
        }
        return result;
    }

    // ce serait mieux de le faire avec Horner
    public double evalNaif(double valeur){
        double result=0;
        for (Monome2 m:monomes){
            result+=m.eval(valeur);
        }
        return result;
    }

    public PolynomeCreux2 derivee(){
        PolynomeCreux2 derivee=new PolynomeCreux2();
        for (Monome2 m:monomes){
            derivee.ajoutMonome(m.derivee());
        }
        return derivee;
    }



    public static void main(String[] args) {
        PolynomeCreux2 p1=new PolynomeCreux2();
        p1.ajoutMonome(new Monome2(1, 10));
        p1.ajoutMonome(new Monome2(1, 7));
        p1.ajoutMonome(new Monome2(1, 3));
        p1.ajoutMonome(new Monome2(1,1));

        p1.ajoutMonome(new Monome2(1, 5));
        p1.ajoutMonome(new Monome2(1, 3));
        p1.ajoutMonome(new Monome2(-1, 7));
        System.out.println(p1);
        p1.produit(new Monome2(3, 2));

        System.out.println(p1);
        System.out.println(p1.evalNaif(1));
        System.out.println(p1.derivee());

        // question sur la réf de monome
        Monome2 m1=new Monome2(3,1);
        Monome2 m2=new Monome2(5,5);
        PolynomeCreux2 p=new PolynomeCreux2();
        p.ajoutMonome(m1);
        p.ajoutMonome(m2);
        System.out.println("p avant modif m1 : "+p);
        m1.ajoutAuCoeff(3); // cette instruction a t-elle un effet de bord sur p ?
        System.out.println("p après modif m1 : "+p);
        System.out.println(p1.produit(new Monome2(3, 1)));
        System.out.println(p1.produit(new Monome2(5, 5)));
        System.out.println(p1.produit(new Monome2(3, 1)).somme(p1.produit(new Monome2(5, 5))));
        System.out.println(p1.produit(p));
    }
}
