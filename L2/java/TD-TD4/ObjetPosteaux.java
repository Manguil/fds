import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ObjetPosteaux {
    private String origine;
    private String destination;
    private int codePostal;
    private double poids;

    public double getPoids() {
        return poids;
    }

    private double volume;

    public double getVolume() {
        return volume;
    }

    private int tauxRecommandation;

    public int getTauxRecommandation() {
        return tauxRecommandation;
    }

    public ObjetPosteaux(String origine, String destination, int codePostal, double poids, double volume,
            int tauxRecommandation) {
        this.origine = origine;
        this.destination = destination;
        this.codePostal = codePostal;
        this.poids = poids;
        this.volume = volume;
        this.tauxRecommandation = tauxRecommandation;
    }

    public String toString() {
        return codePostal + "/" + destination + "/" + tauxRecommandation;
    }

    public double tarifAffranchissement() {
        double prix = 0;
        prix = 0.5 * getTauxRecommandation();
        if (getTauxRecommandation() == 2) {
            prix += 0.5;
        }
        return prix;
    }
    // public abstract int tarifRemboursement();
}

class Lettre extends ObjetPosteaux {
    private Rapidite modeEnvoi;

    public Lettre(String origine, String destination, int codePostal, double poids, double volume,
            int tauxRecommandation, String modeEnvoi) {
        super(origine, destination, codePostal, poids, volume, tauxRecommandation);
        this.modeEnvoi = Rapidite.valueOf(modeEnvoi);
    }

    @Override
    public String toString() {
        return "Lettre " + super.toString() + "/" + modeEnvoi;
    }

    public double tarifAffranchissement() {
        double prix = 0.5;
        if (modeEnvoi == Rapidite.urgent) {
            prix += 0.3;
        }
        return super.tarifAffranchissement() + prix;
    }

    public double tarifRemboursement() {
        double remboursement = 0;
        if (getTauxRecommandation() != 0) {
            remboursement = 1.5 * Math.pow(10, getTauxRecommandation());
        }
        return remboursement;
    }
}

class Colis extends ObjetPosteaux {
    private String contenu;
    private double prix;

    public Colis(String origine, String destination, int codePostal, double poids, double volume,
            int tauxRecommandation, String contenu, double prix) {
        super(origine, destination, codePostal, poids, volume, tauxRecommandation);
        this.contenu = contenu;
        this.prix = prix;
    }

    @Override
    public double tarifAffranchissement() {
        double prix = 2;
        if (getVolume() > 1 / 8) {
            prix += 3;
        }
        return super.tarifAffranchissement() + prix;
    }

    public double tarifRemboursement() {
        double remboursement = 0;
        switch (getTauxRecommandation()) {
            case 0: {
                break;
            }
            case 1: {
                remboursement *= 10 / 100;
                break;
            }
            case 2: {
                remboursement *= 50 / 100;
                break;
            }
        }
        return remboursement;
    }

    @Override
    public String toString() {
        return "Colis " + super.toString() + "/" + getVolume() + "/" + prix;
    }

    public String toString(boolean isColisExpress) {
        return super.toString() + "/" + getVolume() + "/" + prix;
    }
}

class ColisExpress extends Colis {
    protected static SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
    private static final double poidsMax = 30;
    private Date dateEnvoi;
    private static int nbColisExpress = 200000;
    private int numeroSuivi;
    private boolean emballage;

    public ColisExpress(String origine, String destination, int codePostal, double poids, double volume,
            int tauxRecommandation, String contenu, double prix, boolean emballage) {
        super(origine, destination, codePostal, poids, volume, tauxRecommandation, contenu, prix);
        this.emballage = emballage;
        this.dateEnvoi = new Date();
        numeroSuivi = nbColisExpress;
        ColisExpress.nbColisExpress += 1;
    }

    @Override
    public double tarifAffranchissement() {
        double prix = 30;
        if (emballage) {
            prix += 3;
        }
        return prix;
    }

    @Override
    public double tarifRemboursement() {
        return super.tarifRemboursement();
    }

    @Override
    public String toString() {
        return "Colis Express " + super.toString(true) + "/" + getPoids() + "/" + numeroSuivi;
    }

    public String Envoi() {
        return format.format(dateEnvoi);
    }
}