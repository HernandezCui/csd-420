import java.io.*;
import java.util.Random;

public class RandomDataWriter {
    public static void main(String[] args) {
        String fileName = "Cuitlahuac_datafile.dat"; 

        // Create an instance of Random to generate random numbers
        Random rand = new Random();

        // Create arrays to store random integers and doubles
        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        // Populate the arrays with random data
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = rand.nextInt(100);  // Random integer between 0 and 99
            randomDoubles[i] = rand.nextDouble() * 100;  // Random double between 0.0 and 100.0
        }

        // File writing logic
        try (FileWriter fileWriter = new FileWriter(fileName, true); // 'true' to append data
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            // Write random integers
            bufferedWriter.write("Random Integers: ");
            for (int i : randomIntegers) {
                bufferedWriter.write(i + " ");
            }
            bufferedWriter.newLine();

            // Write random doubles
            bufferedWriter.write("Random Doubles: ");
            for (double d : randomDoubles) {
                bufferedWriter.write(d + " ");
            }
            bufferedWriter.newLine();

            System.out.println("Data has been written to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}