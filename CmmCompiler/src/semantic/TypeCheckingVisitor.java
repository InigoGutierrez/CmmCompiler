package semantic;

import ast.exps.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(Arithmetic arith, Void param) {
        arith.getExpA().accept(this, param);
        arith.getExpB().accept(this, param);
        arith.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CastExpr castExpr, Void param) {
        castExpr.getTargetType().accept(this, param);
        castExpr.getCasted().accept(this, param);
        castExpr.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLit, Void param) {
        intLit.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLit, Void param) {
        doubleLit.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLit, Void param) {
        charLit.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparison comp, Void param) {
        comp.getExpA().accept(this, param);
        comp.getExpB().accept(this, param);
        comp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccessor fieldAccessor, Void param) {
        fieldAccessor.getAccessed().accept(this, param);
        fieldAccessor.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation fInvoc, Void param) {
        fInvoc.getVar().accept(this, param);
        fInvoc.getArguments().forEach(a -> a.accept(this, param));
        fInvoc.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getIndexed().accept(this, param);
        indexing.getIndex().accept(this, param);
        indexing.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getExpA().accept(this, param);
        logical.getExpB().accept(this, param);
        logical.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus uMinus, Void param) {
        uMinus.getExp().accept(this, param);
        uMinus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot uNot, Void param) {
        uNot.getExpToNegate().accept(this, param);
        uNot.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable var, Void param) {
        var.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.getAssigned().accept(this, null);
        assignment.getValue().accept(this, null);
        if (!assignment.getAssigned().getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(),
                    String.format("Lvalue required at %d:%d.", assignment.getLine(), assignment.getColumn()));
        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
        read.getExp().accept(this, param);
        if (!read.getExp().getLvalue())
            new ErrorType(read.getLine(), read.getColumn(),
                    String.format("Lvalue required at %d:%d.", read.getLine(), read.getColumn()));
        return null;
    }

}

