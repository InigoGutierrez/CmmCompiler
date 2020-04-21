package codegeneration;

import ast.Program;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.exps.*;
import ast.statements.*;
import ast.types.*;
import exceptions.InvalidVisitException;
import visitor.Visitor;

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    private String visitorName;

    protected void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    @Override
    public TR visit(Program program, TP param) {
        throw new InvalidVisitException("Can't visit program with " + visitorName);
    }

    @Override
    public TR visit(VarDefinition vDef, TP param) {
        throw new InvalidVisitException("Can't visit varDefinition with " + visitorName);
    }

    @Override
    public TR visit(FunctionDefinition fDef, TP param) {
        throw new InvalidVisitException("Can't visit functionDefinition with " + visitorName);
    }

    @Override
    public TR visit(Arithmetic arith, TP param) {
        throw new InvalidVisitException("Can't visit Arithmetic with " + visitorName);
    }

    @Override
    public TR visit(CastExpr castExpr, TP param) {
        throw new InvalidVisitException("Can't visit CastExpr with " + visitorName);
    }

    @Override
    public TR visit(IntLiteral intLit, TP param) {
        throw new InvalidVisitException("Can't visit IntLiteral with " + visitorName);
    }

    @Override
    public TR visit(DoubleLiteral doubleLit, TP param) {
        throw new InvalidVisitException("Can't visit DoubleLiteral with " + visitorName);
    }

    @Override
    public TR visit(CharLiteral charLit, TP param) {
        throw new InvalidVisitException("Can't visit CharLiteral with " + visitorName);
    }

    @Override
    public TR visit(Comparison comp, TP param) {
        throw new InvalidVisitException("Can't visit Comparison with " + visitorName);
    }

    @Override
    public TR visit(FieldAccessor fieldAccessor, TP param) {
        throw new InvalidVisitException("Can't visit FieldAccessor with " + visitorName);
    }

    @Override
    public TR visit(FunctionInvocation fInvoc, TP param) {
        throw new InvalidVisitException("Can't visit FunctionInvocation with " + visitorName);
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        throw new InvalidVisitException("Can't visit Indexing with " + visitorName);
    }

    @Override
    public TR visit(Logical logical, TP param) {
        throw new InvalidVisitException("Can't visit Logical with " + visitorName);
    }

    @Override
    public TR visit(UnaryMinus uMinus, TP param) {
        throw new InvalidVisitException("Can't visit UnaryMinus with " + visitorName);
    }

    @Override
    public TR visit(UnaryNot uNot, TP param) {
        throw new InvalidVisitException("Can't visit UnaryNot with " + visitorName);
    }

    @Override
    public TR visit(Variable var, TP param) {
        throw new InvalidVisitException("Can't visit Variable with " + visitorName);
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        throw new InvalidVisitException("Can't visit Assignment with " + visitorName);
    }

    @Override
    public TR visit(If ifStmnt, TP param) {
        throw new InvalidVisitException("Can't visit If with " + visitorName);
    }

    @Override
    public TR visit(While whileStmnt, TP param) {
        throw new InvalidVisitException("Can't visit While with " + visitorName);
    }

    @Override
    public TR visit(Invocation invocation, TP param) {
        throw new InvalidVisitException("Can't visit Invocation with " + visitorName);
    }

    @Override
    public TR visit(Read read, TP param) {
        throw new InvalidVisitException("Can't visit Read with " + visitorName);
    }

    @Override
    public TR visit(Return returnStmnt, TP param) {
        throw new InvalidVisitException("Can't visit Return with " + visitorName);
    }

    @Override
    public TR visit(Write write, TP param) {
        throw new InvalidVisitException("Can't visit Write with " + visitorName);
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        throw new InvalidVisitException("Can't visit ArrayType with " + visitorName);
    }

    @Override
    public TR visit(IntType intType, TP param) {
        throw new InvalidVisitException("Can't visit IntType with " + visitorName);
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        throw new InvalidVisitException("Can't visit DoubleType with " + visitorName);
    }

    @Override
    public TR visit(CharType charType, TP param) {
        throw new InvalidVisitException("Can't visit CharType with " + visitorName);
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        throw new InvalidVisitException("Can't visit ErrorType with " + visitorName);
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        throw new InvalidVisitException("Can't visit FunctionType with " + visitorName);
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        throw new InvalidVisitException("Can't visit RecordType with " + visitorName);
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        throw new InvalidVisitException("Can't visit RecordField with " + visitorName);
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        throw new InvalidVisitException("Can't visit VoidType with " + visitorName);
    }
}

