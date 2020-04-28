package ast.types;

import ast.exps.Expression;
import visitor.Visitor;

public class ArrayType extends AbstractType {

    private Type type;
    private int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int nob() {
        return type.nob() * size;
    }

    @Override
    public Type indexing(Type indexType, Expression indexing) {
        if ( !(indexType instanceof IntType) )
		return new ErrorType(indexing.getLine(), indexing.getColumn(),
				"Can't index with " + indexType);
        return type;
    }

    @Override
    public boolean canAssign(Type valueType) {
        if (valueType instanceof ArrayType)
            return type.canAssign(((ArrayType)valueType).type);
        return false;
    }

    @Override
    public boolean canReturn(Type typeToReturn) {
        //return typeToReturn instanceof ArrayType;
        return false;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return String.format("[%d,%s]", size, type.toString());
    }
}

