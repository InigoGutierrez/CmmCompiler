package ast.defs;

import ast.types.Type;

public class VarDefinition extends AbstractDefinition {

    String name;
    int offset;

    public VarDefinition(int line, int column, Type type, String name, int offset) {
        super(line, column, type);
        this.name = name;
        this.offset = offset;
    }

    @Override
    public String getName() {
        return name;
    }
}
