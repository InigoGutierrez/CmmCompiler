package ast.exps;

import ast.AbstractASTNode;
import ast.types.Type;
import visitor.Visitor;

public class CastExpr extends AbstractExpression {

    private Type targetType;
    private Expression casted;

    public CastExpr(int line, int column, Type targetType, Expression casted) {
        super(line, column);
        this.targetType = targetType;
        this.casted = casted;
    }

    public Type getTargetType() {
        return targetType;
    }

    public Expression getCasted() {
        return casted;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "CastExpr{" +
                "targetType=" + targetType +
                ", casted=" + casted +
                '}';
    }
}

