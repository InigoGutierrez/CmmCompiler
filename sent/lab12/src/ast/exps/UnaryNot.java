package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

public class UnaryNot extends AbstractExpression {

    private Expression expToNegate;

    public UnaryNot(int line, int column, Expression expToNegate) {
        super(line, column);
        this.expToNegate = expToNegate;
    }

    public Expression getExpToNegate() {
        return expToNegate;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "UnaryNot{" +
                "expToNegate=" + expToNegate +
                '}';
    }
}
