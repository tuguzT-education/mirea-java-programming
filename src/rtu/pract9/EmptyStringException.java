package rtu.pract9;

import javax.swing.*;

public class EmptyStringException extends Exception {
    private static final String MESSAGE = "Input must not be\nan empty string!";

    public EmptyStringException() {
        super(MESSAGE);
        dialogEmptyString();
    }

    public void dialogEmptyString() {
        JOptionPane.showMessageDialog(null, MESSAGE,
                "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}
