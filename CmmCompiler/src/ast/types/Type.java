package ast.types;

import ast.ASTNode;
import ast.exps.Expression;

public interface Type extends ASTNode {
    Type cast(Type castedTo, Expression cast);
    Type negate(Expression unaryNot);
    Type compare(Type other, Expression comparison);
    Type logical(Type other, Expression logical);
    Type access(String field, Expression fieldAccess);
    Type indexing(Type indexType, Expression indexing);
    Type arithmetic(Type other, Expression arithmetic);
    Type minus(Expression unaryMinus);
    Type parenthesis(Type[] argTypes, Expression funcInvocation);
    boolean canAssign(Type valueType);
    boolean isBoolean();
    boolean canReturn(Type typeToReturn);
    int nob();
}

