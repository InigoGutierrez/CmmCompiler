package codegeneration;

import ast.defs.VarDefinition;
import ast.exps.CharLiteral;
import ast.exps.DoubleLiteral;
import ast.exps.IntLiteral;
import ast.exps.Variable;
import ast.types.Type;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    private FileWriter outputFile;
    private String indentation;
    private int labelIndex;

    public CodeGenerator(String outputFile) throws IOException {
        this.outputFile = new FileWriter(outputFile);
        indentation = "";
        labelIndex = 0;
    }

    public void incScope() {
        indentation += "    ";
    }

    public void decScope() {
        indentation = indentation.substring(0, indentation.length()-4);
    }

    public int getLabel(int quantity) {
        int valueToReturn = labelIndex;
        labelIndex += quantity;
        return valueToReturn;
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

    public void push(Type type, int value) {
        writeCode(String.format("push%s %d", type.suffix(), value));
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

    public void pop(Type type) {
        writeCode("pop" + type.suffix());
    }
    public void addi() {
        writeCode("addi");
    }

    public void muli() {
        writeCode("muli");
    }

    public void mul(Type type) {
        writeCode("mul" + type.suffix());
    }
    public void jmp(int labelNumber) {
        writeCode(String.format("jmp label%d", labelNumber));
    }

    public void jz(int labelNumber) {
        writeCode(String.format("jz label%d", labelNumber));
    }

    public void call(String name) {
        writeCode("call " + name);
    }

    public void label(int labelNumber) {
        writeCode(String.format("label%d:", labelNumber));
    }

    public void ret(int bytesReturn, int bytesLocals, int bytesParams) {
        writeCode(String.format("ret %d, %d, %d", bytesReturn, bytesLocals, bytesParams));
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

    public void commentParameters() {
        writeCode("' * Parameters");
    }

    public void commentLocalVariables() {
        writeCode("' * Local variables");
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

    public void variableAddress(Variable var) {
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
        writeCode(code.replaceAll("\n", "\n" + indentation));
    }

    public void commentWriteStart() {
        writeCode("' * Write");
    }

    public void commentReadStart() {
        writeCode("' * Read");
    }

    public void commentWhileStart() {
        writeCode("' * While");
    }

    public void commentIfStart() {
        writeCode("' * If");
    }
    public void commentCondition() {
        writeCode("' * Condition");
    }

    public void commentWhileBody() {
        writeCode("' * While body");
    }

    public void commentIfBody() {
        writeCode("' * If branch body");
    }

    public void commentElseBody() {
        writeCode("' * Else branch body");
    }

    public void commentReturn() {
        writeCode("' * Return");
    }

    public void writeCode(String code) {
        try {
            outputFile.write(indentation + code + "\n");
            outputFile.flush();
        } catch (IOException e) {
            System.err.println("[ERROR] There was an error while writing the output file:");
            e.printStackTrace();
        }
    }

}

