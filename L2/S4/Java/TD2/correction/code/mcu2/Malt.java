package mcu2;

public class Malt {
	private String cereale; 
    private double maltEBC; // en EBC
	public Malt() {}
	public Malt(double ebc) {this.maltEBC=ebc;}
	public double getMaltEBC() {
		return maltEBC;
	}
	public void setMaltEBC(double maltEBC) {
		this.maltEBC = maltEBC;
	}
}
