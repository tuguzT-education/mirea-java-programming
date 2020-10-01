package rtu.pract9;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String name) {
        super("Student with name '" + name + "' not found!");
    }
}
