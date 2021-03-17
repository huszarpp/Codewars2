package vovel_count;

public class Vowels {

    public static int getCount(String str) {
        int vowelsCount = 0;
        final String VOWELS = "aeiou";
        for (char c : str.toLowerCase().toCharArray()) {
            if (VOWELS.contains(String.valueOf(c))) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

}
