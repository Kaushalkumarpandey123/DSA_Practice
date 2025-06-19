package stream;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindSecondHighestNumber {
    //Find the second highest number in a list using Stream API.
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,2,4,7,5,6);

        int secondLargest = numbers.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .get(1);

        int secondLargest2 = numbers.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .get(1);

        Optional<Integer> secondLargest3 = numbers.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println(secondLargest);
    }
}
