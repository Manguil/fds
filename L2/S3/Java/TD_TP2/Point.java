public class Point {
    private double x;
    private double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point(" + x + "," + y + ")";
    }

    public double module() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public double distanceDe(Point p) {
        return Math.sqrt(Math.pow((x - p.x), 2) + Math.pow((y - p.y), 2));
    }

    public Point symetrique() {
        Point temp = new Point(-x, -y);
        return temp;
    }
}