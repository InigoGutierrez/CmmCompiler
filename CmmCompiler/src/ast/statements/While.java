package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractASTNode implements Statement {

    Expression condition;
    List<Statement> statements;

    public While(int line, int column, Expression condition, List<Statement> statements) {
        super(line, column);
        this.condition = condition;
        this.statements = new ArrayList<>(statements);
    }

}
