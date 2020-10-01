package rtu.pract10.p1;

import rtu.pract10.p1.Complex.Complex;
import rtu.pract10.p1.Complex.ComplexAbstractFactory;
import rtu.pract10.p1.Complex.ConcreteFactory;

import java.util.Scanner;

public class Pract10 {
    public static Complex getComplexFromConsole() {
        try {
            final ComplexAbstractFactory factory = new ConcreteFactory();
            final Scanner scanner = new Scanner(System.in);
            return factory.createComplex(scanner.nextInt(), scanner.nextInt());
        } catch (Exception exception) {
            System.out.println("Error! Try again:");
            return getComplexFromConsole();
        }
    }

    public static void main(String[] args) {
        Complex[] complexes = new Complex[2];
        for (int i = 0; i < complexes.length; ++i) {
            System.out.println("Enter real and imaginary integer " +
                    "parts of the " + (i + 1) + " complex number:");
            complexes[i] = getComplexFromConsole();
        }
        System.out.println("The first complex number is " + complexes[0] +
                "\nThe second is " + complexes[1]);
        System.out.println("\nThe multiplication of first on second is " +
                complexes[0].getMultiplication(complexes[1]));
    }
}
