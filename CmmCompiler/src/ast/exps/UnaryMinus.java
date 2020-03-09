package ast.exps;

import ast.AbstractASTNode;

public class UnaryMinus extends AbstractASTNode implements Expression {

    Expression exp;

    public UnaryMinus(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

}
