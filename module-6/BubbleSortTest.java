import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortTest {

    public static void main(String[] args) {

        // Test with Comparable: Integers
        Integer[] numbers = {4, 2, 9, 1, 5, 6};
        System.out.println("Before Comparable Sort: " + Arrays.toString(numbers));
        BubbleSort.bubbleSort(numbers);
        System.out.println("After Comparable Sort: " + Arrays.toString(numbers));

        // Test with Comparator: Strings sorted by length
        String[] fruits = {"apple", "fig", "banana", "kiwi", "grape"};
        System.out.println("\nBefore Comparator Sort (by length): " + Arrays.toString(fruits));
        Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        BubbleSort.bubbleSort(fruits, lengthComparator);
        System.out.println("After Comparator Sort (by length): " + Arrays.toString(fruits));
    }
}