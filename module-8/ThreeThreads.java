import java.util.Random;

public class ThreeThreads {

    // The number of characters each thread will output
    private static final int NUM_CHARACTERS = 10000;
    
    public static void main(String[] args) {
        // Create and start the threads
        Thread lettersThread = new Thread(new LettersThread());
        Thread digitsThread = new Thread(new DigitsThread());
        Thread specialCharsThread = new Thread(new SpecialCharsThread());

        lettersThread.start();
        digitsThread.start();
        specialCharsThread.start();

        try {
            // Ensure all threads finish before ending the program
            lettersThread.join();
            digitsThread.join();
            specialCharsThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("All threads have completed.");
    }

    /**
     * Thread responsible for outputting random letters (a-z).
     */
    static class LettersThread implements Runnable {
        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < NUM_CHARACTERS; i++) {
                char letter = (char) ('a' + rand.nextInt(26));  // Random letter between a and z
                System.out.print(letter);
            }
            System.out.println();  // Move to next line after finishing the output
        }
    }

    /**
     * Thread responsible for outputting random digits (0-9).
     */
    static class DigitsThread implements Runnable {
        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 0; i < NUM_CHARACTERS; i++) {
                int digit = rand.nextInt(10);  // Random digit between 0 and 9
                System.out.print(digit);
            }
            System.out.println();  // Move to next line after finishing the output
        }
    }

    /**
     * Thread responsible for outputting random special characters.
     */
    static class SpecialCharsThread implements Runnable {
        @Override
        public void run() {
            Random rand = new Random();
            char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};
            for (int i = 0; i < NUM_CHARACTERS; i++) {
                char specialChar = specialChars[rand.nextInt(specialChars.length)];
                System.out.print(specialChar);
            }
            System.out.println();  // Move to next line after finishing the output
        }
    }
}