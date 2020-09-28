package rtu.pract9;

import javax.swing.*;

public class StudentNotFoundException extends Exception {
    private static final String MESSAGE = "Student with following surname not found:\n\t";

    public StudentNotFoundException (String surname) {
        super(MESSAGE + surname);
        dialogStudentNotFound(surname);
    }

    public void dialogStudentNotFound (String surname) {
        JOptionPane.showMessageDialog(null,
                MESSAGE + surname + "\n\nCheck input surname on typos" +
                        "\nor try to find another student.", "Input error", JOptionPane.ERROR_MESSAGE);
    }
}
