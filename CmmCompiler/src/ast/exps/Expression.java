package ast.exps;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {
    boolean getLvalue();
    void setLvalue(boolean value);
    Type getType();
    void setType(Type type);
}

