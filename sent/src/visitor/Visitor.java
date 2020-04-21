package visitor;

import ast.Program;
import ast.defs.*;
import ast.exps.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP, TR> {

    public TR visit(Program program, TP param);
    public TR visit(VarDefinition vDef, TP param);
    public TR visit(FunctionDefinition fDef, TP param);
    public TR visit(Arithmetic arith, TP param);
    public TR visit(CastExpr castExpr, TP param);
    public TR visit(IntLiteral intLit, TP param);
    public TR visit(DoubleLiteral doubleLit, TP param);
    public TR visit(CharLiteral charLit, TP param);
    public TR visit(Comparison comp, TP param);
    public TR visit(FieldAccessor fieldAccessor, TP param);
    public TR visit(FunctionInvocation fInvoc, TP param);
    public TR visit(Indexing indexing, TP param);
    public TR visit(Logical logical, TP param);
    public TR visit(UnaryMinus uMinus, TP param);
    public TR visit(UnaryNot uNot, TP param);
    public TR visit(Variable var, TP param);
    public TR visit(Assignment assignment, TP param);
    public TR visit(If ifStmnt, TP param);
    public TR visit(While whileStmnt, TP param);
    public TR visit(Invocation invocation, TP param);
    public TR visit(Read read, TP param);
    public TR visit(Return returnStmnt, TP param);
    public TR visit(Write write, TP param);
    public TR visit(ArrayType arrayType, TP param);
    public TR visit(IntType intType, TP param);
    public TR visit(DoubleType doubleType, TP param);
    public TR visit(CharType charType, TP param);
    public TR visit(ErrorType errorType, TP param);
    public TR visit(FunctionType functionType, TP param);
    public TR visit(RecordType recordType, TP param);
    public TR visit(RecordField recordField, TP param);
    public TR visit(VoidType voidType, TP param);
}
