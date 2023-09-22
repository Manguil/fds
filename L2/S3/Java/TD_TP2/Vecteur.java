public class Vecteur {
	private Point p = new Point();

	public Vecteur(double x, double y) {
		/*Point p = new Point();*/
		p.setX(x);
		p.setY(y);
	}

	public Vecteur(Point p1, Point p2) {
		/*Point p = new Point();*/
		p.setX(p2.getX() - p1.getX());
		p.setY(p2.getY() - p1.getY());
	}

	public Vecteur sommeAvec(Vecteur v) {
		Vecteur vTemp = new Vecteur(this.p.getX() + v.p.getX(), this.p.getY() + v.p.getY());
		return vTemp;
	}

	public void ajouter(Vecteur v) {
		this.p.setXY(this.p.getX() + v.p.getX(), this.p.getY() + v.p.getY());
	}

	public Vecteur somme(Vecteur v1, Vecteur v2) {
		Vecteur vTemp = new Vecteur(v1.p.getX() + v2.p.getX(), v1.p.getY() + v2.p.getY());
		return vTemp;
	}
}