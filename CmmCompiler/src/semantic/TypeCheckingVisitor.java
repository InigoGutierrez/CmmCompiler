package semantic;

import ast.defs.FunctionDefinition;
import ast.exps.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    @Override
    public Void visit(Arithmetic arith, Type param) {
        arith.getExpA().accept(this, param);
        arith.getExpB().accept(this, param);
        arith.setLvalue(false);
        Type typeA = arith.getExpA().getType();
        Type typeB = arith.getExpB().getType();
        arith.setType(typeA.arithmetic(typeB, arith));
        return null;
    }

    @Override
    public Void visit(CastExpr castExpr, Type param) {
        castExpr.getTargetType().accept(this, param);
        castExpr.getCasted().accept(this, param);
        castExpr.setLvalue(false);
        Type castedType = castExpr.getCasted().getType();
        Type targetType = castExpr.getTargetType();
        castExpr.setType(castedType.cast(targetType, castExpr));
        return null;
    }

    @Override
    public Void visit(IntLiteral intLit, Type param) {
        intLit.setLvalue(false);
        intLit.setType(new IntType(intLit.getLine(), intLit.getColumn()));
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLit, Type param) {
        doubleLit.setLvalue(false);
        doubleLit.setType(new DoubleType(doubleLit.getLine(), doubleLit.getColumn()));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLit, Type param) {
        charLit.setLvalue(false);
        charLit.setType(new CharType(charLit.getLine(), charLit.getColumn()));
        return null;
    }

    @Override
    public Void visit(Comparison comp, Type param) {
        comp.getExpA().accept(this, param);
        comp.getExpB().accept(this, param);
        comp.setLvalue(false);
        Type typeA = comp.getExpA().getType();
        Type typeB = comp.getExpB().getType();
        comp.setType(typeA.compare(typeB, comp));
        return null;
    }

    @Override
    public Void visit(FieldAccessor fieldAccessor, Type param) {
        fieldAccessor.getAccessed().accept(this, param);
        fieldAccessor.setLvalue(true);
        Type accessedType = fieldAccessor.getAccessed().getType();
        String field = fieldAccessor.getField();
        fieldAccessor.setType(accessedType.access(field, fieldAccessor));
        return null;
    }

    @Override
    public Void visit(FunctionInvocation fInvoc, Type param) {
        fInvoc.getVar().accept(this, param);
        fInvoc.getArguments().forEach(a -> a.accept(this, param));
        fInvoc.setLvalue(false);
        Type fType = fInvoc.getVar().getType();
        Type[] argTypes = fInvoc.getArguments().stream().map(arg -> arg.getType()).toArray(Type[]::new);
        fInvoc.setType(fType.parenthesis(argTypes, fInvoc));
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type param) {
        indexing.getIndexed().accept(this, param);
        indexing.getIndex().accept(this, param);
        indexing.setLvalue(true);
        Type indexedType = indexing.getIndexed().getType();
        Type indexType = indexing.getIndex().getType();
        indexing.setType(indexedType.indexing(indexType, indexing));
        return null;
    }

    @Override
    public Void visit(Logical logical, Type param) {
        logical.getExpA().accept(this, param);
        logical.getExpB().accept(this, param);
        logical.setLvalue(false);
        Type typeA = logical.getExpA().getType();
        Type typeB = logical.getExpB().getType();
        logical.setType(typeA.logical(typeB, logical));
        return null;
    }

    @Override
    public Void visit(UnaryMinus uMinus, Type param) {
        uMinus.getExp().accept(this, param);
        uMinus.setLvalue(false);
        uMinus.setType(uMinus.getExp().getType().minus(uMinus));
        return null;
    }

    @Override
    public Void visit(UnaryNot uNot, Type param) {
        uNot.getExpToNegate().accept(this, param);
        uNot.setLvalue(false);
        uNot.setType(uNot.getExpToNegate().getType().negate(uNot));
        return null;
    }

    @Override
    public Void visit(Variable var, Type param) {
        var.setLvalue(true);
        var.setType(var.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Type param) {
        assignment.getAssigned().accept(this, null);
        assignment.getValue().accept(this, null);

        if (!assignment.getAssigned().getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(),
                    String.format("Lvalue required."));

        Type assignedType = assignment.getAssigned().getType();
        Type valueType = assignment.getValue().getType();
        if ( !assignedType.canAssign(valueType)
            && !(assignedType instanceof ErrorType)
            && !(valueType instanceof ErrorType) ) {
            new ErrorType(assignment.getLine(), assignment.getColumn(),
                    "Can't assign " + valueType + " to " + assignedType);
        }

        return null;
    }

    @Override
    public Void visit(Read read, Type param) {
        read.getExp().accept(this, param);
        if (!read.getExp().getLvalue())
            new ErrorType(read.getLine(), read.getColumn(),
                    String.format("Lvalue required"));
        return null;
    }

    @Override
    public Void visit(If ifStmnt, Type param) {
        super.visit(ifStmnt, param);
        if (!ifStmnt.getCondition().getType().isBoolean()) {
            new ErrorType(ifStmnt.getCondition().getLine(), ifStmnt.getCondition().getColumn(),
                    "Condition is not boolean");
        }
        return null;
    }

    @Override
    public Void visit(While whileStmnt, Type param) {
        super.visit(whileStmnt, param);
        if (!whileStmnt.getCondition().getType().isBoolean()) {
            new ErrorType(whileStmnt.getCondition().getLine(), whileStmnt.getCondition().getColumn(),
                    "Condition is not boolean");
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fDef, Type param) {
        return super.visit(fDef, ((FunctionType) fDef.getType()).getReturnType());
    }

    @Override
    public Void visit(Return returnStmnt, Type param) {
        super.visit(returnStmnt, param);
        if (!param.canReturn(returnStmnt.getExp().getType())) {
            new ErrorType(returnStmnt.getExp().getLine(), returnStmnt.getExp().getColumn(),
                    "Can't return type " + returnStmnt.getExp().getType() + ", should be " + param);
        }
        return null;
    }

}

