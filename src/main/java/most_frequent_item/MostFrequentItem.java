package most_frequent_item;

import java.util.HashMap;
import java.util.Map;

    public class MostFrequentItem {

    public static int mostFrequentItemCount(int[] collection) {
        Map<Integer, Integer> counterMap = new HashMap<>();

        for (int i : collection) {
            if (counterMap.containsKey(i)) {
                counterMap.put(i, counterMap.get(i) + 1);
            } else {
                counterMap.put(i, 1);
            }
        }

        int maxOccurrence = 0;
        for (Integer occurrence : counterMap.values()) {
            if (occurrence > maxOccurrence) {
                maxOccurrence = occurrence;
            }
        }
        return maxOccurrence;
    }
}
