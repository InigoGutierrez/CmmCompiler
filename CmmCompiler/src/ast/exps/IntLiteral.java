package ast.exps;

import ast.AbstractASTNode;

public class IntLiteral extends AbstractASTNode implements Expression {

    int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

}
