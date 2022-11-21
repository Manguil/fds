package creneaux;

// Horaire pour une activité
public interface CreneauHoraire {

	public static final String separateurHeuresMinutes=":";
		public default String heuredebutformattee() {//	heure formattée sous forme de chaîne HH:MN, par exemple 14:45 pour 14h45 
		String h=Integer.toString(heureDebut());
		String mn=Integer.toString(minutesDebut());
		if (h.length()==1) {h="0"+h;}
		if (mn.length()==1) {mn="0"+mn;}
		return h+separateurHeuresMinutes+mn;
	}
	public abstract int heureDebut(); // l'heure retournée doit être entre 0 et 23
	public abstract int minutesDebut(); // les minutes retournées doivent être entre 0 et 59
	public abstract int duree() ; // durée en minutes
	public default boolean chevauche(CreneauHoraire h) {
		int start =heureDebut()*60+minutesDebut();
		int end =start+duree();
		int starth =h.heureDebut()*60+h.minutesDebut();
		int endh =starth+h.duree();
		
		return (start <= endh) && (end>= starth);
		}
	/*
	 * on aimerait écrire ça, mais on ne peut pas ! Ce peut être l'occasion de glisser une classe abstraite entre l'interface et les 2 implémentations
	public default String toString() {
		return "["+heuredebutformattee()+", "+duree()+" mn]";
	}*/
}
