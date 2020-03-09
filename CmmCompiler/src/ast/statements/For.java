package ast.statements;

import ast.AbstractASTNode;
import ast.exps.Expression;

import java.util.List;

public class For extends AbstractASTNode implements Statement {

    Expression exp;
    List<Statement> statements;

    public For(int line, int column, Expression exp, List<Statement> statements) {
        super(line, column);
        this.exp = exp;
        this.statements = statements;
    }

}
