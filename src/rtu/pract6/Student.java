package rtu.pract6;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    private final String name;
    private final String IDNumber;
    private final byte[] finalMarks;

    public Student(final String name, final String IDNumber, final byte[] finalMarks) {
        this.finalMarks = finalMarks.clone();
        this.name = name;
        this.IDNumber = IDNumber;
    }

    public String getName() {
        return name;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public byte[] getFinalMarks() {
        return finalMarks;
    }

    @Override
    public String toString() {
        return "Student{name = '" + name + "', IDNumber = '" + IDNumber
                + "', finalMarks = " + Arrays.toString(finalMarks) + "}";
    }

    private static double getAverageMark(final Student student) {
        double mark = 0;
        for (final var item : student.finalMarks) {
            mark += item;
        }
        return mark / student.finalMarks.length;
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student lhs, Student rhs) {
            return Double.compare(getAverageMark(lhs), getAverageMark(rhs));
        }
    }
}
