package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequency {

    // How do you count the frequency of elements in a list using Stream?
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,1,2,3,4,3);

        Map<Integer, Long> frqMap = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frqMap.toString());

      // Given a string like "banana", count frequency of each character using Stream API.
        String fruits = "banana";

        Map<Character, Long> frqMap2 = fruits.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        System.out.println(frqMap2.toString());


    }
}
