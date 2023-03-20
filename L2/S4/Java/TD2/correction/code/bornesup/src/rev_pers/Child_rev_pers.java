package rev_pers;



//mettre tout dans le même package est la moins pire solution
// mais cela ouvre quand même trop d'accès !

public class Child_rev_pers extends Person_rev_pers {
	
	public void test() {
		
		RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		
		// accès que l'on ne devrait pas avoir		
		Retailer r = new Retailer(); r.sell();
		RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();	// trop permissif !		
		Supplier s = new Supplier(); s.supply(); s.retailerList();
	}

}
