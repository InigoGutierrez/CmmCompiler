package ast.statements;

import ast.exps.Expression;

public class Write extends IOStatement {

    public Write(int line, int column, Expression exp) {
        super(line, column, exp);
    }

}
