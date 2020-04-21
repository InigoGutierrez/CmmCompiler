package codegeneration;

import ast.exps.*;
import ast.types.CharType;

public class ValueCGVisitor extends AbstractCGVisitor<CodeGenerator, Void> {

    public ValueCGVisitor() {
        setVisitorName("ValueCGVisitor");
    }

    // IntLiteral
    /*
    value[[IntLiteral: intLiteral -> ID]]:
        <pushi> intLiteral.getValue();
     */
    @Override
    public Void visit(IntLiteral intLit, CodeGenerator cg) {
        cg.intLiteral(intLit);
        return null;
    }

    // DoubleLiteral
    /*
    value[[DoubleLiteral: doubleLiteral -> ID]]:
        <pushf> doubleLiteral.getValue();
     */
    @Override
    public Void visit(DoubleLiteral doubleLit, CodeGenerator cg) {
        cg.doubleLiteral(doubleLit);
        return null;
    }

    // CharLiteral
    /*
    value[[CharLiteral: charLiteral -> ID]]:
        <pushb> charLiteral.getValue();
     */
    @Override
    public Void visit(CharLiteral charLit, CodeGenerator cg) {
        cg.charLiteral(charLit);
        return null;
    }

    // Variable
    /*
    value[[Variable: var -> ID]]:
        address[[var]];
        <load> + var.getType.suffix();
     */
    @Override
    public Void visit(Variable var, CodeGenerator cg) {
        var.accept(new AddressCGVisitor(), cg);
        cg.load(var.getType());
        return null;
    }

    // Arithmetic
    /*
    value[[Arithmetic: arithmetic -> exp1 (+|-|*|/) exp2]]:
        value[[exp1]];
        value[[exp2]];
        switch arithmetic.getOperation() {
            case "+":
                <add> arithmetic.getType().suffix();
                break;
            case "-":
                <sub> arithmetic.getType().suffix();
                break;
            case "*":
                <mul> arithmetic.getType().suffix();
                break;
            case "/":
                <div> arithmetic.getType().suffix();
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
    value[[Comparison: comparison -> exp1 (==|!=|<|>|<=|>=) exp2]] =
    value[[exp1]];
    value[[exp2]];
        switch comparison.getOperation() {
        case "==":
            <eq> comparison.getType().suffix();
            break;
        case "!=":
            <ne> comparison.getType().suffix();
            break;
        case "<":
            <lt> comparison.getType().suffix();
            break;
        case ">":
            <gt> comparison.getType().suffix();
            break;
        case "<=":
            <le> comparison.getType().suffix();
            break;
        case ">=":
            <gt> comparison.getType().suffix();
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
    value[[Logical: logical -> exp1 ( && | \|\| ) exp2]]:
    value[[exp1]];
    value[[exp2]];
        switch logical.getOperation() {
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
    value[[CastExpr: cast -> type exp]]:
        value[[exp]];
        exp.getType().convertTo(type);
    */
    @Override
    public Void visit(CastExpr castExpr, CodeGenerator cg) {
        castExpr.getCasted().accept(this, cg);
        cg.convert(castExpr.getCasted().getType(), castExpr.getTargetType());
        return null;
    }

    // UnaryNot
    /*
    value[[UnaryNot: unaryNot -> exp]]:
        value[[exp]];
        <not>
     */
    @Override
    public Void visit(UnaryNot uNot, CodeGenerator cg) {
        uNot.getExpToNegate().accept(this, cg);
        cg.not();
        return null;
    }
}

