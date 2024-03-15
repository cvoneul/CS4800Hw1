package part2;

import java.util.Random;

public class VeganCarb {
    private String[] carbs = {"Bread", "Lentils", "Pistachio"};

    public String generateCarb() {
        int rand = new Random().nextInt(carbs.length);
        return carbs[rand];
    }

    public String[] getCarbs() {
        return carbs;
    }

    public void setCarbs(String[] carbs) {
        this.carbs = carbs;
    }
}
