package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;
import visitor.Visitor;

public class Return extends AbstractASTNode implements Statement {

    private Expression exp;

    public Return(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

    public Expression getExp() {
        return exp;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Return{" +
                "exp=" + exp +
                '}';
    }
}
