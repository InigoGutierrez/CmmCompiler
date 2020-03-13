package ast.types;

import visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Record extends AbstractType {

    private List<RecordField> recordFields;

    public Record(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList(recordFields);
        checkRepetitions();
    }

    public List<RecordField> getRecordFields() {
        return new ArrayList<>(recordFields);
    }

    private void checkRepetitions() {

        LinkedList<Integer> indexesToRemove = new LinkedList<>();

        for ( int i = 0; i < recordFields.size()-1; i++ )
            for ( int j = i+1; j < recordFields.size(); j++ )
                if ( recordFields.get(i).getName().equals(recordFields.get(j).getName())
                    && !indexesToRemove.contains(j)) {
                    RecordField repeated = recordFields.get(j);
                    StringBuilder message = new StringBuilder();
                    message.append("Repeated record field name at ")
                            .append(repeated.getLine())
                            .append(":")
                            .append(repeated.getColumn())
                            .append(": ")
                            .append(repeated.getName());
                    repeated.setType(new ErrorType(repeated.getLine(), repeated.getColumn(), message.toString()));

                    indexesToRemove.addFirst(j);
                }

        for (Integer index : indexesToRemove) // Removes from highest to lowest
            recordFields.remove(index);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordFields=" + recordFields +
                '}';
    }
}
