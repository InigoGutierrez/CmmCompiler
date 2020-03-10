package ast.exps;

import ast.AbstractASTNode;
import ast.types.Type;

public class CastExpr extends AbstractASTNode implements Expression  {

    private Type targetType;
    private Expression casted;

    public CastExpr(int line, int column, Type targetType, Expression casted) {
        super(line, column);
        this.targetType = targetType;
        this.casted = casted;
    }

    @Override
    public String toString() {
        return "CastExpr{" +
                "targetType=" + targetType +
                ", casted=" + casted +
                '}';
    }
}
