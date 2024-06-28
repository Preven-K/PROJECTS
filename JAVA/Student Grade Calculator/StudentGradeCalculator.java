package mass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grade calculator = new Grade();

        System.out.println("_________________________________");
        System.out.println("****STUDENT GRADE CALCULATOR****");
        System.out.println("_________________________________");
        while (true) {
            System.out.println("\n ---MENU--- ");
            System.out.println("1. Add Marks");
            System.out.println("2. Display Grades and Average of a student");
            System.out.println("3. Display Simple report");
            System.out.println("4. Save data");
            System.out.println("5. Exit");
            System.out.println("-----------------------------\n Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculator.addMarks();
                    break;
                case 2:
                    calculator.displayStudentGrades();
                    break;
                case 3:
                    calculator.displayReport();
                    break;
                case 4:
                    calculator.savedata();
                    break;
                case 5:
                    calculator.savedata();
                    System.out.println("\t Thanks Visit Again Bye Bye:)");
                    scanner.close();
                    return;
                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }
}
// Creating Class grade for all calculation and operations 
class Grade {
    private List<Student> students;

    public Grade() 
    {
        this.students = new ArrayList<>();
    }
    // Saving Student Data to a file 
    public void savedata() {
        try {
            FileWriter fileWriter = new FileWriter("StudentData.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
    
            for (Student student : students) {
                printWriter.println("Student Name: " + student.getName());
                printWriter.println("Student Roll Number: " + student.getRollNo());
                printWriter.println("Courses and Grades:");
                for (Course course : student.getCourses()) {
                    printWriter.println("  " + course.getName() + ": " + course.getMark());
                }
                printWriter.println("Average Grade: " + student.calculateAverage());
                printWriter.println();
            }
    
            printWriter.close();
            fileWriter.close();
            System.out.println("Data saved successfully");
        } catch (IOException i) {
            System.err.println("Error saving data :( " + i.getMessage());
        }
    }
    
    // Adding marks to the student
    public void addMarks() {
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter Student Roll Number: ");
        int studentRollNo = scanner.nextInt();

        Student student = new Student(studentName, studentRollNo);

        while (true) {
            System.out.print("Enter the course Name (type 'f' to finish): ");
            String courseName = scanner.next();

            if (courseName.equalsIgnoreCase("f")) {
                break;
            }

            System.out.print("Enter the " + courseName + " mark: ");
            double courseMark = scanner.nextDouble();

            Course course = new Course(courseName, courseMark);
            student.addCourse(course);
        }

        students.add(student);
    }catch(Exception e) {System.out.println("Enter valid input. Error:" + e);}
    }
    // Displaying Individual Student Grades 
    public void displayStudentGrades() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student Roll Number to display grades: ");
        int rollNo = scanner.nextInt();

        for (Student student : students) { // Getting every student from students list in Student Class
            if (student.getRollNo() == rollNo) {   // checking if the roll number is same as in student list
                System.out.println("________________________________________________");
                System.out.println("Student Name: " + student.getName());
                System.out.println("Courses and Grades:");
                for (Course course : student.getCourses()) {
                    System.out.println("  " + course.getName() + ": " + course.getMark()+ " Grade: " +getGrade(course.getMark()));
                }
                System.out.println("Average Grade: " + student.calculateAverage());
                System.out.println("________________________________________________");
                return;
            }
        }
        System.out.println("Student not found");
    }
    // Displaying Report of entire Student Data
    public void displayReport() {
        System.out.println("-----------------------");
        System.out.println(" STUDENT GRADE REPORT ");
        System.out.println("-----------------------");

        for (Student student : students) {    // for every student in students list of class Student
            System.out.println("Student : " + student.getName());
            System.out.println("Courses : ");
            for (Course course : student.getCourses()) {  // for every course of a student in course list from class course
                String grade = getGrade(course.getMark());
                System.out.println(" " + course.getName() + " " + grade);
            }
            System.out.println("Overall Average: " + student.calculateAverage());
            String avgGrade = getGrade(student.calculateAverage());
            System.out.println("Overall Average Grade: " + avgGrade);
            System.out.println("__________________________");
        }
    }
    // Calculating grade
    private String getGrade(double mark) {
        if (mark >= 90) return "O";
        else if (mark >= 80 && mark < 90) return "A";
        else if (mark >= 70 && mark < 80) return "B";
        else if (mark >= 60 && mark < 70) return "C";
        else if (mark >= 50 && mark < 60) return "D";
        else return "U";
    }
}
// Creating class student which contains name,rollno,courses list
class Student {
    private String name;
    private int rollNo;
    private List<Course> courses;
    // Declaring name and rollno of student and creating new list for that student
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.courses = new ArrayList<>();
    }
    // adding Course to courses list
    public void addCourse(Course course) {
        courses.add(course);
    }
    // method for calculating average
    public double calculateAverage() {
        double sum = 0;
        for (Course course : courses) {  // for every course in the class Course in "courses" list
            sum += course.getMark();
        }
        return Double.parseDouble(String.format("%.2f", sum / courses.size()));
    }
    //initailising Getter 
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
// Initialising Course class with course name and mark
class Course {
    private String name;
    private double mark;

    public Course(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }
}

