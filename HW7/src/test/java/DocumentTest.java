import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentTest {
    CharacterProperties charProp1 = CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 12);
    CharacterProperties charProp2 = CharacterPropertiesFactory.getCharacterProperties("Calibri", "Blue", 14);
    CharacterProperties charProp3 = CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 16);
    CharacterProperties charProp4 = CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 14);

    @Test
    public void addCharacterTest() {
        Document d = new Document();
        d.addCharacter('h', charProp1);

        String expected = "";
        String actual = "";

        expected += 'h';
        actual += d.getCharAt(0).getCharacter() ;
        assertEquals(expected, actual);
    }

    @Test
    public void saveTest() throws IOException { //saves to "C:\Users\19095\Documents\GitHub\cs4800HW1\HW7\"
        Document d = new Document();
        d.addCharacter('h', charProp1);

        d.save("test.bin");
    }

    @Test
    public void loadTest() throws IOException, ClassNotFoundException {
        //saveTest() must have already run before this
        Document d = new Document();
        d.load("test.bin");
        d.print();
    }

    @Test
    public void printTest() {
        Document d = new Document();
        d.addCharacter('h', charProp1);
        d.addCharacter('e', charProp2);
        d.addCharacter('l', charProp3);
        d.addCharacter('l', charProp4);
        d.addCharacter('o', charProp1);

        d.print();
    }
}
