package task1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class NameStream {
    public static void main(String[] args) {
        char startingLetter = 'A';
        Stream<String> filteredNames = filterNamesByStartingLetter(startingLetter);
        printNamesWithNumbering(filteredNames);
    }

    private static Stream<String> filterNamesByStartingLetter(char startingLetter) {
        return Stream.of("Anna", "Alex", "Andrew", "Alice", "Ben", "Bob", "Catherine", "Carl")
                .filter(name -> name.charAt(0) == startingLetter);
    }

    private static void printNamesWithNumbering(Stream<String> names) {
        AtomicInteger counter = new AtomicInteger(1);
        names.forEachOrdered(name -> System.out.println(counter.getAndIncrement() + ") " + name));
    }
}
