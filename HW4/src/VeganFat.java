import java.util.Random;

public class VeganFat {
    private String[] fats = {"Avocado", "Peanuts"};


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
