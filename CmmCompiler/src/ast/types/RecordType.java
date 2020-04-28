package ast.types;

import ast.exps.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecordType extends AbstractType {

    private List<RecordField> recordFields;

    public RecordType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList(recordFields);
        checkRepetitions();
    }

    public List<RecordField> getRecordFields() {
        return new ArrayList<>(recordFields);
    }

    public RecordField getField(String fieldName) {
        for (int i = 0; i < recordFields.size(); i++ ) {
            if (recordFields.get(i).getName().equals(fieldName))
                    return recordFields.get(i);
        }
        return null;
    }

    private void checkRepetitions() {

        LinkedList<Integer> indexesToRemove = new LinkedList<>();

        for ( int i = 0; i < recordFields.size()-1; i++ )
            for ( int j = i+1; j < recordFields.size(); j++ )
                if ( recordFields.get(i).getName().equals(recordFields.get(j).getName())
                    && !indexesToRemove.contains(j)) {
                    RecordField repeated = recordFields.get(j);
                    String message = String.format("Repeated record field name: %s", repeated.getName());
                    repeated.setType(new ErrorType(repeated.getLine(), repeated.getColumn(), message));

                    indexesToRemove.addFirst(j);
                }

        for (Integer index : indexesToRemove) // Removes from highest to lowest
            recordFields.remove(index);

    }

    @Override
    public int nob() {
        int value = 0;
        for (RecordField rf : recordFields) {
            value += rf.getType().nob();
        }
        return value;
    }

    @Override
    public Type access(String field, Expression fieldAccess) {
        if (recordFields.stream().anyMatch(rf -> rf.getName().equals(field)))
            return recordFields.stream().filter(rf -> rf.getName().equals(field))
                    .toArray(RecordField[]::new)[0].getType();
        return new ErrorType(fieldAccess.getLine(), fieldAccess.getColumn(),
                "This expression is a struct but has no field named " + field);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Record" + recordFields;
    }
}

