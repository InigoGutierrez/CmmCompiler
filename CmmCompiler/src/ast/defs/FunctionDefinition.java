package ast.defs;

import java.util.ArrayList;
import java.util.List;

import ast.exps.Variable;
import ast.statements.Statement;
import ast.types.Type;

public class FunctionDefinition extends AbstractDefinition {

    private String name;
    private List<VarDefinition> varDefs;
    private List<Statement> statements;

    public FunctionDefinition(int line, int column, Type type, String name, List<VarDefinition> varDefs,
                              List<Statement> statements) {
        super(line, column, type);
        this.name = name;
        this.varDefs = new ArrayList<>(varDefs);
        this.statements = new ArrayList<>(statements);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FunctionDefinition{" +
                "name='" + name + '\'' +
                ", type=" + getType() +
                '}';
    }
}

