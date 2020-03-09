package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

public class Return extends AbstractASTNode implements Statement {

    Expression exp;

    public Return(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

}
