package rtu.pract9;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LabClassUI extends JFrame {
    private final LabTableModel labTableModel;

    LabClassUI() {
        super("Lab class");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labTableModel = new LabTableModel(Arrays.asList(
                new Student("Damir", "5Q8QG", new byte[] {5, 5, 5}),
                new Student("Timur", "5Q8QH", new byte[] {5, 4, 5}),
                new Student("Emma", "6T53S", new byte[] {5, 4, 2}),
                new Student("Alex", "0T83Q", new byte[] {5, 4, 4}),
                new Student("Dmitriy", "0T65I", new byte[] {2, 2, 2})
        ));

        JTable table = new JTable(labTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        add(panel, BorderLayout.SOUTH);

        JButton sortButton = new JButton("Sort table");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labTableModel.sortByGPA();
            }
        });
        panel.add(sortButton);

        JButton shuffleButton = new JButton("Shuffle table");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labTableModel.shuffle();
            }
        });
        panel.add(shuffleButton);

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField);

        JButton findButton = new JButton("Find student by name");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                Student student = LabClassDriver.findByName(name,
                        LabTableModel.data.toArray(new Student[0]));
                if (student == null) {
                    System.out.println("ERROR!");
                }
            }
        });
        panel.add(findButton);

        setVisible(true);
    }

    public void addStudentToTable(Student student) {
        labTableModel.addRow(student);
    }

    public void removeStudentFromTable(int studentIndex) {
        labTableModel.removeRow(studentIndex);
    }

    private static class LabTableModel extends AbstractTableModel {
        private static final String[] columnNames = {
                "Name", "ID number", "Final marks"
        };
        private static final LinkedList<Student> data = new LinkedList<>();

        LabTableModel(List<Student> students) {
            data.addAll(students);
            Collections.shuffle(data);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            final Student student = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return student.getName();
                case 1:
                    return student.getIDNumber();
                case 2:
                    return Arrays.toString(student.getFinalMarks());
                default:
                    return "";
            }
        }

        public void removeRow(int rowIndex) {
            data.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        public void addRow(Student student) {
            data.add(student);
            fireTableRowsInserted(data.size() - 1, data.size() - 1);
        }

        public void sortByGPA() {
            LabClassDriver.sort(data);
            fireTableRowsUpdated(0, data.size() - 1);
        }

        public void shuffle() {
            Collections.shuffle(data);
            fireTableRowsUpdated(0, data.size() - 1);
        }
    }
}
