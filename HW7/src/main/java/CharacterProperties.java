import java.io.Serializable;

public class CharacterProperties implements Serializable {
    private String font;
    private String color;
    private double size;

    public CharacterProperties(String font, String color, double size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }


    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
