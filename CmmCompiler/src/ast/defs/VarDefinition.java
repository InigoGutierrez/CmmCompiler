package ast.defs;

import ast.types.Type;

public class VarDefinition extends AbstractDefinition {

    private String name;
    private int offset;

    public VarDefinition(int line, int column, Type type, String name, int offset) {
        super(line, column, type);
        this.name = name;
        this.offset = offset;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VarDefinition{" +
                "name='" + name + '\'' +
                ", offset=" + offset +
                ", type=" + getType() +
                '}';
    }
}
