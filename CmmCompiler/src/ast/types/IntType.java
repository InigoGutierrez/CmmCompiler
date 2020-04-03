package ast.types;

import ast.exps.Expression;
import visitor.Visitor;

public class IntType extends AbstractType {

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
    public Type cast(Type castedTo, Expression cast) {
        if (castedTo instanceof IntType)
            return new IntType(cast.getLine(), cast.getColumn());
        return super.cast(castedTo, cast);
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
	public String toString() {
		return "int";
	}

}
