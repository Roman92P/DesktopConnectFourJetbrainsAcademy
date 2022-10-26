import java.util.Scanner;

class Main {
    public static void main(String... args) {
        // code
//        System.out.println(Main.class.getClassLoader().getName());

        ClassLoader classLoader = Scanner.class.getClassLoader();
        System.out.println(classLoader);
    }
}