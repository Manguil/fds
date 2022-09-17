public class Te {
    public static void main(String[] args) {
        Personnage mathis = new Personnage("Manguil", 100, 20);
        Personnage poki = new Personnage("Popoki le chat", 100, 1000);
        Personnage flex = new Personnage("Ronflex", 150, 1500);
        flex.donnerPiecesA(poki, 25);
    }
}