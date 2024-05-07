public class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(Snack snack) {
        System.out.println("A snack has already been chosen...Waiting for money");
    }

    @Override
    public void insertMoney(double amount) {
        double price = vendingMachine.getCurrentSnack().getPrice();
        System.out.println("Processing payment");
        if(price <= amount) {
            vendingMachine.setState(vendingMachine.getDispensingSnackState());
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void dispenseSnack() {
        System.out.println("You must first insert money");
    }
}
