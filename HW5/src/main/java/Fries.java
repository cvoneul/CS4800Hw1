public class Fries implements Item {
    private double baseCost = 1.50;
    @Override
    public double calculateCost() {
        return baseCost;
    }
}
