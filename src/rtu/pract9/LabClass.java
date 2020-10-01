package rtu.pract9;

import java.util.Arrays;
import java.util.LinkedList;

public class LabClass {
    private final LinkedList<Student> students = new LinkedList<>();

    LabClass() {
        students.addAll(Arrays.asList(
                new Student("Damir", "5Q8QG", new byte[] {5, 5, 5}),
                new Student("Timur", "5Q8QH", new byte[] {5, 4, 5}),
                new Student("Emma", "6T53S", new byte[] {5, 4, 2}),
                new Student("Alex", "0T83Q", new byte[] {5, 4, 4}),
                new Student("Dmitriy", "0T65I", new byte[] {2, 2, 2})
        ));
        new LabClassUI(this);
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public static void main(String[] args) {
        new LabClass();
    }
}
