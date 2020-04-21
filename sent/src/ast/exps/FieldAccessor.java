package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

public class FieldAccessor extends AbstractExpression {

    private String field;
    private Expression accessed;

    public FieldAccessor(int line, int column, Expression accessed, String field) {
        super(line, column);
        this.accessed = accessed;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public Expression getAccessed() {
        return accessed;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "FieldAccessor{" +
                "field='" + field + '\'' +
                ", accessed=" + accessed +
                '}';
    }
}
