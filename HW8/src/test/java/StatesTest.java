import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StatesTest {
    private VendingMachine vendingMachine;
    Snack coke, pepsi, cheetos, doritos, kitkat, snickers;

    public void init() {
        ArrayList<Snack> snacks = new ArrayList<>();

        coke = new Snack("Coke", 1.10, 10);
        pepsi = new Snack("Pepsi", 1.05, 10);
        cheetos = new Snack("Cheetos", 2.10, 10);
        doritos = new Snack("Doritos", 2.05, 10);
        kitkat = new Snack("Kitkat", .99, 10);
        snickers = new Snack("Snickers", .90, 1);

        snacks.add(coke);
        snacks.add(pepsi);
        snacks.add(cheetos);
        snacks.add(doritos);
        snacks.add(kitkat);
        snacks.add(snickers);

        vendingMachine = new VendingMachine(snacks);
    }


    @Test
    public void selectSnackIdleTest() {
        init();
        vendingMachine.selectSnack(doritos);

        String expected = "Doritos";
        String actual = vendingMachine.getCurrentSnack().getName();

        assertEquals(expected, actual);
    }


    @Test
    public void waitingForMoneyStateValidPriceTest() {
        init();
        vendingMachine.selectSnack(doritos);
        vendingMachine.insertMoney(2.05);

        assertTrue(vendingMachine.getState() instanceof DispensingSnackState);
    }

    @Test
    public void waitingForMoneyStateInvalidPriceTest() {
        init();
        vendingMachine.selectSnack(doritos);
        vendingMachine.insertMoney(1.05);

        assertFalse(vendingMachine.getState() instanceof DispensingSnackState);
    }

    @Test
    public void dispensingSnackStateQuantityTest() {
        init();
        vendingMachine.selectSnack(doritos);
        vendingMachine.insertMoney(2.05);

        int oldQuantity = doritos.getQuantity();

        vendingMachine.dispenseSnack();

        assertTrue(oldQuantity == doritos.getQuantity() + 1);
    }
}
