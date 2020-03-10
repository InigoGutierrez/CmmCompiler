package ast.exps;

import ast.AbstractASTNode;

public class FieldAccessor extends AbstractASTNode implements Expression {

    private String field;
    private Expression accessed;

    public FieldAccessor(int line, int column, Expression accessed, String field) {
        super(line, column);
        this.accessed = accessed;
        this.field = field;
    }

    @Override
    public String toString() {
        return "FieldAccessor{" +
                "field='" + field + '\'' +
                ", accessed=" + accessed +
                '}';
    }
}
