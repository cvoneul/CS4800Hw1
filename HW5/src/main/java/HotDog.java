public class HotDog implements Item {
    private double baseCost = 3.50;

    @Override
    public double calculateCost() {
        return baseCost;
    }
}
