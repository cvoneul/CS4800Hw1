public class Bacon extends ItemWithTopping {
    private double additionalCost = 1.00;

    public Bacon(Item item) {
        super(item);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + additionalCost;
    }
}
