import java.io.*;

public class RandomDataReader {
    public static void main(String[] args) {
        String fileName = "Cuitlahuac_datafile.dat"; 

        // Read data from the file
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            // Read and display each line in the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}