package ast.exps;

import ast.AbstractASTNode;

public class RealLiteral extends AbstractASTNode implements Expression {

    double value;

    public RealLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }
}
