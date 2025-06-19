package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    // How do you remove duplicate elements from a list using streams?
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Piyush", "Kaushal", "Archit", "Piyush","Kaushal");

        List<String> distinctNames = names.stream()
                        .distinct()
                                .collect(Collectors.toList());

        System.out.println(distinctNames.toString());
    }

}
