public class ManipulationsSyntheseMeteo {
    public static void main(String[] args) {
        float[] tmin = { 1, 2, 3, 4, 5, 12, 15, 16, 14, 12, 8, 3 };
        float[] tmax = { 7, 8, 14, 17, 20, 30, 37, 36, 29, 27, 19, 17 };
        SyntheseMeteo nimes = new SyntheseMeteo("Nîmes", tmin, tmax);
        System.out.println(nimes.temperatureMensuelleMax());

        SyntheseMeteo lille = new SyntheseMeteo("Lille");
        nimes.setTmin2(Mois.JANVIER, -3);
        lille.setTmin(13, 10);
        System.out.println(nimes.toString());
    }
}
