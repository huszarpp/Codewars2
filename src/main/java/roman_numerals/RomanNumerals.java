package roman_numerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumerals {

    public static String toRoman(int arabianNumeral) {
        int[] divisors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanDigits = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = 0; i < divisors.length; i++) {
            int quotient = arabianNumeral / divisors[i];
            for (int j = 1; j <= quotient; j++) {
                romanNumeral.append(romanDigits[i]);
            }
            arabianNumeral -= quotient * divisors[i];
        }
        return romanNumeral.toString();
    }

    public static int fromRoman(String romanNumeral) {
        List<Character> romanDigits = Arrays.asList('M', 'D', 'C', 'L', 'X', 'V', 'I');
        List<Integer> multipliers = Arrays.asList(1000, 500, 100, 50, 10, 5, 1);
        int arabianNumeral = 0;
        char lastChar = romanNumeral.charAt(0);
        for (int i = 1; i < romanNumeral.length(); i++) {
            if (romanDigits.indexOf(romanNumeral.charAt(i)) < romanDigits.indexOf(lastChar)) {
                arabianNumeral -= multipliers.get(romanDigits.indexOf(lastChar));
            } else {
                arabianNumeral += multipliers.get(romanDigits.indexOf(lastChar));
            }
            lastChar = romanNumeral.charAt(i);
        }
        arabianNumeral += multipliers.get(romanDigits.indexOf(lastChar));

        return arabianNumeral;
    }
}
