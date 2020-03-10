package ast.exps;

import ast.AbstractASTNode;

public class UnaryNot extends AbstractASTNode implements Expression {

    private Expression expToNegate;

    public UnaryNot(int line, int column, Expression expToNegate) {
        super(line, column);
        this.expToNegate = expToNegate;
    }

    @Override
    public String toString() {
        return "UnaryNot{" +
                "expToNegate=" + expToNegate +
                '}';
    }
}
