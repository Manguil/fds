package mcu;

public class SingleMaltBeer extends Beer {

    private double maltWeight; //KG
    private double beerVolume; //L
    private double maltEBC; // en EBC
    public double getMaltWeight() {return maltWeight;}
    public double getBeerVolume() {return beerVolume;}
    public double getMaltEBC() {return maltEBC;}
    public SingleMaltBeer(double maltWeight, double beerVolume, double maltEBC) {
         this.maltWeight = maltWeight;    
         this.beerVolume = beerVolume;
         this.maltEBC = maltEBC;      
    }

}
