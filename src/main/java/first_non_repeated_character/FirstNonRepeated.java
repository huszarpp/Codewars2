package first_non_repeated_character;

public class FirstNonRepeated {
    public static Character firstNonRepeated(String source) {
        boolean hasMatch = false;
        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < source.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (source.toLowerCase().charAt(i) == source.toLowerCase().charAt(j)) {
                    hasMatch = true;
                }
            }
            if (!hasMatch) {
                return source.charAt(i);
            }
            hasMatch = false;
        }
        return null;
    }
}
