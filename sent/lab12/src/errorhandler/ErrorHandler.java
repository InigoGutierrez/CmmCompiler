package errorhandler;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import ast.types.ErrorType;

public class ErrorHandler {

    private static ErrorHandler instance;
    private List<ErrorType> errors;

    private ErrorHandler() {
        errors = new LinkedList();
    }

    public static ErrorHandler getInstance() {
        if (instance == null)
            instance = new ErrorHandler();
        return instance;

    }

    public void addError(ErrorType error) {
        errors.add(error);
    }

    public boolean anyError() {
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream stream) {
        for (ErrorType error : errors)
            stream.println(error.toString());
    }
}
