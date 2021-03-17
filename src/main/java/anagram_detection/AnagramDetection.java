package anagram_detection;

import java.util.*;

public class AnagramDetection {

    public static boolean isAnagram(String test, String original) {

        if (test.length() != original.length()) {
            return false;
        }

        List<String> testList = new ArrayList<>(Arrays.asList(test.toLowerCase().split("")));
        List<String> originalList = new ArrayList<>(Arrays.asList(original.toLowerCase().split("")));
        Collections.sort(testList);
        Collections.sort(originalList);

        for (int i = 0; i < testList.size(); i++) {
            if (!testList.get(i).equals(originalList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
