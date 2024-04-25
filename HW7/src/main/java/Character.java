import java.io.Serializable;

public class Character implements Serializable {
    private char character;
    private CharacterProperties charProperties;

    public Character(char character, CharacterProperties charProperties) {
        this.character = character;
        this.charProperties = charProperties;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public CharacterProperties getCharProperties() {
        return charProperties;
    }

    public void setCharProperties(CharacterProperties charProperties) {
        this.charProperties = charProperties;
    }
}
