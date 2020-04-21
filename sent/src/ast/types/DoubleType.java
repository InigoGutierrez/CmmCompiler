package ast.types;

import ast.exps.Expression;
import visitor.Visitor;

public class DoubleType extends AbstractBuiltinType {

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public int nob() {
        return 4;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type compare(Type other, Expression comparison) {
        if (other instanceof DoubleType)
            return new IntType(comparison.getLine(), comparison.getColumn());
        return super.compare(other, comparison);
    }

    @Override
    public Type arithmetic(Type other, Expression arithmetic) {
        if (other instanceof DoubleType)
            return new DoubleType(arithmetic.getLine(), arithmetic.getColumn());
        return super.compare(other, arithmetic);
    }

    @Override
    public Type minus(Expression unaryMinus) {
        return new DoubleType(unaryMinus.getLine(), unaryMinus.getColumn());
    }

    @Override
    public boolean canAssign(Type valueType) {
        return valueType instanceof DoubleType;
    }

    @Override
    public boolean canReturn(Type typeToReturn) {
        return typeToReturn instanceof DoubleType;
    }

    @Override
	public String toString() {
		return "double";
	}

}
