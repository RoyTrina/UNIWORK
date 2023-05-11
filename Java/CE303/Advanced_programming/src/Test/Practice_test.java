package Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice_test {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(Arrays.toString(
                        stream.filter(i -> i > 3)
                                .map(i -> i * i)
                                .toArray()
                )
        );


        System.out.println(
                Stream.of("one", null, "two", null, "three")
                        .map(Optional::ofNullable)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.joining(", "))
        );


        Stream<String> surnames = Stream.of("Smith", "Baker", "Doe", "Jones", "Shostakovich",
                "Rachmaninoff", "Tchaikovsky", "Papastylianou");
        Map<Integer, List<String>> groups = surnames.collect(
                Collectors.groupingBy(String::length)
        );
        for (var s : groups.keySet()) {
            System.out.println(s + ": " + groups.get(s));
        }
    }
}
