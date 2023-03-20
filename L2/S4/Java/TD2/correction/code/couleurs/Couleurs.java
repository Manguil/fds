package couleurs;

abstract class Pinceau{	
    public void vert(){System.out.print("vert");}	
    public void rose(){System.out.print("rose");}	
    public void bleu(){System.out.print("bleu");}	
    public void jaune(){System.out.print("jaune"); gamme(); }		
    public void orange(){System.out.print("orange"); variante_orange();  }		
    public void variante_orange(){System.out.print(" standard");}
    abstract void gamme();
}

abstract class PinceauClair extends Pinceau{	
    @Override
    public void bleu(){System.out.print("bleu clair");}	
}

class PinceauPastel extends PinceauClair{	
    @Override
    public void bleu(){System.out.print("bleu pastel");}	
    @Override
    public void rose(){super.rose(); System.out.print(" dragée");}	
    @Override
    public void variante_orange(){System.out.print(" coquille d'oeuf");}	
    public void mauve1(){this.rose(); System.out.print("---"); this.bleu();}	
    public void mauve2(){super.rose(); System.out.print("---"); super.bleu();}
    @Override
    public void gamme() {System.out.print(" pastel");}	
}

public class Couleurs {
    public static void main(String[] args) {	

        System.out.println("------------- pinceau pp3 -----------------");
        PinceauPastel pp3 = new PinceauPastel();	
        pp3.vert();         System.out.println();
        pp3.rose();        System.out.println();
        pp3.bleu();        System.out.println();
        pp3.jaune();      System.out.println();
        pp3.orange();      System.out.println();
        pp3.mauve1();	 System.out.println();
        pp3.mauve2();	 System.out.println();
				
        System.out.println("------------- pinceau p3 -----------------");	
        Pinceau p3 = new PinceauPastel();
        p3.vert(); 		System.out.println();
        p3.rose();    System.out.println();
        p3.bleu();    System.out.println();
        p3.jaune();  System.out.println();
        p3.orange();      System.out.println();
        //p3.mauve1();
        //p3.mauve2();
        
        System.out.println("------------- pinceau pc3 -----------------");
        PinceauClair pc3 = new PinceauPastel();			
        pc3.vert();    System.out.println();
        pc3.rose();   System.out.println();
        pc3.bleu();   System.out.println();
        pc3.jaune(); System.out.println();
        pc3.orange();      System.out.println();
        //pc3.mauve1();	
        //pc3.mauve2();	
    }
}