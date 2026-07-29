import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] studentID = new int[10];
        String[] fullName = new String[10];
        int[] age = new int[10];
        String[] course = new String[10];
        double[] grade = new double[10];
        boolean[] enrolled = new boolean[10];

        int studentCount = 0;
        int choice;
        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println("   STUDENT INFORMATION SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // Clears the newline

            switch (choice) {

                case 1:

                    // Check if the arrays are already full
                    if (studentCount >= 10) {
                        System.out.println("\nStudent list is already full.");
                        break;
                    }

                    System.out.println("\n--- ADD STUDENT ---");

                    System.out.print("Enter Student ID: ");
                    studentID[studentCount] = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Full Name: ");
                    fullName[studentCount] = input.nextLine();

                    do {
                        System.out.print("Enter Age: ");
                        age[studentCount] = input.nextInt();

                        if (age[studentCount] <= 0) {
                            System.out.println("Invalid age. Age must be positive.");
                        }

                    } while (age[studentCount] <= 0);

                    input.nextLine();

                    System.out.print("Enter Course: ");
                    course[studentCount] = input.nextLine();

                    do {
                        System.out.print("Enter Grade/Score: ");
                        grade[studentCount] = input.nextDouble();

                        if (grade[studentCount] < 0 ||
                                grade[studentCount] > 100) {

                            System.out.println(
                                    "Invalid grade. Enter a grade from 0 to 100."
                            );
                        }

                    } while (grade[studentCount] < 0 ||
                            grade[studentCount] > 100);

                    System.out.print("Is the student enrolled? ");
                    enrolled[studentCount] = input.nextBoolean();
                    input.nextLine();

                    studentCount++;

                    System.out.println("\nStudent added successfully!");
                    break;


                case 2:

                    System.out.println("\n--- ALL STUDENT RECORDS ---");

                    if (studentCount == 0) {
                        System.out.println("No student records found.");
                    } else {

                        System.out.printf(
                                "%-10s %-25s %-6s %-15s %-10s %-12s %-18s%n",
                                "ID",
                                "NAME",
                                "AGE",
                                "COURSE",
                                "GRADE",
                                "STATUS",
                                "STANDING"
                        );

                        System.out.println(
                                "------------------------------------------------------------------------------------------------"
                        );

                        for (int i = 0; i < studentCount; i++) {

                            String standing;

                            if (grade[i] >= 90) {
                                standing = "Dean's Lister";
                            } else if (grade[i] >= 75) {
                                standing = "Passed";
                            } else {
                                standing = "Failed";
                            }

                            String enrollmentStatus;

                            if (enrolled[i]) {
                                enrollmentStatus = "Enrolled";
                            } else {
                                enrollmentStatus = "Not Enrolled";
                            }

                            System.out.printf(
                                    "%-10d %-25s %-6d %-15s %-10.2f %-12s %-18s%n",
                                    studentID[i],
                                    fullName[i],
                                    age[i],
                                    course[i],
                                    grade[i],
                                    enrollmentStatus,
                                    standing
                            );
                        }
                    }

                    break;


                case 3:

                    if (studentCount == 0) {
                        System.out.println("\nNo student records found.");
                        break;
                    }

                    System.out.println("\n--- SEARCH STUDENT ---");

                    System.out.print("Enter Student ID: ");
                    int searchID = input.nextInt();
                    input.nextLine();

                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {

                        if (studentID[i] == searchID) {

                            String standing;

                            if (grade[i] >= 90) {
                                standing = "Dean's Lister";
                            } else if (grade[i] >= 75) {
                                standing = "Passed";
                            } else {
                                standing = "Failed";
                            }

                            String enrollmentStatus;

                            if (enrolled[i]) {
                                enrollmentStatus = "Enrolled";
                            } else {
                                enrollmentStatus = "Not Enrolled";
                            }

                            System.out.println("\nStudent Found!");
                            System.out.println("Student ID: " + studentID[i]);
                            System.out.println("Full Name: " + fullName[i]);
                            System.out.println("Age: " + age[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Grade: " + grade[i]);
                            System.out.println(
                                    "Enrollment Status: " + enrollmentStatus
                            );
                            System.out.println(
                                    "Academic Standing: " + standing
                            );

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(
                                "\nStudent with ID " +
                                        searchID +
                                        " was not found."
                        );
                    }

                    break;


                case 4:

                    System.out.println("\n--- STUDENT STATISTICS ---");

                    if (studentCount == 0) {
                        System.out.println(
                                "No student records available."
                        );
                    } else {

                        double totalGrades = 0;

                        int topStudentIndex = 0;

                        for (int i = 0; i < studentCount; i++) {

                            totalGrades += grade[i];

                            if (grade[i] >
                                    grade[topStudentIndex]) {

                                topStudentIndex = i;
                            }
                        }

                        double averageGrade =
                                totalGrades / studentCount;

                        System.out.println(
                                "Total Number of Students: " +
                                        studentCount
                        );

                        System.out.printf(
                                "Average Grade: %.2f%n",
                                averageGrade
                        );

                        System.out.println(
                                "Top Student: " +
                                        fullName[topStudentIndex]
                        );

                        System.out.printf(
                                "Top Student Grade: %.2f%n",
                                grade[topStudentIndex]
                        );
                    }

                    break;


                case 5:

                    System.out.println(
                            "\nThank you for using the " +
                                    "Student Information System!"
                    );

                    System.out.println("Goodbye!");

                    running = false;

                    break;


                default:

                    System.out.println(
                            "\nInvalid choice. " +
                                    "Please enter a number from 1 to 5."
                    );

                    break;
            }
        }

        input.close();
    }
}