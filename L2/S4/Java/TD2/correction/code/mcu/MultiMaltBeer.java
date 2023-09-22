package mcu;
import java.util.*;

public class MultiMaltBeer extends Beer {
	
    private double beerVolume; //L
    private Map<Malt,Double> ingredients = new  HashMap<Malt,Double>();

	public MultiMaltBeer(double vol) {
		this.beerVolume = vol;
	}
	
	public void addIngredient(Malt m, double d) {
		ingredients.put(m, d);
	}
	
	// on redéfinit MCU par masquage
	@Override
    public double MCU() {
    	double mcu=0;
    	for (Malt m : ingredients.keySet())
    		mcu +=  4.23*m.getMaltEBC()*
    				ingredients.get(m)/beerVolume;
    	return mcu;
    }

}
