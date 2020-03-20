package visitor;

import ast.Program;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.exps.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program program, TP param) {
        program.getDefs().forEach(d -> d.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VarDefinition vDef, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionDefinition fDef, TP param) {
        fDef.getType().accept(this, param);
        fDef.getVarDefs().forEach(vd -> vd.accept(this, param));
        fDef.getStatements().forEach(s -> s.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Arithmetic arith, TP param) {
        arith.getExpA().accept(this, param);
        arith.getExpB().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CastExpr castExpr, TP param) {
        castExpr.getTargetType().accept(this, param);
        castExpr.getCasted().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLit, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLit, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLit, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comp, TP param) {
        comp.getExpA().accept(this, param);
        comp.getExpB().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FieldAccessor fieldAccessor, TP param) {
        fieldAccessor.getAccessed().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation fInvoc, TP param) {
        fInvoc.getVar().accept(this, param);
        fInvoc.getArguments().forEach(a -> a.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.getIndexed().accept(this, param);
        indexing.getIndex().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.getExpA().accept(this, param);
        logical.getExpB().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus uMinus, TP param) {
        uMinus.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNot uNot, TP param) {
        uNot.getExpToNegate().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable var, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.getAssigned().accept(this, param);
        assignment.getValue().accept(this, param);
        return null;
    }

    @Override
    public TR visit(If ifStmnt, TP param) {
        ifStmnt.getCondition().accept(this, param);
        ifStmnt.getStatements().forEach(s -> s.accept(this, param));
        ifStmnt.getElseStatements().forEach(es -> es.accept(this, param));
        return null;
    }

    @Override
    public TR visit(While whileStmnt, TP param) {
        whileStmnt.getCondition().accept(this, param);
        whileStmnt.getStatements().forEach(s -> s.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Invocation invocation, TP param) {
        invocation.getfInvocation().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        write.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return returnStmnt, TP param) {
        returnStmnt.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.getReturnType().accept(this, param);
        functionType.getArgs().forEach(a -> a.accept(this, param));
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        recordType.getRecordFields().forEach(rf -> rf.accept(this, param));
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        recordField.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }

}

