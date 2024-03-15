package part2;

import java.util.Random;

public class NutAllergyFat {
    private String[] fats = {"Avocado", "Sour cream", "Tuna"};


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
