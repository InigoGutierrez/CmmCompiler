package semantic;

import ast.defs.Definition;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.exps.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable symbolTable;

    public IdentificationVisitor() {
        symbolTable = new SymbolTable();
    }

    @Override
    public Void visit(VarDefinition varDef, Void param) {
        if ( !symbolTable.insert(varDef) )
            new ErrorType(varDef.getLine(), varDef.getColumn(),
                    String.format("Variable declared again at %d:%d.", varDef.getLine(), varDef.getColumn()));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fDef, Void param) {
        if ( !symbolTable.insert(fDef) )
            new ErrorType(fDef.getLine(), fDef.getColumn(),
                    String.format("Variable declared again at %d:%d.", fDef.getLine(), fDef.getColumn()));
        symbolTable.set();
        super.visit(fDef, param);
        symbolTable.reset();
        return null;
    }

    @Override
    public Void visit(Variable var, Void param) {
        Definition def = symbolTable.find(var.getName());
        if ( def != null )
            var.setDefinition(def);
        else
            new ErrorType(var.getLine(), var.getColumn(),
                    String.format("Undeclared variable at %d:%d.", var.getLine(), var.getColumn()));
        return null;
    }
}

