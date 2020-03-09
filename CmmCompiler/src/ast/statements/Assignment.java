package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

public class Assignment extends AbstractASTNode implements Statement {

    Expression assigned;
    Expression value;

    public Assignment(int line, int column, Expression assigned, Expression value) {
        super(line, column);
        this.assigned = assigned;
        this.value = value;
    }

}
