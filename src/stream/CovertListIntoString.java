package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CovertListIntoString {

   // Convert a List<String> into a single String with comma
   // separation using Stream API.
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Piyush", "Kaushal", "Archit");

        String result = names.stream()
                            .collect(Collectors.joining(","))
                            .toString();

        System.out.println(result);

    }

}
