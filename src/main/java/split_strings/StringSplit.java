package split_strings;

public class StringSplit {
    public static String[] solution(String s) {
        String[] splitString;
        if (s.length() % 2 == 0) {
            splitString = new String[s.length() / 2];
        } else {
            splitString = new String[s.length() / 2 + 1];
        }
        for (int i = 0; i < s.length(); i += 2) {
            try {
                splitString[i / 2] = String.valueOf(s.charAt(i)) + s.charAt(i + 1);
            } catch (IndexOutOfBoundsException e) {
                splitString[i / 2] = String.valueOf(s.charAt(i)) + "_";
            }
        }
        return splitString;
    }
}