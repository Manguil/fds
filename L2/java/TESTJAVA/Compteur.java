public class Compteur {
    protected int val;
	public int getVaI( ) { return this.val; }
	public void inc( ) { this.val++; } 
}
class CompteurDoubIeFonction extends Compteur {
	public CompteurDoubIeFonction ( int val ) { this.val = val; }
	public void dec( ) { this.val = val; }
}