package reverse_words;

public class ReverseWords {
    public static String reverseWords(final String original) {
        String[] stringArray = original.split(" ");
        if (stringArray.length == 0) {
            return original;
        }
        StringBuilder sb = new StringBuilder();
        String separator = "";
        for (int i = 0; i < stringArray.length; i++) {
            sb.append(separator);
            sb.append(new StringBuilder(stringArray[i]).reverse().toString());
            separator = " ";
        }
        return sb.toString();
    }
}
