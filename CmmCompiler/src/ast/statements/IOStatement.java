package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

public class IOStatement extends AbstractASTNode implements Statement {

    Expression exp;

    public IOStatement(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

}
