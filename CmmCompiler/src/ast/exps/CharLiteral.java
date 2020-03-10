package ast.exps;

import ast.AbstractASTNode;

public class CharLiteral extends AbstractASTNode implements Expression {

        private char value;

        public CharLiteral(int line, int column, char value) {
            super(line, column);
            this.value = value;
        }

    @Override
    public String toString() {
        return "CharLiteral{" +
                "value=" + value +
                '}';
    }
}
