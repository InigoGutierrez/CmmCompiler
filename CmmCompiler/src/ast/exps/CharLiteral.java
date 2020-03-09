package ast.exps;

import ast.AbstractASTNode;

public class CharLiteral extends AbstractASTNode implements Expression {

        char value;

        public CharLiteral(int line, int column, char value) {
            super(line, column);
            this.value = value;
        }

}
