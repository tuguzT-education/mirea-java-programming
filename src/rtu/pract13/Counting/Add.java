package rtu.pract13.Counting;

public class Add extends Operation {
    public Add(Input first, Input second) {
        super(first, second);
    }

    @Override
    protected double evaluate(double variable, Const first, Const second) {
        return first.constant + second.constant;
    }

    @Override
    protected double evaluate(double variable, Const first, Variable second) {
        return first.constant + variable;
    }

    @Override
    protected double evaluate(double variable, Const first, Operation second) {
        return first.constant + second.evaluate(variable);
    }

    @Override
    protected double evaluate(double variable, Variable first, Const second) {
        return variable + second.constant;
    }

    @Override
    protected double evaluate(double variable, Variable first, Variable second) {
        return variable + variable;
    }

    @Override
    protected double evaluate(double variable, Variable first, Operation second) {
        return variable + second.evaluate(variable);
    }

    @Override
    protected double evaluate(double variable, Operation first, Const second) {
        return first.evaluate(variable) + second.constant;
    }

    @Override
    protected double evaluate(double variable, Operation first, Variable second) {
        return first.evaluate(variable) + variable;
    }

    @Override
    protected double evaluate(double variable, Operation first, Operation second) {
        return first.evaluate(variable) + second.evaluate(variable);
    }
}
