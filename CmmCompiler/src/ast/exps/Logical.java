package ast.exps;

import ast.AbstractASTNode;

public class Logical extends AbstractASTNode implements Expression {

    Expression expA;
    Expression expB;
    String operation;

    public Logical(int line, int column, Expression expA, Expression expB, String operation) {
        super(line, column);
        this.expA = expA;
        this.expB = expB;
        this.operation = operation;
    }

}
