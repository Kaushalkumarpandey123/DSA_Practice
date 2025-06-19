package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListIntergerToListString {

    //Convert a List<Integer> into a List<String>
    // where each number is prefixed with "Num_".
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        List<String> StringNums = numbers.stream()
                        .map(num -> "Num_"+num)
                                .collect(Collectors.toList());

        System.out.println(StringNums.toString());

       // Convert a List<String> to uppercase and collect to a new list using streams.
        List<String> names = Arrays.asList("Piyush", "Kaushal", "Archit");
        List<String> upperName = names.stream()
               // .map(String::toUpperCase)
                .map(str -> str.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(upperName.toString());


        //From a list of integers, filter even numbers,
        // square them, and get the sum.

        int sum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num * num)
                .sum();

        System.out.println(sum);

    }


}
