package calculate_string_rotation;

public class CalculateRotation {

    static int shiftedDiff(String first, String second){

        if (first.equals(second)) {
            return 0;
        }
        int roataionCounter = 0;
        for (int i = 0; i < first.length(); i++) {
            second = second.substring(1) + second.charAt(0);
            roataionCounter++;
            if (first.equals(second)) {
                return Math.min(roataionCounter, first.length() - roataionCounter);
            }
        }
        return -1;
    }
}
