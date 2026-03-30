import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        // Try-with-resources ensures the Scanner (and underlying file) is closed automatically
        try (Scanner fileScan = new Scanner(new File("students.txt"))) {
            // Read until there are no more lines
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();  // Read one whole line of text
                if (line.trim().isEmpty()) continue; // Skip blank lines defensively
                System.out.println(line);           // Echo the line to the console for now
            }
        } catch (FileNotFoundException e) {
            // This happens if the file is missing or the path is wrong
            System.out.println("File not found. Make sure students.txt is in your project folder.");
        }
    }
}