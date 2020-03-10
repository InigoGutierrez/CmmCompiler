grammar Cmm;	

@header {
    import parser.*;
    import ast.*;
    import ast.defs.*;
    import ast.exps.*;
    import ast.statements.*;
    import ast.types.*;
    import errorhandler.*;

    import java.util.List;
    import java.util.ArrayList;
    import java.util.LinkedList;
}

program returns [Program ast]
    locals [List<Definition> defs = new ArrayList<Definition>()]:
    ( d=definition { for(Definition def : $d.ast) $defs.add(def); } )*
    md=mainDefinition { $defs.add($md.ast); } EOF
    { $ast = new Program(1, 1, $defs);
    if (ErrorHandler.getInstance().anyError())
        ErrorHandler.getInstance().showErrors(System.err); }
    ;

expression returns [Expression ast]:
          '(' e1=expression ')'
          { $ast = $e1.ast; }
          | e1=expression op='[' e2=expression ']'
          { $ast = new Indexing($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $e2.ast); }
          | e1=expression op='.' ID
          { $ast = new FieldAccessor($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $ID.text); }
          | '(' pt=primitiveType ')' e1=expression
          { $ast = new CastExpr($pt.ast.getLine(), $pt.ast.getColumn(), $pt.ast, $e1.ast); }
          | op='-' e1=expression
          { $ast = new UnaryMinus($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast); }
          | e1=expression op=('*' | '/' | '%') e2=expression
          { $ast = new Arithmetic($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $e2.ast, $op.text); }
          | e1=expression op=('+' | '-') e2=expression
          { $ast = new Arithmetic($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $e2.ast, $op.text); }
          | e1=expression op=('==' | '!=' | '>' | '<' | '<=' | '>=') e2=expression
          { $ast = new Comparison($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $e2.ast, $op.text); }
          | op='!' e1=expression
          { $ast = new UnaryNot($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast); }
          | e1=expression op=('&&' | '||') e2=expression
          { $ast = new Logical($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $e2.ast, $op.text); }
          | functionInvocation
          { $ast = $functionInvocation.ast; }
          | INT_CONSTANT { $ast = new IntLiteral($INT_CONSTANT.getLine(),
                $INT_CONSTANT.getCharPositionInLine()+1,
                LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
          | REAL_CONSTANT { $ast = new DoubleLiteral($REAL_CONSTANT.getLine(),
                $REAL_CONSTANT.getCharPositionInLine()+1,
                LexerHelper.lexemeToReal($REAL_CONSTANT.text)); }
          | CHAR_CONSTANT { $ast = new CharLiteral($CHAR_CONSTANT.getLine(),
                $CHAR_CONSTANT.getCharPositionInLine()+1,
                LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
          | variable
          { $ast = $variable.ast; }
          ;

variable returns [Variable ast]:
    ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
    ;


functionInvocation returns [FunctionInvocation ast]:
    ID '(' arguments ')'
    { Variable var = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text);
    $ast = new FunctionInvocation(var.getLine(), var.getColumn(), var, $arguments.ast); }
    ;

arguments returns [List<Expression> ast = new ArrayList<Expression>()]:
    exp1=expression { $ast.add($exp1.ast); }
    ( ',' exp2=expression { $ast.add($exp2.ast); } )*
    |
    ;

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
        e1=expression op='=' e2=expression ';'
        { $ast.add(new Assignment($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $e2.ast)); }
        | ifStatement
        { $ast.add($ifStatement.ast); }
        | whileStatement
        { $ast.add($whileStatement.ast); }
        | 'read' es=expressionSequence ';'
        { for (Expression exp : $es.ast)
            $ast.add(new Read(exp.getLine(), exp.getColumn(), exp)); }
        | 'write' es=expressionSequence ';'
        { for (Expression exp : $es.ast)
            $ast.add(new Write(exp.getLine(), exp.getColumn(), exp)); }
        | fi=functionInvocation ';'
        { $ast.add(new Invocation($fi.ast)); }
        | op='return' e1=expression ';'
        { $ast.add(new Return($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast)); }
    ;

ifStatement returns [If ast]:
    op='if' '(' ex=expression ')' sb=statementBlock
    { $ast = new If($op.getLine(), $op.getCharPositionInLine()+1, $ex.ast, $sb.ast); }
    | op='if' '(' ex=expression ')' sb1=statementBlock 'else' sb2=statementBlock
    { $ast = new If($op.getLine(), $op.getCharPositionInLine()+1, $ex.ast, $sb1.ast, $sb2.ast); }
    ;

whileStatement returns [While ast]:
    op='while' '(' ex=expression ')' sb=statementBlock
    { $ast = new While($op.getLine(), $op.getCharPositionInLine()+1, $ex.ast, $sb.ast); }
    ;

statementBlock returns [List<Statement> ast = new ArrayList<Statement>()]:
    '{' (st1=statement { $ast.addAll($st1.ast); })+ '}'
    | st2=statement { $ast.addAll($st2.ast); }
    ;

expressionSequence returns [List<Expression> ast = new ArrayList<Expression>()]:
    ( e1=expression { $ast.add($e1.ast); } ( ',' e2=expression { $ast.add($e2.ast); } )* )
    ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]:
    vd=varDefinition
    { $ast.addAll($vd.ast); }
    | fd=functionDefinition
    { $ast.add($fd.ast); }
    | md=mainDefinition
    { $ast.add($md.ast); }
    ;

varDefinition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]
    locals[int counter = 0]:
    type id1=ID
    { $ast.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $type.ast, $id1.text, $counter));
        $counter++; }
    (',' id2=ID
    { $ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $type.ast, $id2.text, $counter));
       $counter++; } )* ';'
    ;

functionDefinition returns [FunctionDefinition ast]
    locals [List<VarDefinition> vdefs = new ArrayList<VarDefinition>(),
            List<Statement> stmnts = new ArrayList<Statement>()]:
    rtype=type var=variable '(' ad=argumentsDefinition ')'
    { FunctionType ftype = new FunctionType($var.ast.getLine(), $var.ast.getColumn(), $rtype.ast, $ad.ast); }
    '{' ( vd=varDefinition { $vdefs.addAll($vd.ast); } )*
    (stmnt=statement { $stmnts.addAll($stmnt.ast); } )* '}'
    { $ast = new FunctionDefinition($var.ast.getLine(), $var.ast.getColumn(), ftype, $var.ast.getName(), $vdefs,
        $stmnts); }
    ;

argumentsDefinition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]
    locals[int counter = 0]:
    t1=type id1=ID
    { $ast.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $t1.ast, $id1.text, $counter));
        $counter++; }
    ( ',' t2=type id2=ID
    { $ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $t2.ast, $id2.text, $counter));
        $counter++; }
    )*
    |
    ;

mainDefinition returns [FunctionDefinition ast]
    locals [List<VarDefinition> vdefs = new ArrayList<VarDefinition>(),
            List<Statement> stmnts = new ArrayList<Statement>()]:
    rType='void' name='main' '(' ')'
    '{' ( vd=varDefinition { $vdefs.addAll($vd.ast); } )*
    (stmnt=statement { $stmnts.addAll($stmnt.ast); } )* '}'
    { Variable var = new Variable($name.getLine(), $name.getCharPositionInLine()+1, $name.text); }
    { FunctionType ftype = new FunctionType(var.getLine(), var.getColumn(), new VoidType(
        $rType.getLine(), $rType.getCharPositionInLine()+1), new ArrayList<VarDefinition>()); }
    { $ast = new FunctionDefinition(var.getLine(), var.getColumn(), ftype, var.getName(), $vdefs, $stmnts); }
    ;

type returns [Type ast]
    locals [List<RecordField> rfields = new ArrayList<RecordField>(),
        LinkedList<Integer> arraySizes = new LinkedList<Integer>()]:
    pt=primitiveType { $ast = $pt.ast; }
    | at=type
        { Type result = $at.ast; }
        ( '[' size=INT_CONSTANT ']'
        { $arraySizes.addFirst(LexerHelper.lexemeToInt($size.text)); } )+
        { for (Integer size : $arraySizes)
            result = new Array($at.ast.getLine(), $at.ast.getColumn(), result, size);
          $ast = result; }
    | word='struct' '{' ( rfd=recordFieldDefinition { $rfields.addAll($rfd.ast); } )* '}'
        { $ast = new Record($word.getLine(), $word.getCharPositionInLine()+1, $rfields); }
    | voidType='void' { $ast = new VoidType($voidType.getLine(), $voidType.getCharPositionInLine()+1); }
    ;

primitiveType returns [Type ast]:
    word='int' { $ast = new IntType($word.getLine(), $word.getCharPositionInLine()+1); }
    | word='double' { $ast = new DoubleType($word.getLine(), $word.getCharPositionInLine()+1); }
    | word='char' { $ast = new CharType($word.getLine(), $word.getCharPositionInLine()+1); }
    ;

recordFieldDefinition returns [List<RecordField> ast = new ArrayList<RecordField>()]
    locals[int counter = 0]:
    type id1=ID
    { $ast.add(new RecordField($id1.getLine(), $id1.getCharPositionInLine()+1, $type.ast, $id1.text, $counter));
        $counter++; }
    (',' id2=ID
    { $ast.add(new RecordField($id2.getLine(), $id2.getCharPositionInLine()+1, $type.ast, $id2.text, $counter));
       $counter++; } )* ';'
    ;

BLANK_SPACES: ( [ \t]+ | EOF ) -> skip
            ;

EOL: [\r\n]+ -> skip
   ;

ONE_LINE_COMMENT: '//' .*? (EOL|EOF) -> skip
                ;

MULTILINE_COMMENT: '/*' .*? '*/' -> skip
                 ;

fragment
DECIMAL_PART: [0-9]* [1-9]
            ;

fragment
REAL_NUMBER: INT_CONSTANT? '.' DECIMAL_PART
           | INT_CONSTANT '.' DECIMAL_PART?
           ;

REAL_CONSTANT: REAL_NUMBER
             | (REAL_NUMBER | INT_CONSTANT) [eE] [-+]? INT_CONSTANT
             ;

INT_CONSTANT: [1-9] [0-9]*
            | '0'
            ;

CHAR_CONSTANT: '\'' ~['] '\''
             | '\'' '\\'[nt] '\''
             | '\'' '\\' INT_CONSTANT '\''
             ;

ID: [_a-zA-Z] [_a-zA-Z0-9]*
  ;

