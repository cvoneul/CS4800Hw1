public class Cheese extends ItemWithTopping {
    private double additionalCost = .50;

    public Cheese(Item item) {
        super(item);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + additionalCost;
    }
}
