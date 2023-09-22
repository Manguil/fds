package correction.genericiteSimple;

import java.util.Date;

public class EntreeAgenda extends Paire<Date,String> {
	public EntreeAgenda() {	}
	public EntreeAgenda(Date f, String s) {super(f, s);}
	
	public static void main(String[] a){
		EntreeAgenda e1 = new EntreeAgenda(new Date(), "cours 4 FMIN220");
		System.out.println(e1);
	}
}
