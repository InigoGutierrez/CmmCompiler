package codegeneration;

import ast.Program;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Write;
import ast.types.FunctionType;

public class ExecuteCGVisitor extends AbstractCGVisitor<CodeGenerator, Void> {

    public ExecuteCGVisitor() {
        setVisitorName("ExecuteCGVisitor");
    }

    // Code templates

    // Program
    /*
    execute[[Program: program -> definition*]]:
        <call main>;
        <halt>;
        definition*.forEach(d -> execute[[d]]);
    */
    @Override
    public Void visit(Program program, CodeGenerator cg) {
        cg.call("main");
        cg.halt();
        program.getDefs().forEach( (def) -> def.accept(this, cg) );
        return null;
    }

    // VarDefinition
    /*
    execute[[VarDefinition: vDef -> type ID]]:
            <' * > vDef.getType().toString() vDef.getName() <( offset > vDef.getOffset() <)>;
        }
     */
    @Override
    public Void visit(VarDefinition vDef, CodeGenerator cg) {
        cg.varDefinition(vDef);
        return null;
    }

    // FunctionDefinition
    /*
    execute[[FunctionDefinition: fDef -> type ID varDef* statement*]]:
        ID <:>;
        <  ' * Parameters>;
        ((FunctionType) type).getArgs().forEach( vd -> execute[[vd]] );
        <  ' * Local variables>
        varDef*.forEach( vd -> execute[[vd]] );
        <enter> ((FunctionType type).getTotalParamOffset();
        statement*.forEach( (sttmnt) -> execute[[sttmnt]] );
     */

    @Override
    public Void visit(FunctionDefinition fDef, CodeGenerator cg) {

        cg.functionName(fDef.getName());

        cg.incScope();

        FunctionType fType = (FunctionType) fDef.getType();
        cg.parameters(fType.getArgs());

        cg.localVariables(fDef.getVarDefs());

        cg.enter(fType.getTotalParamOffset());

        fDef.getStatements().forEach( (sttmnt) -> sttmnt.accept(this, cg) );

        cg.decScope();

        return null;
    }

    // Write
    /*
    execute[[Write: write -> expression]]:
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
    execute[[Read: read -> expression]]:
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
    execute[[Assignment: assignment -> expression1 expression2]]:
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
}

