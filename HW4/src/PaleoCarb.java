import java.util.Random;

public class PaleoCarb {
    private String[] carbs = {"Pistachio"};

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
