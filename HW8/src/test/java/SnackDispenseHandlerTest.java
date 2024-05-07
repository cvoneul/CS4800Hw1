import org.junit.jupiter.api.Test;

public class SnackDispenseHandlerTest {
    SnackDispenseHandler handler, handler2;
    Snack coke, pepsi, cheetos, doritos, kitkat, snickers;

    public void init() {
        coke = new Snack("Coke", 1.10, 10);
        pepsi = new Snack("Pepsi", 1.05, 10);
        cheetos = new Snack("Cheetos", 2.10, 10);
        doritos = new Snack("Doritos", 2.05, 10);
        kitkat = new Snack("Kitkat", .99, 10);
        snickers = new Snack("Snickers", .90, 1);

        handler = new SnackDispenseHandler(coke);
        handler2 = new SnackDispenseHandler(pepsi);
        handler.nextHandler(handler2);
    }

    @Test
    public void dispenseValidPrintTest() {
        init();

        handler.dispense(coke);
    }

    @Test
    public void dispenseInvalidPrintTest() {
        init();

        handler.dispense(cheetos);
    }

    @Test
    public void dispenseChainPrintTest() {
        init();

        handler.dispense(pepsi);
    }
}
