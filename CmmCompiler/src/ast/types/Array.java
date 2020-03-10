package ast.types;

public class Array extends AbstractType {

    private Type type;
    private int size;

    public Array(int line, int column, Type type, int size) {
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

}

