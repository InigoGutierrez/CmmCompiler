package ast.exps;

import ast.AbstractASTNode;

public class Indexing extends AbstractASTNode implements Expression {

    Expression indexed;
    Expression index;

    public Indexing(int line, int column, Expression indexed, Expression index) {
        super(line, column);
        this.indexed = indexed;
        this.index = index;
    }

}
