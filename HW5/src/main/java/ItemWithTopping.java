public abstract class ItemWithTopping implements Item {
    protected Item item;

    public ItemWithTopping(Item item) {
        this.item = item;
    }

    @Override
    public double calculateCost() {
        return item.calculateCost();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
