package ast.types;

import ast.defs.VarDefinition;
import ast.exps.Expression;
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

    public int getTotalParamOffset() {
        if (args.size() == 0)
            return 4;
        VarDefinition lastVarDef = args.get(args.size()-1);
        return lastVarDef.getOffset() + lastVarDef.getType().nob();
    }

    @Override
    public int nob() {
        int size = 0;
        for (VarDefinition arg : args) {
            size += arg.getType().nob();
        }
        return size;
    }

    @Override
    public Type parenthesis(Type[] argTypes, Expression funcInvocation) {
        if (args.size() == argTypes.length) {
            for (int i = 0; i < args.size(); i++) {
                if (!args.get(i).getType().canAssign(argTypes[i])) {
                    Type wrongType = argTypes[i];
                    return new ErrorType(wrongType.getLine(), wrongType.getColumn(), "Wrong argument type");
                }
            }
            return returnType;
        }
        return super.parenthesis(argTypes, funcInvocation);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(returnType.toString());
        sb.append("( ");
        for (VarDefinition arg : args)
            sb.append(arg.getType().toString() + " ");
        sb.append(")");
        return sb.toString();
    }
}

