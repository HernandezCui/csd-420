import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Module3Assignment {

    // Method to remove duplicates from an ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Using HashSet to remove duplicates
        HashSet<E> set = new HashSet<>(list); // HashSet automatically removes duplicates
        return new ArrayList<>(set); // Convert the HashSet back to an ArrayList
    }

    public static void main(String[] args) {
        // Generate an ArrayList of 50 random integers from 1 to 20
        ArrayList<Integer> originalList = generateRandomList(50, 1, 20);

        // Display the original list
        System.out.println("Original List: " + originalList);

        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display the list after removing duplicates
        System.out.println("List after removing duplicates: " + uniqueList);
    }

    // Method to generate an ArrayList with random integers within a given range
    public static ArrayList<Integer> generateRandomList(int size, int min, int max) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            // Random integer between min and max (inclusive)
            int randomValue = rand.nextInt(max - min + 1) + min;
            list.add(randomValue);
        }

        return list;
    }
}
