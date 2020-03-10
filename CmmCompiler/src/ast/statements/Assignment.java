package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

public class Assignment extends AbstractASTNode implements Statement {

    private Expression assigned;
    private Expression value;

    public Assignment(int line, int column, Expression assigned, Expression value) {
        super(line, column);
        this.assigned = assigned;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assigned=" + assigned +
                ", value=" + value +
                '}';
    }

}
