package mcu2;
import java.util.*;

public class MultiMaltBeer extends Beer {
	
    private double beerVolume; //L
    private Map<Malt,Double> ingredients = new  HashMap<Malt,Double>();

	public MultiMaltBeer(double vol) {
		this.beerVolume = vol;
	}
	
	public void addMalt(Malt m, double d) throws MaltAlreadyAddedException {
		ingredients.put(m, d);
	}
	
	public int nbMalts() {return this.ingredients.size();}
	

	@Override
	public double beerEBC() 
    {return 2.939*Math.pow(MCU(), 0.6859);}	
	
    public double MCU() {
    	double mcu=0;
    	for (Malt m : ingredients.keySet())
    		mcu +=  4.23*m.getMaltEBC()*
    				ingredients.get(m)/beerVolume;
    	return mcu;
    }

}
