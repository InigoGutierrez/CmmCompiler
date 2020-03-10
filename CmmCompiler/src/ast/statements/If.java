package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

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

    @Override
    public String toString() {
        return "If{" +
                "condition=" + condition +
                '}';
    }
}
