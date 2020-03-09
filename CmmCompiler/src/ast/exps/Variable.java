package ast.exps;

import ast.AbstractASTNode;

public class Variable extends AbstractASTNode implements Expression {

    String name;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }
}
