package ast.types;

import ast.AbstractASTNode;
import visitor.Visitor;

public class RecordField extends AbstractASTNode {

    private  Type type;
    private  String name;
    private  int offset;

    public RecordField(int line, int column, Type type, String name, int offset) {
        super(line, column);
        this.type = type;
        this.name = name;
        this.offset = offset;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "RecordField{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", offset=" + offset +
                '}';
    }
}

