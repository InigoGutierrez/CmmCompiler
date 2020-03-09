package ast;

import ast.defs.Definition;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> defs;

    public Program(int line, int column, List<Definition> defs) {
        super(line, column);
        this.defs = new ArrayList(defs);
    }
}

