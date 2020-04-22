// Generated from /home/taamas/IIS/4/DLP/labs/gitRepo/CmmCompiler/src/parser/Cmm.g4 by ANTLR 4.8
package parser.gen;

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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmmParser}.
 */
public interface CmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CmmParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CmmParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(CmmParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(CmmParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CmmParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CmmParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CmmParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CmmParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(CmmParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(CmmParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(CmmParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(CmmParser.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVarDefinition(CmmParser.VarDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVarDefinition(CmmParser.VarDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsDefinition(CmmParser.ArgumentsDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsDefinition(CmmParser.ArgumentsDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#mainDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMainDefinition(CmmParser.MainDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#mainDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMainDefinition(CmmParser.MainDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(CmmParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(CmmParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#returnableType}.
	 * @param ctx the parse tree
	 */
	void enterReturnableType(CmmParser.ReturnableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#returnableType}.
	 * @param ctx the parse tree
	 */
	void exitReturnableType(CmmParser.ReturnableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(CmmParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(CmmParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#recordFieldDefinition}.
	 * @param ctx the parse tree
	 */
	void enterRecordFieldDefinition(CmmParser.RecordFieldDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#recordFieldDefinition}.
	 * @param ctx the parse tree
	 */
	void exitRecordFieldDefinition(CmmParser.RecordFieldDefinitionContext ctx);
}