package ast.exps;

import ast.AbstractASTNode;
import visitor.Visitor;

public class CharLiteral extends AbstractExpression {

        private char value;

        public CharLiteral(int line, int column, char value) {
            super(line, column);
            this.value = value;
        }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "CharLiteral{" +
                "value=" + value +
                '}';
    }
}
