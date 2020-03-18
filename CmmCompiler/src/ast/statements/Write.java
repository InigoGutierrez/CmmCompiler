package ast.statements;

import ast.exps.Expression;
import visitor.Visitor;

public class Write extends IOStatement {

    public Write(int line, int column, Expression exp) {
        super(line, column, exp);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
