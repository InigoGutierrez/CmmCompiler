# DLP Lab 9

OffsetVisitor extends AbstractVisitor<Void, Void> }
  @Override
  Void visit(RecordType rt, Void param) {
    this.super(rt, param);
    int fieldBytesSum = 0;
    for (RecordField rf: rt.fields) {
      rf.setOffset(fieldBytesSum);
      fieldBytesSum += rf.getType().numberOfBytes();
      rf.getType().accept(this, null);
      // rf.getType().accept(this, null);
    }
    return null;
  }
}

Implement the type checking pass of the semantic analysis phase.
Annotate the AST with all the type information.
Detect the type errors in the 5 input files provided.

Implement it in TypeCheckingVisitor. Check any error the compiler must detect.

Check assignments.

Check accessed attributes exist in field accessor.

write i && f; - Logical operations: can't interpret doubles as boolean.

write a >= 3; - Struct can not be compared.

while, if, negate: expression must be int

Check return type of functions; returned and return type should be the same.

Can't index non-arrays.

Arithmetic: exp1 -> exp2 (+|-|*|/) exp3
R: exp1.type = exp2.type.arithmetic(exp3.type, exp1) // exp1 to get line and col

Indexing: exp1 -> exp2 exp3
R: exp1.type = exp2.type.indexing(exp3.type, exp1) // exp3.type to check errors

FuncInvocation: exp1 -> exp2 exp3*
R: exp1.type = exp2.type.parenthesis(exp3.stream().map(e -> e.type).toArray(Type[]::new), exp1) // exp3.type to check errors

WhileStmnt: stmnt1 -> exp stmnt2*
R: if (!exp.type.isBoolean())
    new ErrorType(exp.line, exp.column, "Type " + exp.type + " is not Boolean.");

