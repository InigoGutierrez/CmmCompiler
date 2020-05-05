package codegeneration;

import ast.Program;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.statements.*;
import ast.types.ArrayType;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<ExecuteCGVisitorParam, Void> {

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
    public Void visit(Program program, ExecuteCGVisitorParam param) {

        var vDefs = program.getDefs().stream().filter( (def) -> def instanceof VarDefinition );
        vDefs.forEach( (vdef) -> vdef.accept(this, param) );

        param.getCodeGenerator().call("main");
        param.getCodeGenerator().halt();

        var fDefs = program.getDefs().stream().filter( (def) -> def instanceof FunctionDefinition );
        fDefs.forEach( (fdef) -> fdef.accept(this, param) );

        return null;

    }

    // VarDefinition
    /*
    execute[[VarDefinition: vDef -> type ID]] =
            <' * > type.toString() ID <( offset > vDef.getOffset() <)>;
        }
     */
    @Override
    public Void visit(VarDefinition vDef, ExecuteCGVisitorParam param) {
        param.getCodeGenerator().varDefinition(vDef);
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

        int bytesReturn = type.getReturnType().nob();
        int bytesLocals = varDef*.get(varDef*.size()-1).getOffset();
        int bytesParams = 0;
        varDef*.forEach( (vDef) -> bytesParams += vDef.getType().nob() );

        <enter> bytesLocals;

        statement*.forEach( (sttmnt) -> execute[[sttmnt]] ); // pass args for return

        if (bytesReturn == 0)
            <ret > bytesReturn <, > bytesLocals <, > bytesParams
     */
    @Override
    public Void visit(FunctionDefinition fDef, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();

        cg.functionName(fDef.getName());

        cg.incScope();

        FunctionType fType = (FunctionType) fDef.getType();
        cg.commentParameters();
        fType.getArgs().forEach( (p) -> p.accept(this, param) );

        cg.commentLocalVariables();
        fDef.getVarDefs().forEach( (arg) -> arg.accept(this, param) );

        int bytesReturn = fType.getReturnType().nob();

        int bytesLocals = 0;
        if (fDef.getVarDefs().size() > 0) {
            bytesLocals = -fDef.getVarDefs().get(fDef.getVarDefs().size() - 1).getOffset();
        }

        int bytesParams = 0;
        for (VarDefinition arg : fType.getArgs()) {
            bytesParams += arg.getType().nob();
        }

        cg.enter(bytesLocals);

        ExecuteCGVisitorParam paramWithValues = new ExecuteCGVisitorParam(cg, bytesReturn, bytesLocals, bytesParams);

        fDef.getStatements().forEach( (sttmnt) -> sttmnt.accept(this, paramWithValues) );

        if (bytesReturn == 0) {
            cg.ret(bytesReturn, bytesLocals, bytesParams);
        }

        cg.decScope();

        return null;
    }

    // Write
    /*
    execute[[Write: statement -> expression]] =
        if (expression instanceof ArrayType) {
            int offset = 0;
            int step = expression.getType().getType().nob();
            for (int i = 0; i < expression.getSize(); i++) {
                address[[expression]];
                <pushi> offset;
                <addi>
                <load> expression.getType().getType().suffix();
                <out> expression.getType().getType().suffix();
            }
        }
        else {
            value[[expression]];
            <out> expression.getType().suffix();
        }
     */
    @Override
    public Void visit(Write write, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();
        cg.commentWriteStart();


        if (write.getExp().getType() instanceof ArrayType) {
            ArrayType writeArrayType = (ArrayType) write.getExp().getType();

            int offset = 0;
            int step = writeArrayType.getType().nob();
            for (int i = 0; i < writeArrayType.getSize(); i++) {
                write.getExp().accept(new AddressCGVisitor(), cg);
                cg.push(offset);
                cg.addi();
                cg.load(writeArrayType.getType());
                cg.out(write.getExp().getType());
                offset += step;
            }
            return null;
        }

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
    public Void visit(Read read, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();
        cg.commentReadStart();
        read.getExp().accept(new AddressCGVisitor(), cg);
        cg.in(read.getExp().getType());
        cg.store(read.getExp().getType());
        return null;
    }

    // Assignment
    /*
    execute[[Assignment: statement -> expression1 expression2]] =
        if (expression1 instanceof ArrayType) {
            int offset = 0;
            int step = expression1.getType().getType().nob();
            for (int i = 0; i < expression1.getSize(); i++) {
                address[[expression1]];
                <pushi> offset;
                <addi>
                address[[expression2]];
                <pushi> offset;
                <addi>
                <load> expression1.getType().getType().suffix();
                <store> expression1.getType().getType().suffix();
            }
        }
        else {
            address[[expression1]];
            value[[expression2]];
            <store> expression1.getType().suffix();
        }
     */
    @Override
    public Void visit(Assignment assignment, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();

        if (assignment.getAssigned().getType() instanceof ArrayType) {
            ArrayType valueArrayType = (ArrayType) assignment.getValue().getType();

            int offset = 0;
            int step = valueArrayType.getType().nob();
            for (int i = 0; i < valueArrayType.getSize(); i++) {
                assignment.getAssigned().accept(new AddressCGVisitor(), cg);
                cg.push(offset);
                cg.addi();
                assignment.getValue().accept(new AddressCGVisitor(), cg);
                cg.push(offset);
                cg.addi();
                cg.load(valueArrayType.getType());
                cg.store(assignment.getValue().getType());
                offset += step;
            }
            return null;
        }

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
    public Void visit(While whileStmnt, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();
        int labelNumber = cg.getLabel(2);

        cg.commentWhileStart();
        cg.label(labelNumber);

        cg.commentCondition();
        whileStmnt.getCondition().accept(new ValueCGVisitor(), cg);
        cg.jz(labelNumber + 1);

        cg.commentWhileBody();
        whileStmnt.getStatements().forEach( (sttmnt) -> sttmnt.accept(this, param) );
        cg.jmp(labelNumber);

        cg.label(labelNumber + 1);

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
    @Override
    public Void visit(If ifStmnt, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();
        int labelNumber = cg.getLabel(2);

        cg.commentIfStart();

        cg.commentCondition();
        ifStmnt.getCondition().accept(new ValueCGVisitor(), cg);
        cg.jz(labelNumber);

        cg.commentIfBody();
        ifStmnt.getStatements().forEach( (sttmnt) -> sttmnt.accept(this, param) );
        cg.jmp(labelNumber + 1);

        cg.label(labelNumber);
        cg.commentElseBody();
        ifStmnt.getElseStatements().forEach( (sttmnt) -> sttmnt.accept(this, param) );

        cg.label(labelNumber + 1);

        return null;
    }

    // Invocation
    /*
    execute[[Invocation: statement -> exp]] =
        value[[exp]];
        if ( ! (exp.getVar().getType().getReturnType() instanceof Void) )
            <pop> exp.getVar().getType().getReturnType().suffix();
    */
    @Override
    public Void visit(Invocation invocation, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();

        invocation.getfInvocation().accept(new ValueCGVisitor(), cg);

        FunctionType fType = (FunctionType) invocation.getfInvocation().getVar().getType();
        if (! (fType.getReturnType() instanceof VoidType)) {
            cg.pop(fType.getReturnType());
        }

        return null;
    }

    // Return
    /*
    execute[[Return: statement -> exp]](int bytesLocals, int bytesParams, int bytesReturn) =
        value[[exp]];
        <ret > bytesReturn <, > bytesLocals <, > bytesParams;
     */
    @Override
    public Void visit(Return returnStmnt, ExecuteCGVisitorParam param) {
        CodeGenerator cg = param.getCodeGenerator();
        int bytesReturn = param.getBytesReturn();
        int bytesLocals = param.getBytesLocals();
        int bytesParams = param.getBytesParams();

        cg.commentReturn();
        returnStmnt.getExp().accept(new ValueCGVisitor(), cg);
        cg.ret(bytesReturn, bytesLocals, bytesParams);
        return null;
    }
}

