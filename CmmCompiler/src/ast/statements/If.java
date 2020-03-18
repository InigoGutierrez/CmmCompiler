package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class If extends AbstractASTNode implements Statement {

    private Expression condition;
    private List<Statement> statements;
    private List<Statement> elseStatements;

    public If(int line, int column, Expression condition, List<Statement> statements) {
        super(line, column);
        this.condition = condition;
        this.statements = new ArrayList(statements);
        this.elseStatements = new ArrayList();
    }

    public If(int line, int column, Expression condition, List<Statement> statements,
              List<Statement> elseStatements) {
        this(line, column, condition, statements);
        this.elseStatements = new ArrayList(elseStatements);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    public List<Statement> getElseStatements() {
        return new ArrayList<>(elseStatements);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "If{" +
                "condition=" + condition +
                '}';
    }
}
