package ast.types;

import errorhandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public String toString() {
		return String.format("%d:%d:%s", getLine(), getColumn(), message);
    }

}

