package creneaux;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;

public class Semainier {
	private HashMap<DayOfWeek, ArrayList<CreneauHoraire>> creneaux=new HashMap<>();
	
	public void ajoutCréneau(DayOfWeek jour, CreneauHoraire c) {
		ArrayList<CreneauHoraire> planningjour;
		if (!creneaux.containsKey(jour)) {
			planningjour=new ArrayList<CreneauHoraire>();
			planningjour.add(c);
			creneaux.put(jour,planningjour);
		}else {
			planningjour=creneaux.get(jour);
			boolean chevauche=false;
			for (CreneauHoraire ch:planningjour) {
				if (ch.chevauche(c)) {chevauche=true; break;}
			}
			if (!chevauche) {planningjour.add(c);};
		}
	}
	
	public String dumpInString() {
		String res="Semainier\n";
		// que les jours où il y a quelque chose de prévu ...
		for (DayOfWeek jour:creneaux.keySet()) {
			res+=jour+":\n";
			res+=creneaux.get(jour);
		}
		return res;
	}

	public static void main(String[] args) {
		Semainier s=new Semainier();
		CreneauHoraireFDS c1=new CreneauHoraireFDS(1, 2);
		CreneauHoraireNormal c2= new CreneauHoraireNormal(11,10, 60);
		CreneauHoraireNormal c3= new CreneauHoraireNormal(11,16, 60);
		s.ajoutCréneau(DayOfWeek.MONDAY, c1);
		s.ajoutCréneau(DayOfWeek.MONDAY, c2);
		s.ajoutCréneau(DayOfWeek.MONDAY, c3);
		System.out.println(s.dumpInString());
	}
}
