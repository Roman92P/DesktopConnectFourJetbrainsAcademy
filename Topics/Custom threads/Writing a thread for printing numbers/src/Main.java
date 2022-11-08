import java.util.stream.IntStream;

class NumbersThread extends Thread {

    private int from;
    private int to;

    public NumbersThread(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(from, to)
                .forEach(System.out::println);
    }
}