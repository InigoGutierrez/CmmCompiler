package codegeneration;

import ast.exps.Variable;

public class AddressCGVisitor extends AbstractCGVisitor<CodeGenerator, Void> {
// Code templates

public AddressCGVisitor() {
    setVisitorName("AddressCGVisitor");
}

    // Variable
    /*
    address[[Variable: variable -> ID]]:
        offset = ((VarDefinition) var.getDefinition()).getOffset();
        if (var.getDefinition().getScope() == 0)
            <pusha> offset;
        else {
            <push BP>;
            <pushi> offset;
            <addi>;
        }
     */
    @Override
    public Void visit(Variable var, CodeGenerator cg) {
        cg.variableAddress(var, var.getDefinition().getScope());
        return null;
    }
}

