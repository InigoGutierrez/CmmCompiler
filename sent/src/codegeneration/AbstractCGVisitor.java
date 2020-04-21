package codegeneration;

import ast.Program;
import ast.defs.FunctionDefinition;
import ast.defs.VarDefinition;
import ast.exps.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    private String visitorName;

    @Override
    public TR visit(Program program, TP param) {
        return null;
    }

    @Override
    public TR visit(VarDefinition vDef, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionDefinition fDef, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic arith, TP param) {
        return null;
    }

    @Override
    public TR visit(CastExpr castExpr, TP param) {
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
        return null;
    }

    @Override
    public TR visit(FieldAccessor fieldAccessor, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionInvocation fInvoc, TP param) {
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus uMinus, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryNot uNot, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable var, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        return null;
    }

    @Override
    public TR visit(If ifStmnt, TP param) {
        return null;
    }

    @Override
    public TR visit(While whileStmnt, TP param) {
        return null;
    }

    @Override
    public TR visit(Invocation invocation, TP param) {
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        return null;
    }

    @Override
    public TR visit(Return returnStmnt, TP param) {
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
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
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}

