package ast.types;

import ast.exps.Expression;
import visitor.Visitor;

public class IntType extends AbstractBuiltinType {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public int nob() {
        return 2;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type compare(Type other, Expression comparison) {
        if (other instanceof IntType)
            return new IntType(comparison.getLine(), comparison.getColumn());
        return super.compare(other, comparison);
    }

    @Override
    public Type arithmetic(Type other, Expression arithmetic) {
        if (other instanceof IntType)
            return new IntType(arithmetic.getLine(), arithmetic.getColumn());
        return super.compare(other, arithmetic);
    }

    @Override
    public Type logical(Type other, Expression logical) {
        if (other.isBoolean())
            return new IntType(logical.getLine(), logical.getColumn());
        return  super.logical(other, logical);
    }

    @Override
    public Type minus(Expression unaryMinus) {
        return new IntType(unaryMinus.getLine(), unaryMinus.getColumn());
    }

    @Override
    public Type negate(Expression unaryNot) {
        return new IntType(unaryNot.getLine(), unaryNot.getColumn());
    }

    @Override
    public boolean canAssign(Type valueType) {
        return valueType instanceof IntType;
    }

    @Override
    public boolean canReturn(Type typeToReturn) {
        return typeToReturn instanceof IntType;
    }

    @Override
    public boolean isBoolean() {
        return true;
    }

    @Override
    public String convertTo(Type targetType) {
        if (targetType instanceof IntType)
                return "";
        return suffix() + "2" + targetType.suffix();
    }

    @Override
    public String suffix() {
        return "i";
    }

    @Override
	public String toString() {
		return "int";
	}

}

