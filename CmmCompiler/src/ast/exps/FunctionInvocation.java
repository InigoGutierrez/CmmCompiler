package ast.exps;

import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractASTNode implements Expression {

    private Variable name;
    private List<Expression> args;

    public FunctionInvocation(int line, int column, Variable name, List<Expression> args) {
        super(line, column);
        this.name = name;
        this.args = new ArrayList(args);
    }

    public Variable getName() {
        return name;
    }

    public List<Expression> getArguments() {
        return new ArrayList(args);
    }

    @Override
    public String toString() {
        return "FunctionInvocation{" +
                "name=" + name +
                '}';
    }

}

