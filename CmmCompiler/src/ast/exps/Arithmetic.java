package ast.exps;

import ast.AbstractASTNode;

public class Arithmetic extends AbstractASTNode implements Expression {

    Expression expA;
    Expression expB;
    String operation;

    public Arithmetic(int line, int column, Expression expA, Expression expB, String operation) {
        super(line, column);
        this.expA = expA;
        this.expB = expB;
        this.operation = operation;
    }

}
