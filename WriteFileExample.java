import java.io.*;

public class WriteFileExample {
    public static void main(String[] args) {
        // PrintWriter by default overwrites the file if it exists; creates it if not
        try (PrintWriter writer = new PrintWriter("reports/report.txt")) {
            writer.println("Class Report");
            writer.println("----------------");
            writer.println("Number of students: 5");
            writer.println("Average GPA: 3.62");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            // Most write issues are IOExceptions (e.g., file is locked or drive is read-only)
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}