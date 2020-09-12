package rtu.pract6;

import java.util.Arrays;

public class Pract6 {
    public static void main(String[] args) {
        final Student[] students = new Student[] {
                new Student("Emma", "6T53S",new byte[]{5, 4, 2}),
                new Student("Alex", "0T83Q",new byte[]{5, 4, 5}),
                new Student("Dmitriy", "0T65I",new byte[]{2, 2, 2}),
                new Student("Timur", "3V61U",new byte[]{1, 5, 2}),
                new Student("Damir", "4T73P",new byte[]{5, 5, 5}),
        };
        System.out.println(Arrays.toString(students));

        SortingStudentsByGPA.sort(students, new Student.StudentComparator());
        System.out.println(Arrays.toString(students));
    }
}
