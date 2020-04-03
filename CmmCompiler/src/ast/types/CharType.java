package ast.types;

import ast.exps.Expression;
import visitor.Visitor;

public class CharType extends AbstractType {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public int nob() {
        return 1;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type cast(Type castedTo, Expression cast) {
        if (castedTo instanceof CharType)
            return new CharType(cast.getLine(), cast.getColumn());
        return super.cast(castedTo, cast);
    }

    @Override
    public Type compare(Type other, Expression comparison) {
        if (other instanceof CharType)
            return new IntType(comparison.getLine(), comparison.getColumn());
        return super.compare(other, comparison);
    }

    @Override
    public Type arithmetic(Type other, Expression arithmetic) {
        if (other instanceof CharType)
            return new IntType(arithmetic.getLine(), arithmetic.getColumn());
        return super.compare(other, arithmetic);
    }

    @Override
    public boolean canAssign(Type valueType) {
        return valueType instanceof CharType;
    }

    @Override
    public boolean canReturn(Type typeToReturn) {
        return typeToReturn instanceof  CharType;
    }

    @Override
	public String toString() {
		return "char";
	}

}
