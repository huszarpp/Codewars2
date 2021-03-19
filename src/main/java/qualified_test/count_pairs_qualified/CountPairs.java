package qualified_test.count_pairs_qualified;

import java.util.HashSet;
import java.util.Set;

public class CountPairs {

    public static int countPairs(int[] arr, int[] arr2) {
        Set<Integer> matches = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] + arr2[j] == 10) {
                    matches.add(Math.min(arr[i], arr2[j]));
                }
            }
        }
        return matches.size();
    }
}
