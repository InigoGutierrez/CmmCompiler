package codegeneration;

public class ValueCGVisitor {

    // Code templates

    // IntLiteral
    /*
    value[[IntLiteral: intLiteral -> ID]] =
        <pushi> + intLiteral.getValue();
     */

    // DoubleLiteral
    /*
    value[[DoubleLiteral: doubleLiteral -> ID]] =
        <pushf> + doubleLiteral.getValue();
     */

    // CharLiteral
    /*
    value[[CharLiteral: charLiteral -> ID]] =
        <pushb> + charLiteral.getValue();
     */

    // Arithmetic
    /*
    value[[Arithmetic: arithmetic -> exp1 (+|-|*|/) exp2]] =
        value[[exp1]];
        value[[exp2]];
        switch arithmetic.getOperation() {
            case "+":
                <add> + arithmetic.getType().suffix();
                break;
            case "-":
                <sub> + arithmetic.getType().suffix();
                break;
            case "*":
                <mul> + arithmetic.getType().suffix();
                break;
            case "/":
                <div> + arithmetic.getType().suffix();
                break;
      }
     */

    // Comparison
    /*
    value[[Comparison: comparison -> exp1 (==|!=|<|>|<=|>=) exp2]] =
    value[[exp1]];
    value[[exp2]];
        switch comparison.getOperation() {
        case "==":
            <eq> + comparison.getType().suffix();
            break;
        case "!=":
            <ne> + comparison.getType().suffix();
            break;
        case "<":
            <lt> + comparison.getType().suffix();
            break;
        case ">":
            <gt> + comparison.getType().suffix();
            break;
        case "<=":
            <le> + comparison.getType().suffix();
            break;
        case "=>":
            <gt> + comparison.getType().suffix();
            break;
    }
    */

    // Logical
    /*
    value[[Logical: logical -> exp1 (==|!=|<|>|<=|>=) exp2]] =
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

}

