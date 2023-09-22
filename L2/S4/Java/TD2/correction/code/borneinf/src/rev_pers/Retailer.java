package rev_pers;

import can_child.*;

public class Retailer {
	
	protected void sell(){}

	public Retailer() {
	}

	public void test() {

		Retailer r = new Retailer(); r.sell();
		RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();		
		
		//RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		Retailer rcrc = new RetailerOfCandies(); rcrc.sell();
		
		// accès que l'on devrait avoir
		//Supplier s = new Supplier(); s.supply();

	}
}
