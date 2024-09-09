import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEvenDouble {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Stream pipeline to filter even numbers, double them, and collect into a list
        List<Integer> doubledEvens = numbers.stream()
                .filter(n -> n % 2 == 0)  // Filter only even numbers
                .map(n -> n * 2)          // Double the numbers
                .collect(Collectors.toList());  // Collect the result into a list

        System.out.println("Doubled Even Numbers: " + doubledEvens);
    }
}
