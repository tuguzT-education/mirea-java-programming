package rtu.lab1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        System.out.println("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        System.out.println("\nВведите массив: ");
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = scanner.nextInt();
        }

        Test test = new Test();
        System.out.println(test.getSumForLoop(ints));
        System.out.println(test.getSumWhileLoop(ints));
        System.out.println(test.getSumDoWhileLoop(ints));

        for (String string : args) {
            System.out.println(string);
        }

        double[] array = test.getHarmonic(10);
        System.out.print('[');
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(']');
    }
}
