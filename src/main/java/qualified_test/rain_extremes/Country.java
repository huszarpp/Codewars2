package qualified_test.rain_extremes;

class Country {

    private String name;
    private int maxRain = 0;
    private int maxYear = 0;
    private int minRain = Integer.MAX_VALUE;
    private int minYear = 0;

    public Country(String name) {
        this.name = name;
    }

    public void compareToMinAndMaxAndSetYear(String currentRainString, String yearString) {

        int currentRain = 0;
        int year = 0;
        try {
            currentRain = Integer.parseInt(currentRainString);
            year = Integer.parseInt(yearString);
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong data format in file!");
        }

        if (isCurrentGreaterThanMax(currentRain)) {
            maxRain = currentRain;
            maxYear = year;
        }
        if (isCurrentLessThanMin(currentRain)) {
            minRain = currentRain;
            minYear = year;
        }
    }

    private boolean isCurrentGreaterThanMax(int currentRain) {
        return currentRain > maxRain;
    }

    private boolean isCurrentLessThanMin(int currentRain) {
        return currentRain < minRain;
    }

    public String getName() {
        return name;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public int getMinYear() {
        return minYear;
    }
}
