public class Burger implements Item {
    private double baseCost = 4.50;

    @Override
    public double calculateCost() {
        return baseCost;
    }
}
