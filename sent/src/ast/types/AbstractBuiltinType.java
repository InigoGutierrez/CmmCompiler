package ast.types;

import ast.exps.Expression;

public abstract class AbstractBuiltinType extends AbstractType {

    public AbstractBuiltinType(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }

    @Override
    public Type cast(Type castedTo, Expression cast) {
        if (castedTo.isBuiltin())
            return castedTo;
        return super.cast(castedTo, cast);
    }

}

