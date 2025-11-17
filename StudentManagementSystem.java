import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom Exception
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Loader class for multithreading
class Loader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted!");
        }
    }
}

// Student class
class Student {
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        return "D";
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nCourse: " + course +
                "\nMarks: " + marks +
                "\nGrade: " + getGrade();
    }
}

// Main manager class
public class StudentManagementSystem {

    private Map<Integer, Student> studentDB = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    // Add student with validation + exceptions + threading
    public void addStudent() {
        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.valueOf(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) throw new Exception("Name cannot be empty!");

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            if (!email.contains("@")) throw new Exception("Invalid email format!");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            if (course.isEmpty()) throw new Exception("Course cannot be empty!");

            System.out.print("Enter Marks: ");
            Double marks = Double.valueOf(sc.nextLine());
            if (marks < 0 || marks > 100)
                throw new Exception("Marks must be between 0 and 100!");

            // Multithreading for loading effect
            Thread loader = new Thread(new Loader());
            loader.start();
            loader.join();

            // Add student to database
            studentDB.put(roll, new Student(roll, name, email, course, marks));

            System.out.println("Student added successfully!\n");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
    }

    // Display student
    public void displayStudent(int roll) throws StudentNotFoundException {
        if (!studentDB.containsKey(roll)) {
            throw new StudentNotFoundException("Student with Roll No " + roll + " not found!");
        }
        System.out.println(studentDB.get(roll));
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        sms.addStudent();

        System.out.print("\nEnter Roll No to display: ");
        int r = Integer.parseInt(sc.nextLine());

        try {
            sms.displayStudent(r);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
