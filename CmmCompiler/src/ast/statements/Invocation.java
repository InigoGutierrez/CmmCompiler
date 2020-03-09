package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

import java.util.ArrayList;
import java.util.List;

public class Invocation extends AbstractASTNode implements Statement {

    private String name;
    private List<Expression> args;

    public Invocation(int line, int column, String name, List<Expression> args) {
        super(line, column);
        this.name = name;
        this.args = new ArrayList(args);
    }

}
