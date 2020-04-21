package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression {

    private Variable var;
    private List<Expression> args;

    public FunctionInvocation(int line, int column, Variable var, List<Expression> args) {
        super(line, column);
        this.var = var;
        this.args = new ArrayList(args);
    }

    public Variable getVar() {
        return var;
    }

    public List<Expression> getArguments() {
        return new ArrayList(args);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionInvocation{" +
                "var=" + var +
                '}';
    }

}

