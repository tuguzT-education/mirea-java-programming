package rtu.pract13;

import rtu.pract13.Counting.*;

import java.util.Scanner;

public class Pract13 {
    public static void evaluate() {
        try {
            Scanner scanner = new Scanner(System.in);
            double x = scanner.nextDouble();
            Operation function = new Add(
                    new Subtract(
                            new Multiply(
                                    new Variable("x"),
                                    new Variable("x")
                            ),
                            new Multiply(
                                    new Const(2),
                                    new Variable("x")
                            )
                    ),
                    new Const(1)
            );
            System.out.println(function.evaluate(x));
        } catch (Exception exception) {
            System.out.print("\nНеверный ввод!\nВведите число: ");
            evaluate();
        }
    }

    public static void main(String[] args) {
        System.out.print("Данная программа по входному числу высчитывает" +
                "\nзначение функции [x^2 - 2*x + 1], где x - само входное значение.\n\n" +
                "Введите значение x: ");
        evaluate();
    }
}
