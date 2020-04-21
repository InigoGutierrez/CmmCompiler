package codegeneration;

public class ExecuteCGVisitor {

    // Code templates

    // Program
    /*
    execute[[Program: program -> definition*]]:
        <call main>
        <halt>
        definition*.forEach(d -> execute[[d]]);
     */

    // Write
    /*
    execute[[Write: write -> expression]]:
        value[[expression]];
        <out>;
     */

    // Read
    /*
    execute[[Read: read -> expression]]:
        address[[expression]];
        <in> + expression.getType().suffix();
        <store> + expression.getType().suffix();
     */

    // Assignment
    /*
    execute[[Assignment: assignment -> expression1 expression2]]:
        address[[expression1]];
        value[[expression2]];
        <store> + expression1.getType().suffix();
     */

}

