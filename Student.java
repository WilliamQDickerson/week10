/*
 * Student.java
 * CSC 222 - Object-Oriented Programming in Java
 *
 * This class represents a single student record.
 * It will be used with our file input/output and exception handling activities.
 *
 * Each Student object stores:
 *   - name
 *   - major
 *   - email
 *   - phone number
 *   - GPA
 *
 * The class includes:
 *   - Private instance variables
 *   - A full constructor
 *   - Getters and setters for each field
 *   - Methods to display student information in different formats
 */

public class Student {

    // =============================
    // Instance variables (fields)
    // =============================

    // The student's full name
    private String name;

    // The student's declared major
    private String major;

    // The student's email address
    private String email;

    // The student's phone number (ex: 540-555-1234)
    private String phone;

    // The student's GPA (range 0.0 - 4.0)
    private double gpa;


    // =============================
    // Constructor
    // =============================

    /*
     * Creates a new Student object with all details provided.
     */
    public Student(String name, String major, String email, String phone, double gpa) {
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
    }


    // =============================
    // Getters (Accessors)
    // =============================

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getGpa() {
        return gpa;
    }


    // =============================
    // Setters (Mutators)
    // =============================

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    // =============================
    // Display Methods
    // =============================

    /*
     * Displays all of the student's information in a formatted layout.
     * Good for reports or console output.
     */
    public void displayStudent() {
        System.out.println("------------------------------");
        System.out.println("Name:   " + name);
        System.out.println("Major:  " + major);
        System.out.println("Email:  " + email);
        System.out.println("Phone:  " + phone);
        System.out.println("GPA:    " + gpa);
    }

    /*
     * Displays a shorter, single-line summary of the student.
     * Good for lists or quick overviews.
     */
    public void displayCompact() {
        System.out.println(name + " | " + major + " | " + email + " | GPA: " + gpa);
    }


    // =============================
    // Other Methods
    // =============================

    /*
     * Returns a simple string with the student's info.
     * This is used automatically if you print the object.
     */
    @Override
    public String toString() {
        return name + " (" + major + ") - GPA: " + gpa;
    }
}
