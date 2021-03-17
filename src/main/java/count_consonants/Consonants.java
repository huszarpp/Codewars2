package count_consonants;

public class Consonants {

    public static int getCount(String str) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int consonantCounter = 0;
        for (char c : str.toLowerCase().toCharArray()) {
           if (consonants.contains(String.valueOf(c))) {
               consonantCounter++;
           }
        }
        return consonantCounter;
    }
}
