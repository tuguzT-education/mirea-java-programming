package rtu.pract10.p1.Complex;

public interface ComplexAbstractFactory {
    Complex createComplex();

    Complex createComplex(int real, int imaginary);
}
