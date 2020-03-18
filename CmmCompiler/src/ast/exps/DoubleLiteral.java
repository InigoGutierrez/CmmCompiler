package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

public class DoubleLiteral extends AbstractExpression {

    private double value;

    public DoubleLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "DoubleLiteral{" +
                "value=" + value +
                '}';
    }
}
