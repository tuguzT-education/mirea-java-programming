package rtu.pract13.Counting;

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
                return evaluate(((Const) first).constant, ((Const) second).constant);
            }
            if (second instanceof Variable) {
                return evaluate(((Const) first).constant, variable);
            }
            if (second instanceof Operation) {
                return evaluate(((Const) first).constant, ((Operation) second).evaluate(variable));
            }
        }
        if (first instanceof Variable) {
            if (second instanceof Const) {
                return evaluate(variable, ((Const) second).constant);
            }
            if (second instanceof Variable) {
                return evaluate(variable, variable);
            }
            if (second instanceof Operation) {
                return evaluate(variable, ((Operation) second).evaluate(variable));
            }
        }
        if (first instanceof Operation) {
            if (second instanceof Const) {
                return evaluate(((Operation) first).evaluate(variable), ((Const) second).constant);
            }
            if (second instanceof Variable) {
                return evaluate(((Operation) first).evaluate(variable), variable);
            }
            if (second instanceof Operation) {
                return evaluate(((Operation) first).evaluate(variable), ((Operation) second).evaluate(variable));
            }
        }
        return 0;
    }

    protected abstract double evaluate(double lhs, double rhs);
}
