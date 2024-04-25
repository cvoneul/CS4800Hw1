import java.io.*;
import java.util.ArrayList;

public class Document {
    private ArrayList<Character> chars = new ArrayList<>();

    public void addCharacter(char character, CharacterProperties characterProperties) {
        Character c = new Character(character, characterProperties);
        chars.add(c);
    }

    public void save(String fileName) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
        for(Character c: chars) {
            stream.writeObject(c);
        }
    }

    public void load(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName));

        boolean isEmpty = false;
        while (!isEmpty) {
            try {
                Character c = (Character) stream.readObject();
                chars.add(c);
            } catch (EOFException e) {
                isEmpty = true;
            }
        }
    }

    public void print() {
        for(Character c: chars) {
            System.out.println("Character:  " + c.getCharacter() + "  Font:" + c.getCharProperties().getFont()
                    + "  Color:" + c.getCharProperties().getColor()
                    + "  Size:" + c.getCharProperties().getSize());
        }
    }

    public ArrayList<Character> getChars() {
        return chars;
    }

    public void setChars(ArrayList<Character> chars) {
        this.chars = chars;
    }

    public Character getCharAt(int index) {
        return chars.get(index);
    }

}
