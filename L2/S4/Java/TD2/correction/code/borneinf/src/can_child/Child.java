package can_child;

import rev_pers.*;

// se mettre dans un sous-package n'aide pas car on n'a plus accès à rien !

public class Child extends Person {
	
	public void test() {

		//Retailer r = new Retailer(); r.sell();
		//RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();		
		RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		//Retailer rcrc = new RetailerOfCandies(); rcrc.sell();
		
		// accès manquant 
		//Supplier s = new Supplier(); s.supply(); s.retailerList();
	}

}
