package ast.types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Record extends AbstractType {

    List<RecordField> recordFields;

    public Record(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList(recordFields);
        checkRepetitions();
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
}

