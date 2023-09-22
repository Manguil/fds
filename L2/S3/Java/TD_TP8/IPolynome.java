public interface IPolynome {
    String toString();
    boolean estNul();
    int degreMax();
    void ajoutMonome(Monome2 m);
    IPolynome derivee();
}
