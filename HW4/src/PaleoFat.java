import java.util.Random;

public class PaleoFat {
    private String[] fats = {"Avocado", "Tuna", "Peanuts"};

    public String generateFat() {
        int rand = new Random().nextInt(fats.length);
        return fats[rand];
    }

    public String[] getFats() {
        return fats;
    }

    public void setFats(String[] fats) {
        this.fats = fats;
    }
}
