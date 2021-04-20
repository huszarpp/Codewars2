package fizz_buzz_cuckoo_clock;

public class FizzBuzzCuckooClock {
    public static String fizzBuzzCuckooClock(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));

        if (minute == 0) {
            StringBuilder sb = new StringBuilder();
            String separator = "";
            int limit = hour % 12 == 0 ? 12 : hour % 12;
            for (int i = 0; i < limit; i++) {
                sb.append(separator);
                sb.append("Cuckoo");
                separator = " ";
            }
            return sb.toString();
        } else if (minute == 30) {
            return "Cuckoo";
        } else if (minute % 3 == 0 && minute % 5 == 0) {
            return "Fizz Buzz";
        } else if (minute % 3 == 0) {
            return "Fizz";
        } else if (minute % 5 == 0) {
            return "Buzz";
        } else {
            return "tick";
        }
    }
}
