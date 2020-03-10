package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;
import ast.exps.FunctionInvocation;

import java.util.ArrayList;
import java.util.List;

public class Invocation extends AbstractASTNode implements Statement {

    private FunctionInvocation fInvocation;

    public Invocation(FunctionInvocation fInvocation) {
        super(fInvocation.getLine(), fInvocation.getColumn());
        this.fInvocation = fInvocation;
    }

}
