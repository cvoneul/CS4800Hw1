import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CharacterProperties charProp1 = CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 12);
        CharacterProperties charProp2 = CharacterPropertiesFactory.getCharacterProperties("Calibri", "Blue", 14);
        CharacterProperties charProp3 = CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 16);
        CharacterProperties charProp4 = CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 14);

        Document document = new Document();

        document.addCharacter('H', charProp1);
        document.addCharacter('e', charProp2);
        document.addCharacter('l', charProp3);
        document.addCharacter('l', charProp4);
        document.addCharacter('o', charProp4);
        document.addCharacter('W', charProp3);
        document.addCharacter('o', charProp2);
        document.addCharacter('r', charProp1);
        document.addCharacter('l', charProp1);
        document.addCharacter('d', charProp3);
        document.addCharacter('C', charProp1);
        document.addCharacter('S', charProp4);
        document.addCharacter('5', charProp2);
        document.addCharacter('8', charProp2);
        document.addCharacter('0', charProp2);
        document.addCharacter('0', charProp4);

        document.save("doc.txt");

        Document doc = new Document();
        doc.load("doc.txt");

        document.print();
        System.out.println("\n");
        doc.print();
    }
}
