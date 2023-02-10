package voyages;

public class OpenMoogleGapsTravelInfo {
    // notons qu'ici un record serait plus approprié ; les records ont été introduits en Java 14
    private final int duration; // en minutes
    private final float distance; // en kilometres
    private final int price; // en euros

    public OpenMoogleGapsTravelInfo(int duration, float distance, int price) {
        this.duration = duration;
        this.distance = distance;
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public float getDistance() {
        return distance;
    }

    public int getPrice() {
        return price;
    }
}
