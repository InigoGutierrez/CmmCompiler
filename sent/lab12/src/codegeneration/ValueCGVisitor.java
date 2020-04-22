package codegeneration;

import ast.exps.*;

public class ValueCGVisitor extends AbstractCGVisitor<CodeGenerator, Void> {

    public ValueCGVisitor() {
        setVisitorName("ValueCGVisitor");
    }

    // IntLiteral
    /*
    value[[IntLiteral: exp -> ID]] =
        <pushi> exp.getValue();
     */
    @Override
    public Void visit(IntLiteral intLit, CodeGenerator cg) {
        cg.intLiteral(intLit);
        return null;
    }

    // DoubleLiteral
    /*
    value[[DoubleLiteral: exp -> ID]] =
        <pushf> exp.getValue();
     */
    @Override
    public Void visit(DoubleLiteral doubleLit, CodeGenerator cg) {
        cg.doubleLiteral(doubleLit);
        return null;
    }

    // CharLiteral
    /*
    value[[CharLiteral: exp -> ID]] =
        <pushb> exp.getValue();
     */
    @Override
    public Void visit(CharLiteral charLit, CodeGenerator cg) {
        cg.charLiteral(charLit);
        return null;
    }

    // Variable
    /*
    value[[Variable: exp -> ID]] =
        address[[exp]];
        <load> + exp.getType().suffix();
     */
    @Override
    public Void visit(Variable var, CodeGenerator cg) {
        var.accept(new AddressCGVisitor(), cg);
        cg.load(var.getType());
        return null;
    }

    // Arithmetic
    /*
    value[[Arithmetic: exp1 -> exp2 (+|-|*|/) exp3]] =
        value[[exp2]];
        value[[exp3]];
        switch exp1.getOperation() {
            case "+":
                <add> exp1.getType().suffix();
                break;
            case "-":
                <sub> exp1.getType().suffix();
                break;
            case "*":
                <mul> exp1.getType().suffix();
                break;
            case "/":
                <div> exp1.getType().suffix();
                break;
            case "%":
                <mod> exp1.getType().suffix();
                break;
      }
     */
    @Override
    public Void visit(Arithmetic arith, CodeGenerator cg) {

        arith.getExpA().accept(this, cg);
        cg.convert(arith.getExpA().getType(), arith.getType());

        arith.getExpB().accept(this, cg);
        cg.convert(arith.getExpB().getType(), arith.getType());

        cg.arithmetic(arith.getOperation(), arith.getType());

        return null;
    }

    // Comparison
    /*
    value[[Comparison: exp1 -> exp2 (==|!=|<|>|<=|>=) exp3]] =
    value[[exp2]];
    value[[exp3]];
        switch exp1.getOperation() {
        case "==":
            <eq> exp1.getType().suffix();
            break;
        case "!=":
            <ne> exp1.getType().suffix();
            break;
        case "<":
            <lt> exp1.getType().suffix();
            break;
        case ">":
            <gt> exp1.getType().suffix();
            break;
        case "<=":
            <le> exp1.getType().suffix();
            break;
        case ">=":
            <gt> exp1.getType().suffix();
            break;
    }
    */
    @Override
    public Void visit(Comparison comparison, CodeGenerator cg) {
        comparison.getExpA().accept(this, cg);
        comparison.getExpB().accept(this, cg);
        cg.comparison(comparison.getOperation(), comparison.getType());
        return null;
    }

    // Logical
    /*
    value[[Logical: exp1 -> exp2 ( && | \|\| ) exp3]] =
    value[[exp2]];
    value[[exp3]];
        switch exp1.getOperation() {
        case "&&":
            <and>;
            break;
        case "||":
            <or>;
            break;
    }
    */
    @Override
    public Void visit(Logical logical, CodeGenerator cg) {
        logical.getExpA().accept(this, cg);
        logical.getExpB().accept(this, cg);
        cg.logical(logical.getOperation());
        return null;
    }

    // Cast
    /*
    value[[CastExpr: exp1 -> type exp2]] =
        value[[exp2]];
        exp2.getType().convertTo(type);
    */
    @Override
    public Void visit(CastExpr castExpr, CodeGenerator cg) {
        castExpr.getCasted().accept(this, cg);
        cg.convert(castExpr.getCasted().getType(), castExpr.getTargetType());
        return null;
    }

    // UnaryNot
    /*
    value[[UnaryNot: exp1 -> exp2]] =
        value[[exp]];
        <not>
     */
    @Override
    public Void visit(UnaryNot uNot, CodeGenerator cg) {
        uNot.getExpToNegate().accept(this, cg);
        cg.not();
        return null;
    }

    // FieldAccessor
    /*
    value[[FieldAccessor: exp1 -> exp2 ID]] =
        address[[exp1]];
        <load> exp1.getType().suffix();
     */
    @Override
    public Void visit(FieldAccessor fieldAccessor, CodeGenerator cg) {
        fieldAccessor.accept(new AddressCGVisitor(), cg);
        cg.load(fieldAccessor.getType());
        return null;
    }

    // Indexing
    /*
    value[Indexing: exp1 -> exp2 exp3]] =
        address[[exp1]];
        <load> exp1.getType().suffix();
     */
    @Override
    public Void visit(Indexing indexing, CodeGenerator cg) {
        indexing.accept(new AddressCGVisitor(), cg);
        cg.load(indexing.getType());
        return null;
    }

    // FunctionInvocation
    /* FunctionInvocation: exp1 -> exp2 exp3*]] =
        exp3*.foreach( (arg) -> value[[arg]] );
        <call > exp2.getName();
     */
    @Override
    public Void visit(FunctionInvocation fInvoc, CodeGenerator cg) {
        fInvoc.getArguments().forEach( (arg) -> arg.accept(this, cg) );
        cg.call(fInvoc.getVar().getName());
        return null;
    }

}

