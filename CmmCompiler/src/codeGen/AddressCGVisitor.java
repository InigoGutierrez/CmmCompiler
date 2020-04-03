package codeGen;

import ast.defs.VarDefinition;
import ast.exps.Variable;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    int accOffset;

    public AddressCGVisitor() {
        accOffset = 0;
    }

    @Override
    public Void visit(VarDefinition vDef, Void param) {
        if (vDef.getScope() == 0)
        {
            vDef.setOffset(accOffset);
            accOffset += vDef.getType().nob();
        }
        else {
            accOffset += vDef.getType().nob();
            vDef.setOffset(-accOffset);
        }
        return null;
    }

    @Override
    public Void visit(Variable var, Void param) {
        return super.visit(var, param);
    }

}

