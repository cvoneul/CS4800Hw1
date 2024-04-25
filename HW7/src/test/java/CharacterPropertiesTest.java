import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CharacterPropertiesTest {

    @Test
    public void basicGetPropertiesTest() {
        CharacterProperties properties1 = CharacterPropertiesFactory.getCharacterProperties("arial","blue", 12);

        String expected = "arialblue12.0";
        String actual1 = properties1.getFont() + properties1.getColor() + properties1.getSize();

        CharacterProperties properties2 = CharacterPropertiesFactory.getCharacterProperties("arial", "blue", 12);

        String acutal2 = properties2.getFont() + properties2.getColor() + properties2.getSize();
        assertEquals(expected,actual1, acutal2);
    }

    @Test
    public void checkIfTwoSamePropertiesAreActuallyTheSameFlyweightObjectReference() {
        CharacterProperties properties1 = CharacterPropertiesFactory.getCharacterProperties("arial","blue", 12);
        CharacterProperties properties2 = CharacterPropertiesFactory.getCharacterProperties("arial", "blue", 12);

        String expected = properties1.toString();
        String actual = properties2.toString();

        assertEquals(expected,actual);
    }
}
