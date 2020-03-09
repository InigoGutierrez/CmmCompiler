package ast.exps;

import ast.AbstractASTNode;
import ast.types.Type;

public class Cast extends AbstractASTNode implements Expression  {

    Type type;
    Expression casted;

    public Cast(int line, int column, Type type, Expression casted) {
        super(line, column);
        this.type = type;
        this.casted = casted;
    }
}
