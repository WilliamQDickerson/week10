import java.io.*;
import java.util.*;

public class UpdateEmailDomain {
    public static void main(String[] args) {
        File inFile  = new File("students.txt");
        File outFile = new File("reports/students_updated.txt");

        // Use try-with-resources for both input and output
        try (Scanner in = new Scanner(inFile);
             PrintWriter out = new PrintWriter(outFile)) {

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.trim().isEmpty()) continue; // skip empty rows

                // Expecting: Name, Major, Email, Phone, GPA
                String[] parts = line.split(",");
                if (parts.length < 5) {
                    // Keep malformed lines as-is so the user can fix them later
                    out.println(line);
                    continue;
                }

                // Normalize whitespace on all fields
                for (int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();

                // Update only the email field if the domain matches exactly
                String email = parts[2];
                if (email.endsWith("@email.com")) {
                    email = email.substring(0, email.length() - "@email.com".length()) + "@email.vccs.edu";
                    parts[2] = email;
                }

                // Re-serialize the row back to CSV (same field order)
                out.println(String.join(", ", parts));
            }

            System.out.println("Updated file written to students_updated.txt");
        } catch (FileNotFoundException e) {
            // Thrown if input file doesn't exist
            System.out.println("Input file not found: " + inFile.getAbsolutePath());
        } catch (IOException e) {
            // Thrown for issues creating/writing the output file
            System.out.println("Problem writing to output file: " + e.getMessage());
        }
    }
}