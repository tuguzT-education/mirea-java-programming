package rtu.pract13.Counting;

public class Subtract extends Operation {
    public Subtract(Input first, Input second) {
        super(first, second);
    }

    @Override
    protected double evaluate(double lhs, double rhs) {
        return lhs - rhs;
    }
}
