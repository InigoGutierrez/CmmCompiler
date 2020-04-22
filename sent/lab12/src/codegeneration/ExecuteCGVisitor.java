package codegeneration;

import ast.Program;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.While;
import ast.statements.Write;
import ast.types.FunctionType;

public class ExecuteCGVisitor extends AbstractCGVisitor<CodeGenerator, Void> {

    public ExecuteCGVisitor() {
        setVisitorName("ExecuteCGVisitor");
    }

    // Code templates

    // Program
    /*
    execute[[Program: program -> definition*]] =
        <call main>;
        <halt>;
        definition*.forEach(d -> execute[[d]]);
    */
    @Override
    public Void visit(Program program, CodeGenerator cg) {

        var vDefs = program.getDefs().stream().filter( (def) -> def instanceof VarDefinition );
        vDefs.forEach( (vdef) -> vdef.accept(this, cg) );

        cg.call("main");
        cg.halt();

        var fDefs = program.getDefs().stream().filter( (def) -> def instanceof VarDefinition );
        fDefs.forEach( (fdef) -> fdef.accept(this, cg) );

        return null;
    }

    // VarDefinition
    /*
    execute[[VarDefinition: vDef -> type ID]] =
            <' * > type.toString() ID <( offset > vDef.getOffset() <)>;
        }
     */
    @Override
    public Void visit(VarDefinition vDef, CodeGenerator cg) {
        cg.varDefinition(vDef);
        return null;
    }

    // FunctionDefinition
    /*
    execute[[FunctionDefinition: fDef -> type ID varDef* statement*]] =
        ID <:>;
        <' * Parameters>;
        ((FunctionType) type).getArgs().forEach( vd -> execute[[vd]] );
        <' * Local variables>
        varDef*.forEach( vd -> execute[[vd]] );

        int bytesLocals = varDef*.get(varDef*.size()-1).getOffset();
        <enter> bytesLocals;

        int bytesParams = 0;
        varDef*.forEach( (vDef) -> bytesParams += vDef.getType().nob() );

        int bytesReturn = type.getReturnType().nob();

        statement*.forEach( (sttmnt) -> execute[[sttmnt]] ); // pass args for return

        if (bytesReturn == 0)
            <ret > bytesReturn <, > bytesLocals <, > bytesParams
     */
    @Override
    public Void visit(FunctionDefinition fDef, CodeGenerator cg) {

        cg.functionName(fDef.getName());

        cg.incScope();

        FunctionType fType = (FunctionType) fDef.getType();
        cg.parameters(fType.getArgs());

        cg.localVariables(fDef.getVarDefs());

        int sizeLocalVars = fDef.getVarDefs().get(fDef.getVarDefs().size()-1).getOffset();
        cg.enter(-sizeLocalVars);

        fDef.getStatements().forEach( (sttmnt) -> sttmnt.accept(this, cg) );

        // return sequence

        cg.decScope();

        return null;
    }

    // Write
    /*
    execute[[Write: statement -> expression]] =
        value[[expression]];
        <out> expression.getType().suffix();
     */
    @Override
    public Void visit(Write write, CodeGenerator cg) {
        cg.commentWriteStart();
        write.getExp().accept(new ValueCGVisitor(), cg);
        cg.out(write.getExp().getType());
        return null;
    }

    // Read
    /*
    execute[[Read: statement -> expression]] =
        address[[expression]];
        <in> expression.getType().suffix();
        <store> expression.getType().suffix();
     */
    @Override
    public Void visit(Read read, CodeGenerator cg) {
        cg.commentReadStart();
        read.getExp().accept(new AddressCGVisitor(), cg);
        cg.in(read.getExp().getType());
        cg.store(read.getExp().getType());
        return null;
    }

    // Assignment
    /*
    execute[[Assignment: statement -> expression1 expression2]] =
        address[[expression1]];
        value[[expression2]];
        <store> expression1.getType().suffix();
     */
    @Override
    public Void visit(Assignment assignment, CodeGenerator cg) {
        assignment.getAssigned().accept(new AddressCGVisitor(), cg);
        assignment.getValue().accept(new ValueCGVisitor(), cg);
        cg.store(assignment.getValue().getType());
        return null;
    }

    // While
    /*
    execute[[While: statement1 -> exp statement2*]] =
    int labelNumber = cg.getLabel(2);
    <' * While>;
    <label > labelNumber <:>;

    <' * Condition>;
    value[[exp]];
    <jz label > labelNumber + 1;

    <' * While body>;
    statement2*.foreach( (sttmnt) -> execute[[sttmnt]] );
    <jmp label > labelNumber;

    <label > labelNumber + 1;
    */

    @Override
    public Void visit(While whileStmnt, CodeGenerator cg) {
        cg.commentWhileStart();
        int labelNumber = cg.getLabel(2);
        cg.label(labelNumber);

        cg.commentCondition();
        whileStmnt.getCondition().accept(new ValueCGVisitor(), cg);
        cg.jz(labelNumber);
        return null;
    }

// If
    /*
    execute[[If: statement1 -> exp statement2* statement3*]] =
    int labelNumber = cg.getLabel(2);
    <' * If>;

    <' * condition>;
    value[[exp]];
    <jz label > labelNumber;

    <' * If body>;
    statement2*.foreach( (sttmnt) -> execute[[sttmnt]] );
    <jmp label > labelNumber + 1;

    <label > labelNumber <:>;
    <' * Else body>;
    statement3*.foreach( (sttmnt) -> execute[[sttmnt]] );
    <label > labelNumber + 1 <:>;
    */

    // Invocation
    /*
    execute[[Invocation: statement -> exp]] =
        value[[exp]];
        if ( ! (exp.getVar().getType().getReturnType() instanceof Void) )
            <pop> exp.getVar().getType().getReturnType().suffix();
    */

    // Return
    /*
    execute[[Return: statement -> exp]](int bytesLocals, int bytesParams, int bytesReturn) =
        value[[exp]];
        <ret > bytesReturn <, > bytesLocals <, > bytesParams;
     */

}

