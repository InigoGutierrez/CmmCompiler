package ast.types;

import ast.defs.VarDefinition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

    private Type returnType;
    private List<VarDefinition> args;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> args) {
        super(line, column);
        this.returnType = returnType;
        this.args = new ArrayList<>(args);
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VarDefinition> getArgs() {
        return new ArrayList<>(args);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
    
}
