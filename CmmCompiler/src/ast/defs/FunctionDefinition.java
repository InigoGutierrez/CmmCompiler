package ast.defs;

import java.util.ArrayList;
import java.util.List;

import ast.exps.Variable;
import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

public class FunctionDefinition extends AbstractDefinition {

    private List<VarDefinition> varDefs;
    private List<Statement> statements;

    public FunctionDefinition(int line, int column, Type type, String name, List<VarDefinition> varDefs,
                              List<Statement> statements) {
        super(line, column, name, type);
        this.varDefs = new ArrayList<>(varDefs);
        this.statements = new ArrayList<>(statements);
    }

    public List<VarDefinition> getVarDefs() {
        return new ArrayList<>(varDefs);
    }

    public List<Statement> getStatements() {
        return new ArrayList<>(statements);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionDefinition{" +
                "name='" + getName() + '\'' +
                ", type=" + getType() +
                '}';
    }
}

