package ast.exps;

import ast.AbstractASTNode;

public class UnaryMinus extends AbstractASTNode implements Expression {

    private Expression exp;

    public UnaryMinus(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "UnaryMinus{" +
                "exp=" + exp +
                '}';
    }
}
