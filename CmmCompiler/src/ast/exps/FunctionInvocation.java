package ast.exps;

import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractASTNode implements Expression {

    String name;
    List<Expression> args;

    public FunctionInvocation(int line, int column, String name, List<Expression> args) {
        super(line, column);
        this.name = name;
        this.args = new ArrayList(args);
    }

    public String getName() {
        return name;
    }

    public List<Expression> getArguments() {
        return new ArrayList(args);
    }

}

