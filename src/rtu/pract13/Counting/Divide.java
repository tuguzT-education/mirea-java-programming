package rtu.pract13.Counting;

public class Divide extends Operation {
    public Divide(Input first, Input second) {
        super(first, second);
    }

    @Override
    protected double evaluate(double lhs, double rhs) {
        return lhs / rhs;
    }
}
