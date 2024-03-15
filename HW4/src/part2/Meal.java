package part2;

public class Meal {
    private String carb;
    private String protein;
    private String fat;

    public Meal(String carb, String protein, String fat) {
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "part2.Carb: " + carb + ", part2.Protein: " + protein + ", part2.Fat: " + fat;
    }
}
