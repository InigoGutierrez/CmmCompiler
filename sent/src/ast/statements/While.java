package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractASTNode implements Statement {

    private Expression condition;
    private List<Statement> statements;

    public While(int line, int column, Expression condition, List<Statement> statements) {
        super(line, column);
        this.condition = condition;
        this.statements = new ArrayList<>(statements);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
