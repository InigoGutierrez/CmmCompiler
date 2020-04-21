package codegeneration;

import ast.defs.VarDefinition;
import ast.exps.CharLiteral;
import ast.exps.DoubleLiteral;
import ast.exps.IntLiteral;
import ast.exps.Variable;
import ast.types.Type;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeGenerator {

    private FileWriter outputFile;
    private String identation;

    public CodeGenerator(String outputFile) throws IOException {
        this.outputFile = new FileWriter(outputFile);
        identation = "";
    }

    public void incScope() {
        identation += "  ";
    }

    public void decScope() {
        identation = identation.substring(0, identation.length()-2);
    }

    public void close() {
        try {
            outputFile.close();
        } catch (IOException e) {
            System.err.println("[ERROR] There was an error while closing the FileWriter to the output file:");
            e.printStackTrace();
        }
    }

    public void pushBP() {
        writeCode("push bp");
    }

    public void push(int value) {
        writeCode("pushi " + value);
    }

    public void push(char value) {
        writeCode("pushb " + (int)value);
    }

    public void push(double value) {
        writeCode("pushf " + value);
    }

    public void in(Type type) {
        writeCode("in" + type.suffix());
    }

    public void out(Type type) {
        writeCode("out" + type.suffix());
    }

    public void store(Type type) {
        writeCode("store" + type.suffix());
    }

    public void load(Type type) {
        writeCode("load" + type.suffix());
    }

    public void call(String name) {
        writeCode("call " + name);
    }

    public void halt() {
        writeCode("halt");
    }

    public void varDefinition(VarDefinition vDef) {
        writeCode(String.format(
                "' * %s %s (offset %d)",
                vDef.getType().toString(),
                vDef.getName(),
                vDef.getOffset()));
    }

    public void functionName(String name) {
        writeCode(" " + name + ":");
    }

    public void parameters(List<VarDefinition> params) {
        writeCode("' * Parameters");
        params.forEach( (p) -> varDefinition(p) );
    }

    public void localVariables(List<VarDefinition> localVars) {
        writeCode("' * Local variables");
        localVars.forEach( (p) -> varDefinition(p) );
    }

    public void enter(int bytes) {
        writeCode("enter " + bytes);
    }

    public void intLiteral(IntLiteral intLit) {
        push(intLit.getValue());
    }

    public void doubleLiteral(DoubleLiteral doubleLit) {
        push(doubleLit.getValue());
    }

    public void charLiteral(CharLiteral charLit) {
        push(charLit.getValue());
    }

    public void arithmetic(String operator, Type type) {
        String instruction = "";
        switch (operator) {
            case "+":
                instruction = "add";
                break;
            case "-":
                instruction = "sub";
                break;
            case "*":
                instruction = "mul";
                break;
            case "/":
                instruction = "div";
                break;
            case "%":
                instruction = "mod";
                break;
            default:
                throw new IllegalArgumentException("[ERROR] Not a valid arithmetic operator: " + operator);
        }
        writeCode(instruction + type.suffix());
    }

    public void comparison(String operator, Type type) {
        String instruction = "";
        switch (operator) {
            case "==":
                instruction = "eq";
                break;
            case "!=":
                instruction = "ne";
                break;
            case "<":
                instruction = "lt";
                break;
            case ">":
                instruction = "gt";
                break;
            case "<=":
                instruction = "le";
                break;
            case ">=":
                instruction = "ge";
                break;
            default:
                throw new IllegalArgumentException("[ERROR] Not a valid comparison operator: " + operator);
        }
        writeCode(instruction + type.suffix());
    }

    public void logical(String operator) {
        String instruction = "";
        switch (operator) {
            case "&&":
                instruction = "and";
                break;
            case "||":
                instruction = "or";
                break;
            default:
                throw new IllegalArgumentException("[ERROR] Not a valid logical operator: " + operator);
        }
        writeCode(instruction);
    }

    public void not() {
        writeCode("not");
    }

    public void variableAddress(Variable var, int scope) {
        int offset = ((VarDefinition) var.getDefinition()).getOffset();
        if (var.getDefinition().getScope() == 0)
            writeCode("pusha " + offset);
        else {
            pushBP();
            push(offset);
            writeCode("addi");
        }
    }

    public void convert(Type source, Type target) {
        String code = source.convertTo(target);
        if (code.equals(""))
            return;
        writeCode(code.replaceAll("\n", "\n" + identation));
    }

    public void commentWriteStart() {
        writeCode("' * Write");
    }

    public void commentReadStart() {
        writeCode("' * Read");
    }

    public void writeCode(String code) {
        try {
            outputFile.write(identation + code + "\n");
            outputFile.flush();
        } catch (IOException e) {
            System.err.println("[ERROR] There was an error while writing the output file:");
            e.printStackTrace();
        }
    }

}

