package ast.statements;

import ast.exps.Expression;

public class Read extends IOStatement {

    public Read(int line, int column, Expression exp) {
        super(line, column, exp);
    }

    @Override
    public String toString() {
        return "Read{" +
                "exp=" + getExp() +
                "}";
    }
}
