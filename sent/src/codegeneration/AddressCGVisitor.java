package codegeneration;

public class AddressCGVisitor {

    // Code templates

    // Variable
    /*
    address[[Variable: variable -> ID]] =
        if (variable.getDefinition().getScope() != 0) {
            <push> + BP;
        }
        <pushi> + variable.getDefinition().getOffset(); // In current AST, offset not accesible directly from definition
        <load> + variable.getDefinition().getSuffix();
        }
     */

}

