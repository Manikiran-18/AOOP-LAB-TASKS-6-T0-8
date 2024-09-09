import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSortDescending {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "pear", "grape");

        // Lambda expression to sort strings in descending order
        Collections.sort(strings, (s1, s2) -> s2.compareTo(s1));

        System.out.println("Sorted in Descending Order: " + strings);
    }
}
