package ast;

import ast.defs.Definition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> defs;

    public Program(int line, int column, List<Definition> defs) {
        super(line, column);
        this.defs = new ArrayList(defs);
    }

    public List<Definition> getDefs() {
        return new ArrayList<>(defs);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
    
}

