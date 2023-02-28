package mcu;

public class Malt {
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
