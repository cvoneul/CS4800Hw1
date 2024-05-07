import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

        ArrayList<Snack> snacks = new ArrayList<>();

        Snack coke = new Snack("Coke", 1.10, 10);
        Snack pepsi = new Snack("Pepsi", 1.05, 10);
        Snack cheetos = new Snack("Cheetos", 2.10, 10);
        Snack doritos = new Snack("Doritos", 2.05, 10);
        Snack kitkat = new Snack("Kitkat", .99, 10);
        Snack snickers = new Snack("Snickers", .90, 1);

        snacks.add(coke);
        snacks.add(pepsi);
        snacks.add(cheetos);
        snacks.add(doritos);
        snacks.add(kitkat);
        snacks.add(snickers);

        VendingMachine vendingMachine = new VendingMachine(snacks);

        vendingMachine.selectSnack(cheetos);
        vendingMachine.insertMoney(2.10);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(.90);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(.90);
        vendingMachine.dispenseSnack();
    }
}
