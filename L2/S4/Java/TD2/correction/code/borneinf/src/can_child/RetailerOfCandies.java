package can_child;

import rev_pers.*;

public class RetailerOfCandies extends Retailer {
	
	// pour se redonner accès à sell ici et dans child ...
	@Override
	protected void sell(){super.sell();}

	public void test() {
		
		// Quelques accès manquants
		// Retailer r = new Retailer(); r.sell();
		// RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();		
		RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		//Retailer rcrc = new RetailerOfCandies(); rcrc.sell();
		
		//rev_pers.can_child.RetailerOfCandies ccrc = new rev_pers.can_child.RetailerOfCandies(); ccrc.sell();
		
		// Quelques accès manquants
		//Supplier s = new Supplier(); s.supply(); s.retailerList();
	}
}
