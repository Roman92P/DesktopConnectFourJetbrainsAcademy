import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            String dateAndDay = scanner.nextLine();
            String [] tempArr =  dateAndDay.split(" ");
            LocalDate ld = LocalDate.parse(tempArr[0]);
            LocalDate ld1 = ld.plusDays(Long.parseLong(tempArr[1])).withMonth(1).withDayOfMonth(1);
            System.out.println(ld1.equals(ld.plusDays(Long.parseLong(tempArr[1]))));
        }
    }
}