package rtu.pract9;

import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private String IDNumber;
    private byte[] finalMarks;

    public Student(final String name, final String IDNumber, final byte[] finalMarks) {
        this.finalMarks = finalMarks.clone();
        this.name = name;
        this.IDNumber = IDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public byte[] getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(byte[] finalMarks) {
        this.finalMarks = finalMarks;
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

    @Override
    public int compareTo(Student student) {
        return Double.compare(getAverageMark(this), getAverageMark(student));
    }
}
