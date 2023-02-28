package genericiteSimple;

public class PaireStatistiques<A,B> extends Paire<A,B> {
	public static int nbPaires=0;
	public static int nbAccesLectureFirst=0;	
	public static int nbAccesEcritureFirst=0;	
	public static int nbAccesLectureSecond=0;	
	public static int nbAccesEcritureSecond=0;
	public PaireStatistiques() {
		nbPaires++;
	}
	public PaireStatistiques(A f, B s) {
		super(f, s);
		nbPaires++;
	}
	@Override
	public A getFst() {
		nbAccesLectureFirst++;
		return super.getFst();
	}
	@Override
	public B getSnd() {
		nbAccesLectureSecond++;
		return super.getSnd();
	}
	@Override
	public void setFst(A a) {
		nbAccesEcritureFirst++; super.setFst(a);
	}
	@Override
	public void setSnd(B b) {
		nbAccesEcritureSecond++; super.setSnd(b);
	}
	
	public static String stat()
	{
		return "nbPaires="+ nbPaires 
				+"\nnbAccesLectureFirst=" +nbAccesLectureFirst
				+"\nnbAccesEcritureFirst="+nbAccesEcritureFirst
				+"\nnbAccesLectureSecond="+nbAccesLectureSecond
				+"\nnbAccesEcritureSecond="+nbAccesEcritureSecond;
	}
	
	public static void main(String[] a)
	{
		PaireStatistiques<String,Integer> p1 = new PaireStatistiques<String,Integer>();
		PaireStatistiques<String,Integer> p2 = new PaireStatistiques<String,Integer>();
		PaireStatistiques<Integer,Personne> p3 = new PaireStatistiques<Integer,Personne>();
		p1.setFst("ecriture first"); p3.setFst(4);
		p1.setFst("ecriture first"); p2.setSnd(5);	
		System.out.println(PaireStatistiques.stat());
	}
}