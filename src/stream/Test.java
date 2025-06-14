package stream;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4).filter(n -> n > 2);
        System.out.println("Not executed yet!"); // Lazy execution
        stream.forEach(System.out::println); // Now executes
    }
}
