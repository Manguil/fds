package rev_pers;

import can_child.*;

public class RetailerOfAlcohol extends Retailer {

	public RetailerOfAlcohol() {
		// TODO Auto-generated constructor stub
	}
	
	public void test() {

		Retailer r = new Retailer(); r.sell();
		RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();	
		// Quelques accès manquants
		//Supplier s = new Supplier(); s.supply(); s.retailerList();
		//RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		// contournement
		Retailer rcrc = new RetailerOfCandies(); rcrc.sell();

	}

}
