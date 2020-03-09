package ast.exps;

import ast.AbstractASTNode;

public class UnaryNot extends AbstractASTNode implements Expression {

    Expression expToNegate;

    public UnaryNot(int line, int column, Expression expToNegate) {
        super(line, column);
        this.expToNegate = expToNegate;
    }

}
