package assertionsExceptionsSolution;

import java.util.*;

public class MainTestPile {
public static void main(String[]a) {
	Pile p = new Pile();
	// mais si on fait (a tester)
	// Pile p = new PileBornee();
	// on aura des problemes lors de l'execution
	// donc une pile bornee peut remplacer syntaxiquement une pile
	// mais pas du point de vue du comportement
	// = pas d'erreur de compilation mais une erreur d'execution
	try {
		System.out.println(p);
		p.empiler("a"); p.empiler("b");
		p.empiler("c"); p.empiler("d");
		p.empiler("a"); p.empiler("b");
		p.empiler("c"); p.empiler("d");
		p.empiler("a"); p.empiler("b");
		p.empiler("c"); p.empiler("d");
		System.out.println(p);
		//p.depiler();
		System.out.println(p);
		p.depiler(); p.depiler();
		p.depiler(); p.depiler();
		System.out.println(p);
	}
	catch (Exception e) {e.printStackTrace();}
	
	PileBornee p2 = new PileBornee();
	try {
		p2.empiler("a"); p2.empiler("b");
		p2.empiler("c"); p2.empiler("d");
		p2.empiler("a"); p2.empiler("b");
		p2.setTailleMax(8);
		System.out.println("p2 "+p2);
	}catch (Exception e) {e.printStackTrace();}
}
}
