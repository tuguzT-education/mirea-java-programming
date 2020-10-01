package rtu.pract10.p1.Complex;

public class Complex {
    private int real;
    private int imaginary;

    public Complex() { }

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public Complex getAddition(Complex complex) {
        return new Complex(real + complex.real,
                imaginary + complex.imaginary);
    }

    public Complex getSubtraction(Complex complex) {
        return new Complex(real - complex.real,
                imaginary - complex.imaginary);
    }

    public Complex getMultiplication(Complex complex) {
        return new Complex(real * complex.real - imaginary * complex.imaginary,
                real * complex.imaginary + complex.real * imaginary);
    }

    public Complex getDivision(Complex complex) {
        final int square = complex.real * complex.real + complex.imaginary * complex.imaginary;
        return new Complex((real * complex.real + imaginary * complex.imaginary) / square,
                (complex.real * imaginary - real * complex.imaginary) / square);
    }

    @Override
    public String toString() {
        return "Complex{real = " + real + ", imaginary = " + imaginary + "}";
    }
}
