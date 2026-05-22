import java.util.Scanner;

// Student class
class Student {
    private String name;
    private int rollNumber;
    private String studentClass;

    // Constructor
    public Student(String name, int rollNumber, String studentClass) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.studentClass = studentClass;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }
}

// Subject class
class Subject {
    private String subjectName;
    private int marks;

    // Constructor
    public Subject(String subjectName, int marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }

    // Getters
    public String getSubjectName() {
        return subjectName;
    }

    public int getMarks() {
        return marks;
    }
}

// ReportCard class
class ReportCard {
    private Student student;
    private Subject[] subjects;

    // Constructor
    public ReportCard(Student student, Subject[] subjects) {
        this.student = student;
        this.subjects = subjects;
    }

    // Calculate total marks
    public int getTotalMarks() {
        int total = 0;
        for (Subject subject : subjects) {
            total += subject.getMarks();
        }
        return total;
    }

    // Calculate percentage
    public double getPercentage() {
        return (double) getTotalMarks() / subjects.length;
    }

    // Determine grade
    public String getGrade() {
        double percentage = getPercentage();
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    // Display formatted report card
    public void displayReportCard() {
        System.out.println("\n================= REPORT CARD =================");
        System.out.println("Name       : " + student.getName());
        System.out.println("Roll No.   : " + student.getRollNumber());
        System.out.println("Class      : " + student.getStudentClass());
        System.out.println("-----------------------------------------------");
        System.out.printf("%-20s %-10s\n", "Subject", "Marks");
        System.out.println("-----------------------------------------------");
        for (Subject subject : subjects) {
            System.out.printf("%-20s %-10d\n", subject.getSubjectName(), subject.getMarks());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.printf("Percentage : %.2f%%\n", getPercentage());
        System.out.println("Grade      : " + getGrade());
        System.out.println("===============================================");
    }
}

// Main class
public class StudentReportCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get student details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Class: ");
        String studentClass = sc.nextLine();

        // Create student object
        Student student = new Student(name, rollNumber, studentClass);

        // Get number of subjects
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine(); // consume newline

        // Create subjects array
        Subject[] subjects = new Subject[numSubjects];

        // Get subject details
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            String subjectName = sc.nextLine();
            System.out.print("Enter marks for " + subjectName + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline
            subjects[i] = new Subject(subjectName, marks);
        }

        // Create ReportCard object
        ReportCard reportCard = new ReportCard(student, subjects);

        // Display the report card
        reportCard.displayReportCard();

        sc.close();
    }
}
