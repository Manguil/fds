package rev_pers;

public class Retailer {
	
	void sell(){}

	public Retailer() {
	}

	public void test() {

		Retailer r = new Retailer(); r.sell();
		RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();		
		RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		Retailer rcrc = new RetailerOfCandies(); rcrc.sell();

	}
}
