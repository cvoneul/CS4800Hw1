public class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectSnack(Snack snack) {
        System.out.println("Selected snack: " + snack.getName());
        vendingMachine.setCurrentSnack(snack);
        vendingMachine.setState(vendingMachine.getWaitingForMoneyState());
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("First you must choose a snack");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("First you must choose a snack");
    }
}
