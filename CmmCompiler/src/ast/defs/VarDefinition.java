package ast.defs;

import ast.types.Type;
import visitor.Visitor;

public class VarDefinition extends AbstractDefinition {

    private int offset;

    public VarDefinition(int line, int column, Type type, String name, int offset) {
        super(line, column, name, type);
        this.offset = offset;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "VarDefinition{" +
                "name='" + getName() + '\'' +
                ", offset=" + offset +
                ", type=" + getType() +
                '}';
    }
}
