package ast.defs;

import ast.AbstractASTNode;
import ast.types.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    Type type;

    public AbstractDefinition(int line, int column, Type type) {
        super(line, column);
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

}

