import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        //file stuff
        String inputFilePath = "input.txt";  
        String outputFilePath = "output.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();

        //file reader and counter
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
        //ignore case
                line = line.trim().toLowerCase();

        // Update word count
                if (line.isEmpty()) continue;
                wordCountMap.put(line, wordCountMap.getOrDefault(line, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return;
        }

        //write output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Word count written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
