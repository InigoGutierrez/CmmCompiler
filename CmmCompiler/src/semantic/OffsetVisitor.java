package semantic;

import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.RecordType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Boolean, Void> {

    int accOffset;

    public OffsetVisitor() {
        accOffset = 0;
    }

    @Override
    public Void visit(VarDefinition vDef, Boolean param) {
        super.visit(vDef, param);
        if (vDef.getScope() == 0) {
            vDef.setOffset(accOffset);
            accOffset += vDef.getType().nob();
        }
        else if (param != null && param.booleanValue()) {
            vDef.setOffset(4 + accOffset);
            accOffset += vDef.getType().nob();
        }
        else {
            accOffset += vDef.getType().nob();
            vDef.setOffset(-accOffset);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fDef, Boolean param) {
        fDef.getType().accept(this, param);
        accOffset = 0;
        fDef.getVarDefs().forEach(varDef -> varDef.accept(this, param));
        fDef.getStatements().forEach(stmnt -> stmnt.accept(this, param));
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Boolean param) {
        accOffset = 0;
        functionType.getReturnType().accept(this, param);
        for (int i = functionType.getArgs().size()-1; i >= 0; i--) {
            functionType.getArgs().get(i).accept(this, true);
        }
        return null;
    }

    @Override
    public Void visit(RecordType recordType, Boolean param) {
        super.visit(recordType, param);
        int offset = 0;
        for (RecordField recordField : recordType.getRecordFields()) {
            recordField.setOffset(offset);
            offset += recordField.getType().nob();
        }
        return null;
    }
}

