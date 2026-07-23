import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String fullName;
    private String program;
    private int yearLevel;

    public Student(String studentId, String fullName,
                   String program, int yearLevel) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    public String getStudentId() { return studentId; }

    public String describe() {
        return studentId + " | " + fullName + " | "
                + program + " | Year " + yearLevel;
    }
}
import java.util.ArrayList;
import java.util.Scanner;
public class EnrollmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        private class String studentId;
        private class String fullName;
        private class String program;
        private class int yearLevel;

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

