package creneaux;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CreneauHoraireFDS implements CreneauHoraire {
	private int numHoraireDebut; 
	private int nbSeances;
	private static final int dureeSeance=90;
	private static final HashMap<Integer, List<Integer>> mappingNumCreneauVersHoraire;
	// il faudrait placer ici des attr de classe pour 90 et 15 ...
	
	static {
		mappingNumCreneauVersHoraire =new HashMap<>();
		mappingNumCreneauVersHoraire.put(1, Arrays.asList(8,0));
		mappingNumCreneauVersHoraire.put(2, Arrays.asList(9,45));
		mappingNumCreneauVersHoraire.put(3, Arrays.asList(11,30));
		mappingNumCreneauVersHoraire.put(4, Arrays.asList(13,15));
		mappingNumCreneauVersHoraire.put(5, Arrays.asList(15,0));
		mappingNumCreneauVersHoraire.put(6, Arrays.asList(16,45));
		mappingNumCreneauVersHoraire.put(7, Arrays.asList(18,30));
	}

	

	public CreneauHoraireFDS(int numHoraireDebut, int nbSeances) {
		this.numHoraireDebut = numHoraireDebut;
		this.nbSeances = nbSeances;
	}

	@Override
	public int duree() {
		int pauses=(nbSeances==1)?0:(nbSeances-1)*15;
		return nbSeances*dureeSeance+pauses;
	}

	@Override
	public int heureDebut() {
		return mappingNumCreneauVersHoraire.get(numHoraireDebut).get(0);
	}

	@Override
	public int minutesDebut() {
		return mappingNumCreneauVersHoraire.get(numHoraireDebut).get(1);
	}

	public  String toString() {
		return "["+heuredebutformattee()+", "+duree()+" mn]";
	}

	

}
