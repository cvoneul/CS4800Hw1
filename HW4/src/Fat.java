import java.util.Random;

public class Fat {
    private String[] fats = {"Avocado", "Sour cream", "Tuna", "Peanuts"};

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
