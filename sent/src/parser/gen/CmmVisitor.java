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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CmmParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(CmmParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CmmParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CmmParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(CmmParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(CmmParser.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#varDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefinition(CmmParser.VarDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CmmParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsDefinition(CmmParser.ArgumentsDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#mainDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDefinition(CmmParser.MainDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(CmmParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#returnableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnableType(CmmParser.ReturnableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#voidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(CmmParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#recordFieldDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordFieldDefinition(CmmParser.RecordFieldDefinitionContext ctx);
}