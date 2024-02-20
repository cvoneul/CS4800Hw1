package Problem2;

public class Main {
    private static Ship[] ships = new Ship[3];
    public static void main(String[] args) {
        ships[0] = new CruiseShip("cruisy", "1995", 300);
        ships[1] = new CargoShip("cargooey", "2000", 500);
        ships[2] = new Ship("shippy", "1999");

        for(Ship ship: ships) {
            ship.printShip();
        }

    }
}
