package rtu.pract13.Counting;

public class Add extends Operation {
    public Add(Input first, Input second) {
        super(first, second);
    }

    @Override
    protected double evaluate(double lhs, double rhs) {
        return lhs + rhs;
    }
}
