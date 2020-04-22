package codegeneration;

import ast.exps.FieldAccessor;
import ast.exps.Indexing;
import ast.exps.Variable;
import ast.types.RecordType;

public class AddressCGVisitor extends AbstractCGVisitor<CodeGenerator, Void> {
// Code templates

public AddressCGVisitor() {
    setVisitorName("AddressCGVisitor");
}

    // Variable
    /*
    address[[Variable: variable -> ID]] =
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

    // FieldAccessor
    /*
    address[[FieldAccessor: exp1 -> exp2 ID]] =
        address[[exp2]];
        <pushi> exp2.getType().getField(ID).getOffset();
        <addi>
     */
    @Override
    public Void visit(FieldAccessor fieldAccessor, CodeGenerator cg) {
        fieldAccessor.getAccessed().accept(this, cg);
        RecordType recordType = (RecordType) fieldAccessor.getAccessed().getType();
        cg.push(recordType.getField(fieldAccessor.getField()).getOffset());
        cg.addi();
        return null;
    }

    // Indexing
    /*
    address[Indexing: exp1 -> exp2 exp3]] =
        address[[exp2]];
        value[[exp3]];
        <pushi > exp2.getType().nob();
        <muli>;
        <addi>;
     */
    @Override
    public Void visit(Indexing indexing, CodeGenerator cg) {
        indexing.getIndexed().accept(this, cg);
        indexing.getIndex().accept(new ValueCGVisitor(), cg);
        cg.push(indexing.getIndexed().getType().nob());
        cg.muli();
        cg.addi();
        return null;
    }

}

