package rev_pers;

//mettre tout dans le même package est la moins pire solution
//mais cela ouvre quand même trop d'accès !

public class Person_rev_pers {

	
	public void test() {
		Retailer r = new Retailer(); r.sell();
		RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();		
		RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		Retailer rcrc = new RetailerOfCandies(); rcrc.sell();
		
		//rev_pers.can_child.RetailerOfCandies ccrc = new rev_pers.can_child.RetailerOfCandies(); ccrc.sell();
		
		// accès que l'on ne devrait pas avoir
		Supplier s = new Supplier(); s.supply(); s.retailerList();
	}

}
