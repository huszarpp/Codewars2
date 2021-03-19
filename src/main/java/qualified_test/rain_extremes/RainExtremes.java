package qualified_test.rain_extremes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainExtremes {
    private static int yearColumnIndex;
    private static List<String> countryNames;
    private static List<String> valueLines = new ArrayList<>();
    private static List<Country> countries = new ArrayList<>();

    public static List<String> getFirstDriestAndWettestYears(String file) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String nextLine = bufferedReader.readLine();

            String[] headerLineArray = nextLine.split(" ");
            countryNames = Arrays.asList(Arrays.copyOfRange(headerLineArray, 0, headerLineArray.length - 1));
            yearColumnIndex = headerLineArray.length - 1;

            for (String countryName : countryNames) {
                countries.add(new Country(countryName));
            }

            nextLine = bufferedReader.readLine();

            while (nextLine != null) {
                String[] lineArray = nextLine.split(" ");
                for (int i = 0; i < lineArray.length - 1; i++) {
                    countries.get(i).compareToMinAndMaxAndSetYear(lineArray[i], lineArray[yearColumnIndex]);
                }
                nextLine = bufferedReader.readLine();

            }
        } catch (IOException ioe) {
            throw new IOException("Problem has occured while reading the file!");
//            System.out.println("Problem has occured while reading the file!");
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }

        for (Country country : countries) {
            valueLines.add(country.getName() + " => " + country.getMinYear() + ", " + country.getMaxYear());
        }

        valueLines.forEach(System.out::println);

        return valueLines;
    }
}
