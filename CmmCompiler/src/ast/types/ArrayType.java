package ast.types;

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
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}

