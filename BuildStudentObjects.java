import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BuildStudentObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(); // Dynamic list to hold all Student objects

        try (Scanner fileScan = new Scanner(new File("students.txt"))) {
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.trim().isEmpty()) continue;  // Ignore blank lines

                // Split by comma into fields: Name, Major, Email, Phone, GPA
                String[] parts = line.split(",");
                if (parts.length < 5) {
                    System.out.println("Skipping bad record (not enough fields): " + line);
                    continue; // Not enough parts; move on without crashing
                }

                try {
                    String name  = parts[0].trim();
                    String major = parts[1].trim();
                    String email = parts[2].trim();
                    String phone = parts[3].trim();
                    double gpa   = Double.parseDouble(parts[4].trim()); // Can throw NumberFormatException

                    // Create the object using your existing Student constructor
                    Student s = new Student(name, major, email, phone, gpa);
                    students.add(s);
                } catch (NumberFormatException ex) {
                    // Example: "not_a_number" for GPA
                    System.out.println("Invalid GPA. Skipping: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file. Check the filename and location.");
        }

        // Sanity check: show how many valid students we loaded
        System.out.println("Students loaded: " + students.size());
    }
}