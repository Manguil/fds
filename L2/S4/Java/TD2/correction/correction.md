# TD TP 2

## Comptes bancaires
```java
public interface CompteBancaire{
    float getSolde();
    void setSolde(float newSolde);
    default void fermer(){
        System.out.println("Solde rendu : "+getSolde());
    }
}
```
```java
public interface CompteRemunere extends CompteBancaire{
    default void fermer(){
        setSolde(getSolde()*1.1f);
        CompteBancaire.super.fermer();
    }
}
```
```java
public interface CompteDepot extends CompteBancaire{
    default void fermer(){
        setSolde(getSolde()-100); // c'est une réduction ?
        //CompteBancaire.super.fermer();
    }
}
```
```java
public interface CompteDepotRemunere extends CompteRemunere,CompteDepot{
    // si on n'écrit rien, ça ne compile pas ...
    default void fermer(){
        CompteDepot.super.fermer();
        CompteRemunere.super.fermer();
    }    
}
```
```java
public class CDR implements CompteDepotRemunere {
    private float solde;

    @Override
    public float getSolde() {
        return solde;
    }

    @Override
    public void setSolde(float newSolde) {
        this.solde=newSolde;        
    }
    
    public static void main(String[] args){
        CDR cdr=new CDR(); // Solde nul
        cdr.fermer(); // et hop, solde à -110 :)
    }
}
```
## Couleurs

Le code suivant illustre différents schémas de définition/redéfinition des méthodes dans le
cadre de la programmation par objets :
1. héritage sans redéfinition
2. redéfinition avec masquage (une méthode définie dans une classe est complètement
redéfinie dans une de ses sous-classes)
3. redéfinition avec spécialisation (on utilise l’appel super)
4. méthode abstraite
5. définition par généralisation (une méthode appelle une autre méthode dont les ver-
sions spécifiques pourront être trouvées dans les sous-classes)
   * (a) avec appel d’une méthode abstraite
   * (b) avec appel d’une méthode concrète
```java
abstract class Pinceau{
    public void vert(){System.out.print("vert");}
    public void rose(){System.out.print("rose");}
    public void bleu(){System.out.print("bleu");}
    public void jaune(){
      System.out.print("jaune");
      gamme(); }
    public void orange(){
      System.out.print("orange");
      variante_orange(); }
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
    public void variante_orange(){System.out.print(" coquille d’oeuf");}
    public void mauve1(){this.rose(); System.out.print("---"); this.bleu();}
    public void mauve2(){super.rose(); System.out.print("---"); super.bleu();}
    @Override
    public void gamme() {System.out.print(" pastel");}
}

public class Couleurs {
    public static void main(String[] args) {
        System.out.println("------------- pinceau pp3 -----------------");
        PinceauPastel pp3 = new PinceauPastel();
        pp3.vert();
        System.out.println();
        pp3.rose();
        System.out.println();
        pp3.bleu();
        System.out.println();
        pp3.jaune();
        System.out.println();
        pp3.orange();
        System.out.println();
        pp3.mauve1(); System.out.println();
        pp3.mauve2(); System.out.println();
        System.out.println("------------- pinceau p3 -----------------");
        Pinceau p3 = new PinceauPastel();
        p3.vert(); System.out.println();
        p3.rose();
        System.out.println();
        p3.bleu();
        System.out.println();
        p3.jaune(); System.out.println();
        p3.orange();
        System.out.println();
        p3.mauve1();
        p3.mauve2();
        System.out.println("------------- pinceau pc3 -----------------");
        PinceauClair pc3 = new PinceauPastel();
        pc3.vert();
        System.out.println();
        pc3.rose();
        System.out.println();
        pc3.bleu();
        System.out.println();
        pc3.jaune(); System.out.println();
        pc3.orange();
        System.out.println();
        pc3.mauve1();
        pc3.mauve2();
    }
}
```
Rangez les différentes méthodes présentées ci-dessous dans ces catégories. Si vous
observez des définitions problématiques, indiquez-les.
* Pinceau :
  * vert : jamais redéfinie (héritée telle quel partout)
  * méthode abstraite : gamme 
  * jaune : def par généralisation avec appel d'une méthode abstraite
  * orange : def par généralisation avec appel d'une méthode concrète
* Pinceau clair :
  * héritage sans redéfinition de tout sauf bleu 
* PinceauPastel :
  * bleu et variante_orange : redéfinition avec masquage
  * rose : redéfinition avec spécialisation

* mauve2 de PinceauPastel n'est pas l'idée du siècle, puisqu'elle fait appelle aux super-méthodes bleu et rose (celles de pinceau du coup) plutôt qu'aux siennes propres.

Analyser le programme **main** (compilation et exécution)
* Compilation
  * Les appels à mauve1 et mauve2 ne compilent pas.
    * mauve1 et mauve2 sont définis dans PinceauPastel.
    * Les types statiques de pc3 et p3 sont PinceauClair et Pinceau, qui ne contiennent pas de définition pour mauve1 et mauve2.  
* Exécution
```
------------- pinceau pp3 -----------------
vert
rose dragée
bleu pastel
jaune pastel
orange coquille d’oeuf
rose dragée---bleu pastel
rose---bleu clair
------------- pinceau p3 -----------------
vert
rose dragée
bleu pastel
jaune pastel
orange coquille d’oeuf
------------- pinceau pc3 -----------------
vert
rose dragée
bleu pastel
jaune pastel
orange coquille d’oeuf
```

## Bières - liaison dynamique
```java
public class Biere {
  public void description() {
    System.out.print("Biere ");
    this.couleur();
  }

  public void couleur() {
    System.out.println("variee");
  }


}

class BiereAcidulee extends Biere {
}

class Lambic extends BiereAcidulee {
  public void description() {
    super.description();
    System.out.println("Lambic ");
  }

  public void couleur() {
    System.out.println("blond cuivre");
  }
}

class MortSubiteKriek extends Lambic {
  public void description() {
    System.out.print("Biere Kriek ");
    super.couleur();
    System.out.println("Lambic ");
  }

  public void couleur() {
    System.out.println("rouge vif");
  }
}
```
```java
public class MainBiere {
    public static void main(String[] args) {
        Biere biere1 = new Biere();
        biere1.description(); // main1
    
        Biere biere2 = new Lambic();
        biere2.description(); // main2
    
        Biere biereA1 = new MortSubiteKriek();
        biereA1.description(); // main3
        BiereAcidulee biereA2 = new MortSubiteKriek();
        biereA2.description(); // main4
        MortSubiteKriek biereA3 = new MortSubiteKriek();
        biereA3.description();// main5
      }
}

```
* main1 
  * Type statique : **Biere**
    * qui contient une méthode description $\implies$ compilation OK. 
  * Type dynamique : **Biere**
    * recherche de la méthode descipton depuis **Biere**, puis appel de la méthode description de la classe **Biere**
    * la méthode *description* contient l'instruction *this.couleur()* (ce qui est équivalent à *couleur()*). 
    * Le raisonnement est le mêmeque pour *description* : *this* est de type dynamique **Biere** donc appel de la méthode *Biere::couleur*
    * Donc finalement affichage de *Biere variee*
* main2 : **Biere biere2=new Lambic();biere2.description()**
  * type statique : **Biere**. On y cherche
  * *description* (et on l'y trouve) $\implies$ compilation OK.
  * type dynamique : **Lambic** qui est une petite fille de **Biere**
    * on cherche *description* à partir de **Lambic**, on appelle *Lambic.description*
    * appel de *super.description()*
      * recherche de *description* dans **BiereAcidulee** $\rightarrow$ non trouvée
      * recherche de *description()* dans **Biere** et appel de *Biere::description()*
      * dans *Biere::description()* on trouve l'instruction *this.couleur()*
        * *this* est de type dynamique **Lambic**
        * on appelle *Lambic::description::
  * Finalement il s'affiche *Biere blond cuivre Lambic* 

* main3 : **Biere A1=new MortSubiteKriek(); biereA1.description()**
*  type statique : **Biere** qui contient méthode *description* $\implies$ compilation OK
* type dynamique **MortSubiteKriek** qui est une fille de **Lambic** et une arrière petite fille de **Biere**.
  * recherche de *description* à partir de **MortSubiteKriek**, où on la trouve donc appel de *MortSubiteKriek::description*
    * on y trouve *super.couleur()*
    * la méthode *Lambic::couleur* est appelée.
* finalement il s'affiche *Biere Kriek blond cuivre Lambic*
* main4 : **BiereAcidulee biereA2=new MortSubiteKriek() ; biereA2.description();**
  * type statique : **BiereAcidulee**, où l'on commence à chercher la méthode *description*, on ne l'y trouve pas, on remonte à **Biere** où on trouve *descripton* $\implies$ compilation OK
  * type dynamique **MortSubiteKriek**, on y cherche *description*. On appelle *MortSubiteKriek::description*.
  * On y trouve l'instruction *super.couleur()*
    * on cherche *couleur* dans Lambic, on appelle *Lambic.couleur* 
* Finalement il s'affiche *Biere Kriek blond cuivre Lambic*
* main5 : idem mais cette fois ci le type statique est **MortSubiteKriek**. *description* y existe $\implies$ compilation OK. Exécution : idem que main4.

Que pensez-vous de la méthode description de la classe MortSubiteKriek ?
* appel de super.couleur() plutôt que la version de de **MortSubiteKriek** 
* Il faudrait écrire *couleur()* ou *this.couleur()*

## Bières, mauvaise conception
```java
class Beer {
    public double beerEBC() {
        return 2.939 * Math.pow(MCU(), 0.6859);
    }

    public double MCU() {
        if (this instanceof SingleMaltBeer) {
            SingleMaltBeer smb = (SingleMaltBeer) this;
            return 4.23 * smb.getMaltEBC() *
                    smb.getMaltWeight() / smb.getBeerVolume();
        } else
            return 1;
    }
}

class SingleMaltBeer extends Beer {
    private double maltWeight; // KG
    private double beerVolume; // L
    private double maltEBC; // en EBC

    public double getMaltWeight() {
        return maltWeight;
    }

    public double getBeerVolume() {
        return beerVolume;
    }

    public double getMaltEBC() {
        return maltEBC;
    }

    public SingleMaltBeer(double maltWeight, double beerVolume, double maltEBC) {
        this.maltWeight = maltWeight;
        this.beerVolume = beerVolume;
        this.maltEBC = maltEBC;
    }
}
```
1. Ce qui est problématique
   * le code de MCU n'a rien à faire dans *Beer* : le calcul qui y est implémenté est celui pour les bières single malt. Comme on ne sait pas faire le calcul de MCU pour les bières en toute généralité, on met la méthode *MCU* abstraite et donc **Beer** abstraite. 
   * on peut aussi envisager de créer une classe Malt pour y stocker l'EBC  (plutôt que de le mettre dans l'attribut maltEBC) dans l'optique par exemple d'en compléter la description avec un nom.

```java
abstract class Beer {
    public double beerEBC() {
        return 2.939 * Math.pow(MCU(), 0.6859);
    }

public abstract double MCU();
}

class SingleMaltBeer extends Beer {
    private double maltWeight; // KG
    private double beerVolume; // L
    private Malt malt; 

    public double getMaltWeight() {
        return maltWeight;
    }

    public double getBeerVolume() {
        return beerVolume;
    }


    public SingleMaltBeer(double maltWeight, double beerVolume, Malt malt) {
        this.maltWeight = maltWeight;
        this.beerVolume = beerVolume;
        this.malt = malt;
    }

    public double MCU() {
        return 4.23 * malt.getEBC() *
                    this.getMaltWeight() / this.getBeerVolume();
    }
}

class Malt{
    private double ebc;

    public Malt(double ebc){
        this.ebc=ebc;
    }
    public double getEBC(){
        return ebc;
    }
}
```
2. Ajout de MultiMaltBeer
```java
class MultiMaltBeer extends Beer {
	
    private double beerVolume; //L
    private HashMap<Malt,Double> ingredients = new  HashMap<Malt,Double>();// association entre le malt, et le poids utilisé pour la bière

	public MultiMaltBeer(double vol) {
		this.beerVolume = vol;
	}
	
	public void addIngredient(Malt malt, double poids) {
		ingredients.put(malt, poids);
	}
	
    public double MCU() {
    	double mcu=0;
    	for (Malt m : ingredients.keySet())
    		mcu +=  4.23*m.getEBC()*ingredients.get(m)/beerVolume;
    	return mcu;
    }
}
```
* ça donne quelque chose de pas terrible et assez redondant entre single et multi-malt, parce que finalement une bière single malt c'est une bière à plusieurs malts, mais où plusieurs c'est 1. De plus, ça force les bières à avoir des information de malt ...
3. Finalement, puisqu'il y a des bières sans malt, il ne reste plus grand chose dans **Beer**. On va ici supposer qu'une bière sans malt a quand même un EBC qu'on calcule avec une formule ici inconnue.
Sous Biere on peut mettre les bières multi malt, et dessous les bières single malt qui contrôlent qu'on ne leur ajoute qu'un malt.
* Autre option possible : sous bière, scinder en avec Malt et sans Malt. Puis les bières sans Malt peuvent à leur tour être spécialisées. Mais on retombe alors dans le problème initial.

## Visibilité

```viz
digraph acces{
  node [shape=box]; Supplier, Retailer, RetailerOfAlcohol, RetailerOfCandies, Person, Child;
  Retailer -> Supplier [label="supply"];
  RetailerOfCandies -> Supplier [label="supply"];
  RetailerOfAlcohol -> Supplier [label="supply"];
  Retailer -> Retailer [label="sell"];
  RetailerOfAlcohol -> Retailer [label="sell"];
  RetailerOfCandies -> Retailer [label="sell"];
  Retailer -> RetailerOfCandies [label="sell"];
  RetailerOfAlcohol -> RetailerOfCandies [label="sell"];
  RetailerOfCandies -> RetailerOfCandies [label="sell"];
  Retailer -> RetailerOfAlcohol [label="sell"];
  RetailerOfAlcohol -> RetailerOfAlcohol [label="sell"];
  RetailerOfCandies -> RetailerOfAlcohol [label="sell"];
  RetailerOfCandies -> Retailer [arrowhead=onormal];
  RetailerOfAlcohol -> Retailer [arrowhead=onormal];
Person -> Retailer [label="sell"];
Person -> Supplier [label="retailerList"];
Child -> Supplier [label="retailerList"];
Child -> RetailerOfCandies[label="sell"];
Child -> Person[arrowhead=onormal];
}
```
Si on met tout le monde dans le même package :
* Supplier::retailerList : on sait juste que les personnes y accèdent ... On ne sait pas qui ne doit pas y accéder ...
* Supplier::supply : seuls les revendeurs peuvent y accéder
* Retailer::sell package : accès à la hiérarchie mais aussi à Child, ce qu'il ne faut pas
* Retailer::sell protected : accès à la hiérarchie (OK) mais pas à Person

On envisage donc de mettre ensemble les vendeurs de bonbons et les enfants dans un package, et les autres classes dans un autre package. Sémantiquement c'est assez louche.
* RetailerOfCandies::sell est protégé : accès à Child
* Retailer::sell et RetailerOfAlcohol::sell sont protégées : accès à la redéfinition par RetailerOfCandies, et accès à l'appel des retailer
* Mais alors pour Supplier::supply on est coincé : quoiqu'on mette on est trop ou pas assez permissif

* Finalement, comme séparer en deux packages comme précédemment fait peut de sens, on garde une version plus logique mais trop permissive avec toutes les classes dans le même package. Et on éduquera les enfants pour qu'ils n'essaient pas d'acheter d'alcool.
