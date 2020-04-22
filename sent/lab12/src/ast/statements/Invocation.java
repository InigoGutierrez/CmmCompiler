package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;
import ast.exps.FunctionInvocation;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Invocation extends AbstractASTNode implements Statement {

    private FunctionInvocation fInvocation;

    public Invocation(FunctionInvocation fInvocation) {
        super(fInvocation.getLine(), fInvocation.getColumn());
        this.fInvocation = fInvocation;
    }

    public FunctionInvocation getfInvocation() {
        return fInvocation;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Invocation{" +
                "fInvocation=" + fInvocation +
                '}';
    }

}

