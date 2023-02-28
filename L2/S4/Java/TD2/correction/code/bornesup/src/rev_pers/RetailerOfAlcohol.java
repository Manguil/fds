package rev_pers;

public class RetailerOfAlcohol extends Retailer {

	public RetailerOfAlcohol() {
		// TODO Auto-generated constructor stub
	}
	
	public void test() {

		Retailer r = new Retailer(); r.sell();
		RetailerOfAlcohol ra = new RetailerOfAlcohol(); ra.sell();		
		RetailerOfCandies rc = new RetailerOfCandies(); rc.sell();
		Retailer rcrc = new RetailerOfCandies(); rcrc.sell();

	}

}
