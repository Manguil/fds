package mcu;

public class MainMCU {

	public static void main(String[] args) {
		
		Beer b1 = new SingleMaltBeer(2,50,48);
		System.out.println(b1.beerEBC());
		
		Malt m1 = new Malt(48);
		Malt m2 = new Malt(80);
		
		MultiMaltBeer b2 = new MultiMaltBeer(50);
		b2.addIngredient(m1, 2);
		System.out.println(b2.beerEBC());
		b2.addIngredient(m2, 3);
		System.out.println(b2.beerEBC());
		
	}

}
