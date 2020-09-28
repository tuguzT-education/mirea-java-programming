package rtu.pract9;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class LabClassUI extends JFrame {
    private final TableModel tableModel;

    LabClassUI() {
        super("Lab class");
        setSize(500, 500);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tableModel = new TableModel();
        JTable table = new JTable(tableModel);
        add(table);

        // todo интерфейс

        setVisible(true);
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    private static class TableModel extends AbstractTableModel {
        private static final String[] columnNames = new String[] {
                "Name", "ID number", "Final marks"
        };
        private static final LinkedList<Student> data = new LinkedList<>();
        static {
            final Student[] students = new Student[] {
                    new Student("Тугушев Дамир Рустамович", "735jde", new byte[] {5, 4, 5}),
                    new Student("Тугушев Тимур Рустамович", "735jee", new byte[] {5, 5, 5}),
            };
            data.addAll(Arrays.asList(students));
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
            return getValueAt(0, columnIndex).getClass();
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
                    return "null";
            }
        }

        public void addRow(Student student) {
            data.add(student);
            fireTableRowsInserted(data.size(), data.size());
        }

        public void sortByGPA() {
            LabClassDriver.sort(data);
            fireTableRowsInserted(0, data.size());
        }
    }
}
