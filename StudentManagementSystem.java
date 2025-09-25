import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;

    public Person() {

        this.name = "";
    }

    public Person(String name) {

        this.name = name;
    }
}

class Student extends Person {
    int rollNo;
    String course;
    double marks;
    char grade;

    public Student() {
        super();
        this.rollNo = 0;
        this.course = "";
        this.marks = 0.0;
        this.grade = 'F';
    }

    public Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }


    public void inputDetails(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();


        while (true) {
            System.out.print("Enter Marks (0-100): ");
            marks = sc.nextDouble();
            if (marks >= 0 && marks <= 100) break;
            else System.out.println("Invalid input! Marks must be between 0 and 100.");
        }

        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90) {
            System.out.println('A');
        }else if (marks >= 80){
            System.out.println('B');
        }else if (marks >= 70){
            System.out.println('C');
        }else if (marks >= 50){
            System.out.println('D');
        }else {
            System.out.println('F');
        }
    }


    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------");
    }
}


public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;
        do {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.inputDetails(sc);
                    students.add(s);
                    System.out.println("Student added successfully!\n");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.\n");
                    } else {
                        System.out.println("===== Student Records =====");
                        for (Student st : students) {
                            st.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}