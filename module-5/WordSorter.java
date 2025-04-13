import java.io.*;
import java.util.*;

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

public static void sortAscending(List<String> words) {
    Collections.sort(words);
    System.out.println("Words in ascending order:");
    for (String word : words) {
        System.out.println(word);
    }
}

