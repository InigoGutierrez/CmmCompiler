package ast.exps;

import ast.AbstractASTNode;

public class DoubleLiteral extends AbstractASTNode implements Expression {

    double value;

    public DoubleLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }
}
