public class Points {
    private double x;
    private double y;

    public Points() {
        x = 0;
        y = 0;
    }

    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Points(" + x + "," + y + ")";
    }

    public double module() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
    }

    public double distanceDe(Points p) {
        return Math.sqrt(Math.pow((x - p.x),2) + Math.pow((y - p.y),2));
    }

    public Points symetrique() {
        Points temp = new Points(-x, -y);
        return temp;
    }

}