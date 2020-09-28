package rtu.lab9;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException exception) {
            System.err.println("Невозможно получить число из строки!");
        } catch (ArithmeticException exception) {
            System.err.println("Деление на ноль!");
        }
    }
}
