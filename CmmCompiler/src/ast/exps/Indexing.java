package ast.exps;

import ast.AbstractASTNode;

public class Indexing extends AbstractASTNode implements Expression {

    private Expression indexed;
    private Expression index;

    public Indexing(int line, int column, Expression indexed, Expression index) {
        super(line, column);
        this.indexed = indexed;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Indexing{" +
                "indexed=" + indexed +
                ", index=" + index +
                '}';
    }
}
