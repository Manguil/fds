package creneaux;

import java.time.LocalTime;

public class CreneauHoraireNormal implements CreneauHoraire {
	private LocalTime debut;
	private int duree; // en minutes

	@Override
	public int heureDebut() {
		return debut.getHour();
	}

	@Override
	public int minutesDebut() {
		return debut.getMinute();
	}

	@Override
	public int duree() {
		return duree;
	}
	
	public CreneauHoraireNormal(int hd, int mnd, int duree) {
		this.duree=duree;
		this.debut=LocalTime.of(hd, mnd);
	}
	
	public  String toString() {
		return "["+heuredebutformattee()+", "+duree()+" mn]";
	}

}
