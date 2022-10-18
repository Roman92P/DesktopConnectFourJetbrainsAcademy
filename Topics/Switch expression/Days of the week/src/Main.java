import java.util.Scanner;

enum DaysOfTheWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaysOfTheWeek day = DaysOfTheWeek.valueOf(scanner.next());
        int numLetters;

        // Put switch expression here
//        numLetters = switch (day) {
//            case MONDAY -> 6;
//            case TUESDAY -> 7;
//            case WEDNESDAY -> 9;
//            case THURSDAY -> 8;
//            case FRIDAY -> 6;
//            case SATURDAY -> 8;
//            case SUNDAY -> 6;
//            default -> throw new IllegalStateException("Invalid day: " + day);
//        };
//        System.out.println(numLetters);
    }
}