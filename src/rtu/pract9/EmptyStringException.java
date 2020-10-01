package rtu.pract9;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Input string is empty!");
    }
}
