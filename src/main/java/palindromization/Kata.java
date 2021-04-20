package palindromization;

public class Kata {

    public static void main(String[] args) {
        System.out.println(Kata.palindromization("123", 3));
    }

    public static String palindromization(String elements, int n) {
        if ((elements.length() == 0) || (n < 2)) {
            return "Error!";
        }

        char[] resultArray = new char[n];
        for (int i = 0; i < (n + 1) / 2; i++) {
            resultArray[i] = elements.charAt(i % elements.length());
            resultArray[resultArray.length - 1 - i] = elements.charAt(i % elements.length());
        }
        return String.valueOf(resultArray);
    }
}
