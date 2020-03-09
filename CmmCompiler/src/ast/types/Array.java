package ast.types;

public class Array extends AbstractType {

    Type type;
    int size;

    public Array(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }
}

//int [2][3]
//
//        { type {type int, size 2} , size 3 }
//
//        type { type int, size 3}, size 2 }
