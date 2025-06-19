package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapPractice {
    //Flatten a list of lists using flatMap.
    // Example: List<List<Integer>> to List<Integer>.

    public static void main(String[] args) {

        List<List<Integer>> numbers = Arrays.asList(
             Arrays.asList(1,2,3),
             Arrays.asList(4,5,6),
             Arrays.asList(7,8,9)
        );

        List<Integer> flattenList = numbers.stream()
                .flatMap(number -> number.stream())
                .collect(Collectors.toList());

        System.out.println(flattenList.toString());
    }

}
