package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;
import visitor.Visitor;

public class Assignment extends AbstractASTNode implements Statement {

    private Expression assigned;
    private Expression value;

    public Assignment(int line, int column, Expression assigned, Expression value) {
        super(line, column);
        this.assigned = assigned;
        this.value = value;
    }

    public Expression getAssigned() {
        return assigned;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assigned=" + assigned +
                ", value=" + value +
                '}';
    }

}
