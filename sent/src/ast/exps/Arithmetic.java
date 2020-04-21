package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

public class Arithmetic extends AbstractExpression {

    private Expression expA;
    private Expression expB;
    private String operation;

    public Arithmetic(int line, int column, Expression expA, Expression expB, String operation) {
        super(line, column);
        this.expA = expA;
        this.expB = expB;
        this.operation = operation;
    }

    public Expression getExpA() {
        return expA;
    }

    public Expression getExpB() {
        return expB;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Arithmetic{" +
                "expA=" + expA +
                ", expB=" + expB +
                ", operation='" + operation + '\'' +
                '}';
    }

}

