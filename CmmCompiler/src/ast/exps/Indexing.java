package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

public class Indexing extends AbstractExpression {

    private Expression indexed;
    private Expression index;

    public Indexing(int line, int column, Expression indexed, Expression index) {
        super(line, column);
        this.indexed = indexed;
        this.index = index;
    }

    public Expression getIndexed() {
        return indexed;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Indexing{" +
                "indexed=" + indexed +
                ", index=" + index +
                '}';
    }
}
