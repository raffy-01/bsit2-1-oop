import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    // Part A
    static int[] cutoffs = {90, 80, 70, 60, 0};
    static String[] letters = {"A", "B", "C", "D", "F"};

    public static String letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i]) {
                return letters[i];
            }
        }
        return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> roster = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\nGrade Tracker");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Class average");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();

                    System.out.print("Grade: ");
                    double grade = sc.nextDouble();

                    roster.add(new Student(name, grade));
                    System.out.println("Student added.");
                    break;

                case 2:
                    if (roster.isEmpty()) {
                        System.out.println("No students.");
                    } else {
                        for (Student s : roster) {
                            System.out.printf("%s - %.1f (%s)%n",
                                    s.name,
                                    s.grade,
                                    letterFor(s.grade));
                        }
                    }
                    break;

                case 3:
                    if (roster.isEmpty()) {
                        System.out.println("No students to average.");
                    } else {
                        double total = 0;
                        for (Student s : roster) {
                            total += s.grade;
                        }
                        double average = total / roster.size();
                        System.out.printf("Class average: %.2f%n", average);
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}