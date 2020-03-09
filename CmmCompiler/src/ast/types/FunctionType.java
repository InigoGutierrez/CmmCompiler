package ast.types;

import ast.defs.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

    Type returnType;
    List<VarDefinition> args;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> args) {
        super(line, column);
        this.returnType = returnType;
        this.args = new ArrayList<>(args);
    }
}
