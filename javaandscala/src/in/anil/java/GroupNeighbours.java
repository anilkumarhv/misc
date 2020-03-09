package in.anil.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupNeighbours {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int chunkSize = 8;
        final AtomicInteger counter = new AtomicInteger();

        final Collection<List<Integer>> result = numbers.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                .values();

        System.out.println(result);

        List<String> stringList = Arrays.asList("anil", "kumar", "abc", "test", "nokia");
        List<String> sss = Stream.of(stringList).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(sss);

        List<Character> chars = "anil".chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        System.out.println(chars);

        System.out.println(fibonacci(4));

        int sum = 1;

        Integer factorial = IntStream.rangeClosed(1, 5).reduce(sum, (x, y) -> x * y);

        System.out.println(factorial);

        IntStream.generate(new FibonacciSupplier()).limit(5).forEach(System.out::print);

    }

    public static int fibonacci(int i) {
        if (i < 0)
            return 0;
        switch (i) {
            case 0:
            case 1:
                return 1;
            default:
                return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    private static class FibonacciSupplier implements IntSupplier {

        int current = 1;
        int previous = 0;

        @Override
        public int getAsInt() {
            int result = current;
            current = previous + current;
            previous = result;
            return result;
        }
    }

}
