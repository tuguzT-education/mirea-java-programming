package rtu.pract6;

import java.util.Arrays;

public class Pract6 {
    public static void main(String[] args) {
        final Student[] students = new Student[] {
                new Student("Emma", new byte[]{5, 4, 2}),
                new Student("Alex", new byte[]{5, 4, 5}),
                new Student("Dmitriy", new byte[]{2, 2, 2}),
                new Student("Timur", new byte[]{1, 5, 2}),
                new Student("Damir", new byte[]{5, 5, 5}),
        };
        System.out.println(Arrays.toString(students));

        SortingStudentsByGPA.sort(students, new Student.StudentComparator());
        System.out.println(Arrays.toString(students));
    }
}
