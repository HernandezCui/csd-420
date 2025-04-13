import java.io.*;
import java.util.*;

public class WordSorter {

    // Method to read words from the file and return them as a list of unique words
    public static List<String> readWordsFromFile(String filename) {
        Set<String> wordsSet = new HashSet<>(); // Set ensures unique words
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line by spaces
                for (String word : words) {
                    if (!word.trim().isEmpty()) {
                        wordsSet.add(word.trim().toLowerCase()); // Add to set (convert to lowercase)
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return new ArrayList<>(wordsSet); // Convert the set to a list and return
    }

    // Method to sort the words in ascending order
    public static void sortAscending(List<String> words) {
        Collections.sort(words);
        System.out.println("Words in ascending order:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Method to sort the words in descending order
    public static void sortDescending(List<String> words) {
        Collections.sort(words, Collections.reverseOrder());
        System.out.println("\nWords in descending order:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Main method
    public static void main(String[] args) {
        // Name of the file to read from
        String filename = "collection_of_words.txt";

        // Read the words from the file
        List<String> words = readWordsFromFile(filename);

        // If there are words to display
        if (words.isEmpty()) {
            System.out.println("No words found in the file.");
        } else {
            // Sort and display words in ascending order
            sortAscending(words);

            // Sort and display words in descending order
            sortDescending(words);
        }
    }
}