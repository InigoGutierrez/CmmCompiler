package ast.types;

import ast.AbstractASTNode;
import ast.exps.Expression;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

	@Override
	public int nob() {
		return 0;
	}

	public Type cast(Type castedTo, Expression cast) {
		return new ErrorType(cast.getLine(), cast.getColumn(),
				"Can't cast " + this + " to " + castedTo);
	}

    public Type negate(Expression unaryNot) {
		return new ErrorType(unaryNot.getLine(), unaryNot.getColumn(),
				"Can't negate " + this);
	}

    public Type compare(Type other, Expression comparison) {
		return new ErrorType(comparison.getLine(), comparison.getColumn(),
				"Can't compare " + this + " to " + other);
	}

    public Type logical(Type other, Expression logical) {
		return new ErrorType(logical.getLine(), logical.getColumn(),
				"Can't make a logical operation with " + this + " and " + other);
	}

    public Type access(String field, Expression fieldAccess) {
		return new ErrorType(fieldAccess.getLine(), fieldAccess.getColumn(),
				"Can't access a field of " + this);
	}

    public Type indexing(Type indexType, Expression indexing) {
		return new ErrorType(indexing.getLine(), indexing.getColumn(),
				"Can't index " + this);
	}

    public Type arithmetic(Type other, Expression arithmetic) {
		return new ErrorType(arithmetic.getLine(), arithmetic.getColumn(),
				"Can't make an arithmetic operation with " + this + " and " + other);
	}

    public Type minus(Expression unaryMinus) {
		return new ErrorType(unaryMinus.getLine(), unaryMinus.getColumn(),
				"Can't apply a minus to " + this);
	}

    public Type parenthesis(Type[] argTypes, Expression funcInvocation) {
		return new ErrorType(funcInvocation.getLine(), funcInvocation.getColumn(),
				"Can't invoke this with these arguments");
	}

	@Override
	public boolean isBuiltin() {
		return false;
	}

	public boolean canAssign(Type valueType) {
    	return false;
	}

    public boolean isBoolean() {
		return false;
	}

    public boolean canReturn(Type typeToReturn) {
		return false;
	}

}

