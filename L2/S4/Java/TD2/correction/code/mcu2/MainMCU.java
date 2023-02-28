package mcu2;

public class MainMCU {

	/*
	 * Le programme montre aussi que SingleMaltBeer ne se subtitue pas du point de
	 * vue du comportement à MultiMaltBeer puisqu'une exception est déclenchée par 
	 * b1.addMalt(m2, 3);
	 * 
	 */
	public static void main(String[] args) {
		try{
			Malt m1 = new Malt(48);
			Malt m2 = new Malt(80);

			MultiMaltBeer b1 = new SingleMaltBeer(50);
			b1.addMalt(m1, 2);
			//b1.addMalt(m2, 3);
			System.out.println(b1.beerEBC());
				
			MultiMaltBeer b2 = new MultiMaltBeer(50);
			b2.addMalt(m1, 2);
			System.out.println(b2.beerEBC());
			b2.addMalt(m2, 3);
			System.out.println(b2.beerEBC());
		}
		catch (MaltAlreadyAddedException e) {System.out.println(e.getMessage());}
	}

}
