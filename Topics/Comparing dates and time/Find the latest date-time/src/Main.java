import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        LocalDateTime[] dates = new LocalDateTime[n];
        for(int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                LocalDateTime ldt = LocalDateTime.parse(inputLine);
                dates[i] = ldt;
            }
        }
        LocalDateTime result = Arrays.stream(dates).sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList()).get(0);
        System.out.println(result);

    }
}