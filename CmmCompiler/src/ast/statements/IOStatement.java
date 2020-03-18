package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

public abstract class IOStatement extends AbstractASTNode implements Statement {

    private Expression exp;

    public IOStatement(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

    public Expression getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return "IOStatement{" +
                "exp=" + exp +
                '}';
    }

}

