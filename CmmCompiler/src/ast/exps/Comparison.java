package ast.exps;

import ast.AbstractASTNode;

public class Comparison extends AbstractASTNode implements Expression {

    private Expression expA;
    private Expression expB;
    private String operation;

    public Comparison(int line, int column, Expression expA, Expression expB, String operation) {
        super(line, column);
        this.expA = expA;
        this.expB = expB;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Comparison{" +
                "expA=" + expA +
                ", expB=" + expB +
                ", operation='" + operation + '\'' +
                '}';
    }
}
