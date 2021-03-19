package qualified_test.rain_extremes;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            RainExtremes.getFirstDriestAndWettestYears("/home/peter/Peti/Codecool/Codewars/src/main/java/qualified_test/rain_extremes/Results.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
