package semantic;

import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.RecordType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Boolean, Void> {

    int globalOffset;
    int localOffset;

    public OffsetVisitor() {
        globalOffset = 0;
        localOffset = 0;
    }

    @Override
    public Void visit(VarDefinition vDef, Boolean param) {
        super.visit(vDef, param);
        if (vDef.getScope() == 0) {
            vDef.setOffset(globalOffset);
            globalOffset += vDef.getType().nob();
        }
        else if (param != null && param.booleanValue()) {
            vDef.setOffset(4 + localOffset);
            localOffset += vDef.getType().nob();
        }
        else {
            localOffset += vDef.getType().nob();
            vDef.setOffset(-localOffset);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fDef, Boolean param) {
        fDef.getType().accept(this, param);
        localOffset = 0;
        fDef.getVarDefs().forEach(varDef -> varDef.accept(this, param));
        fDef.getStatements().forEach(stmnt -> stmnt.accept(this, param));
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Boolean param) {
        localOffset = 0;
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

