package rtu.pract11.Counting;

public abstract class Operation implements Input {
    final Input first;
    final Input second;

    public Operation(Input first, Input second) {
        this.first = first;
        this.second = second;
    }

    public double evaluate(double variable) {
        if (first instanceof Const) {
            if (second instanceof Const) {
                return evaluate(variable, (Const) first, (Const) second);
            }
            if (second instanceof Variable) {
                return evaluate(variable, (Const) first, (Variable) second);
            }
            if (second instanceof Operation) {
                return evaluate(variable, (Const) first, (Operation) second);
            }
        }
        if (first instanceof Variable) {
            if (second instanceof Const) {
                return evaluate(variable, (Variable) first, (Const) second);
            }
            if (second instanceof Variable) {
                return evaluate(variable, (Variable) first, (Variable) second);
            }
            if (second instanceof Operation) {
                return evaluate(variable, (Variable) first, (Operation) second);
            }
        }
        if (first instanceof Operation) {
            if (second instanceof Const) {
                return evaluate(variable, (Operation) first, (Const) second);
            }
            if (second instanceof Variable) {
                return evaluate(variable, (Operation) first, (Variable) second);
            }
            if (second instanceof Operation) {
                return evaluate(variable, (Operation) first, (Operation) second);
            }
        }
        return 0;
    }

    protected abstract double evaluate(double variable, Const first, Const second);

    protected abstract double evaluate(double variable, Const first, Variable second);

    protected abstract double evaluate(double variable, Const first, Operation second);

    protected abstract double evaluate(double variable, Variable first, Const second);

    protected abstract double evaluate(double variable, Variable first, Variable second);

    protected abstract double evaluate(double variable, Variable first, Operation second);

    protected abstract double evaluate(double variable, Operation first, Const second);

    protected abstract double evaluate(double variable, Operation first, Variable second);

    protected abstract double evaluate(double variable, Operation first, Operation second);
}
