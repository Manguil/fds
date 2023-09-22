import java.util.Arrays;

public class SyntheseMeteo {
    private final String ville;
    private float[] tmin;
    private float[] tmax;

    public SyntheseMeteo(String ville) {
        this.ville = ville;
    }

    public SyntheseMeteo(String ville, float[] tmin, float[] tmax) {
        this(ville);
        this.tmin = tmin;
        this.tmax = tmax;
    }

    @Override
    public String toString() {
        return "SyntheseMeteo{" +
                "ville='" + ville + '\'' +
                ", tmin=" + Arrays.toString(tmin) +
                ", tmax=" + Arrays.toString(tmax) +
                '}';
    }

    public float temperatureMensuelleMax() {
        float result = tmax[0];
        for (int i = 1; i < tmax.length; i++) {
            if (tmax[i] > result) {
                result = tmax[i];
            }
        }
        return result;
    }

    public void setTmin(int numMois, float valeur) {
        if (tmin != null) {
            if ((numMois >= 1 && numMois <= 12) && (valeur >= -100 && valeur <= 100)) {
                tmin[numMois - 1] = valeur;
            }
        }
    }
    

    public Mois moisLePlusChaud() {
        float result = tmax[0];
        int pos = 0;
        for (int i = 0; i < tmax.length; i++) {
            if (tmax[i] > result) {
                result = tmax[i];
                pos = i;
            }
        }
        return numMoisVersMois(pos+1);
    }
    private Mois numMoisVersMois(int numMois){
        //return Mois.values()[numMois-1]; // Cette instruction aurait suffit mais la comprenez-vous ?
        switch (numMois){
            case 1:return Mois.JANVIER;
            case 2:return Mois.FEVRIER;
            case 3:return Mois.MARS;
            case 4:return Mois.AVRIL;
            case 5:return Mois.MAI;
            case 6: return Mois.JUIN;
            case 7: return Mois.JUILLET;
            case 8: return Mois.AOUT;
            case 9: return Mois.SEPTEMBRE;
            case 10: return Mois.OCTOBRE;
            case 11: return Mois.NOVEMBRE;
            case 12: return Mois.DECEMBRE;
            default: return null;
        }
    }

    private int moisVersNumMois(Mois mois){
        //return Mois.mois.ordinal()+1; // Cette instruction aurait suffit mais la comprenez-vous ?
        switch (mois){
            case JANVIER : return 1;
            case FEVRIER : return 2;
            case MARS : return 3;
            case AVRIL : return 4;
            case MAI : return 5;
            case JUIN : return 6;
            case JUILLET : return 7;
            case AOUT : return 8;
            case SEPTEMBRE : return 9;
            case OCTOBRE : return 10;
            case NOVEMBRE : return 11;
            case DECEMBRE : return 12;
            default: return -1;
        }
    }
}