package ast.exps;

import ast.AbstractASTNode;
import ast.types.Type;

public class CastExpr extends AbstractASTNode implements Expression  {

    Type targetType;
    Expression casted;

    public CastExpr(int line, int column, Type targetType, Expression casted) {
        super(line, column);
        this.targetType = targetType;
        this.casted = casted;
    }
}
