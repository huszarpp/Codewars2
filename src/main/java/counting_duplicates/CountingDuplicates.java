package counting_duplicates;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        Map<Character, Integer> counterMap = new HashMap<>();

        for (char c : text.toLowerCase().toCharArray()) {
            if (counterMap.containsKey(c)) {
                counterMap.put(c, counterMap.get(c) + 1);
            } else {
                counterMap.put(c, 1);
            }
        }

        int duplicateCounter = 0;

        for (Map.Entry<Character, Integer> entry : counterMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateCounter++;
            }
        }

        return duplicateCounter;
    }
}
