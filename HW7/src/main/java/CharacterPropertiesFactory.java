import java.util.HashMap;

public class CharacterPropertiesFactory {
    private static HashMap<String, CharacterProperties> map = new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + color + size;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        else {
            CharacterProperties characterProperties = new CharacterProperties(font,color,size);
            map.put(font+color+size, characterProperties);
            return characterProperties;
        }
    }
}
