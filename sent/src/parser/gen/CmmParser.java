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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, BLANK_SPACES=37, EOL=38, 
		ONE_LINE_COMMENT=39, MULTILINE_COMMENT=40, REAL_CONSTANT=41, INT_CONSTANT=42, 
		CHAR_CONSTANT=43, ID=44;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_variable = 2, RULE_functionInvocation = 3, 
		RULE_arguments = 4, RULE_statement = 5, RULE_ifStatement = 6, RULE_whileStatement = 7, 
		RULE_statementBlock = 8, RULE_expressionSequence = 9, RULE_definition = 10, 
		RULE_varDefinition = 11, RULE_functionDefinition = 12, RULE_argumentsDefinition = 13, 
		RULE_mainDefinition = 14, RULE_type = 15, RULE_primitiveType = 16, RULE_returnableType = 17, 
		RULE_voidType = 18, RULE_recordFieldDefinition = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "variable", "functionInvocation", "arguments", 
			"statement", "ifStatement", "whileStatement", "statementBlock", "expressionSequence", 
			"definition", "varDefinition", "functionDefinition", "argumentsDefinition", 
			"mainDefinition", "type", "primitiveType", "returnableType", "voidType", 
			"recordFieldDefinition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'.'", "'-'", "'*'", "'/'", "'%'", 
			"'+'", "'=='", "'!='", "'>'", "'<'", "'<='", "'>='", "'!'", "'&&'", "'||'", 
			"','", "'='", "';'", "'read'", "'write'", "'return'", "'if'", "'else'", 
			"'while'", "'{'", "'}'", "'void'", "'main'", "'struct'", "'int'", "'double'", 
			"'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "BLANK_SPACES", "EOL", "ONE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"REAL_CONSTANT", "INT_CONSTANT", "CHAR_CONSTANT", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> defs = new ArrayList<Definition>();
		public DefinitionContext d;
		public MainDefinitionContext md;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public MainDefinitionContext mainDefinition() {
			return getRuleContext(MainDefinitionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					((ProgramContext)_localctx).d = definition();
					 for(Definition def : ((ProgramContext)_localctx).d.ast) _localctx.defs.add(def); 
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(48);
			((ProgramContext)_localctx).md = mainDefinition();
			 _localctx.defs.add(((ProgramContext)_localctx).md.ast); 
			setState(50);
			match(EOF);
			 ((ProgramContext)_localctx).ast =  new Program(1, 1, _localctx.defs); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public PrimitiveTypeContext pt;
		public Token op;
		public FunctionInvocationContext functionInvocation;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public VariableContext variable;
		public ExpressionContext e2;
		public Token ID;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(54);
				match(T__0);
				setState(55);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(56);
				match(T__1);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 2:
				{
				setState(59);
				match(T__0);
				setState(60);
				((ExpressionContext)_localctx).pt = primitiveType();
				setState(61);
				match(T__1);
				setState(62);
				((ExpressionContext)_localctx).e1 = expression(12);
				 ((ExpressionContext)_localctx).ast =  new CastExpr(((ExpressionContext)_localctx).pt.ast.getLine(), ((ExpressionContext)_localctx).pt.ast.getColumn(), ((ExpressionContext)_localctx).pt.ast, ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 3:
				{
				setState(65);
				((ExpressionContext)_localctx).op = match(T__5);
				setState(66);
				((ExpressionContext)_localctx).e1 = expression(11);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 4:
				{
				setState(69);
				((ExpressionContext)_localctx).op = match(T__16);
				setState(70);
				((ExpressionContext)_localctx).e1 = expression(7);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 5:
				{
				setState(73);
				((ExpressionContext)_localctx).functionInvocation = functionInvocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).functionInvocation.ast; 
				}
				break;
			case 6:
				{
				setState(76);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
				                ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,
				                LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null))); 
				}
				break;
			case 7:
				{
				setState(78);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
				                ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1,
				                LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null))); 
				}
				break;
			case 8:
				{
				setState(80);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
				                ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,
				                LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null))); 
				}
				break;
			case 9:
				{
				setState(82);
				((ExpressionContext)_localctx).variable = variable();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).variable.ast; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(117);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(88);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(89);
						((ExpressionContext)_localctx).e2 = expression(11);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(93);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__9) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						((ExpressionContext)_localctx).e2 = expression(10);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(98);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(103);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(104);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(108);
						((ExpressionContext)_localctx).op = match(T__2);
						setState(109);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(110);
						match(T__3);
						 ((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(114);
						((ExpressionContext)_localctx).op = match(T__4);
						setState(115);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccessor(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Variable ast;
		public Token ID;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			((VariableContext)_localctx).ID = match(ID);
			 ((VariableContext)_localctx).ast =  new Variable(((VariableContext)_localctx).ID.getLine(), ((VariableContext)_localctx).ID.getCharPositionInLine()+1, (((VariableContext)_localctx).ID!=null?((VariableContext)_localctx).ID.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionInvocationContext extends ParserRuleContext {
		public FunctionInvocation ast;
		public Token ID;
		public ArgumentsContext arguments;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((FunctionInvocationContext)_localctx).ID = match(ID);
			setState(126);
			match(T__0);
			setState(127);
			((FunctionInvocationContext)_localctx).arguments = arguments();
			setState(128);
			match(T__1);
			 Variable var = new Variable(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null));
			    ((FunctionInvocationContext)_localctx).ast =  new FunctionInvocation(var.getLine(), var.getColumn(), var, ((FunctionInvocationContext)_localctx).arguments.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arguments);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__5:
			case T__16:
			case REAL_CONSTANT:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				((ArgumentsContext)_localctx).exp1 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).exp1.ast); 
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(133);
					match(T__19);
					setState(134);
					((ArgumentsContext)_localctx).exp2 = expression(0);
					 _localctx.ast.add(((ArgumentsContext)_localctx).exp2.ast); 
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public IfStatementContext ifStatement;
		public WhileStatementContext whileStatement;
		public ExpressionSequenceContext es;
		public FunctionInvocationContext fi;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((StatementContext)_localctx).e1 = expression(0);
				setState(146);
				((StatementContext)_localctx).op = match(T__20);
				setState(147);
				((StatementContext)_localctx).e2 = expression(0);
				setState(148);
				match(T__21);
				 _localctx.ast.add(new Assignment(((StatementContext)_localctx).op.getLine(), ((StatementContext)_localctx).op.getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				((StatementContext)_localctx).ifStatement = ifStatement();
				 _localctx.ast.add(((StatementContext)_localctx).ifStatement.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				((StatementContext)_localctx).whileStatement = whileStatement();
				 _localctx.ast.add(((StatementContext)_localctx).whileStatement.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(T__22);
				setState(158);
				((StatementContext)_localctx).es = expressionSequence();
				setState(159);
				match(T__21);
				 for (Expression exp : ((StatementContext)_localctx).es.ast)
				            _localctx.ast.add(new Read(exp.getLine(), exp.getColumn(), exp)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(T__23);
				setState(163);
				((StatementContext)_localctx).es = expressionSequence();
				setState(164);
				match(T__21);
				 for (Expression exp : ((StatementContext)_localctx).es.ast)
				            _localctx.ast.add(new Write(exp.getLine(), exp.getColumn(), exp)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				((StatementContext)_localctx).fi = functionInvocation();
				setState(168);
				match(T__21);
				 _localctx.ast.add(new Invocation(((StatementContext)_localctx).fi.ast)); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				((StatementContext)_localctx).op = match(T__24);
				setState(172);
				((StatementContext)_localctx).e1 = expression(0);
				setState(173);
				match(T__21);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).op.getLine(), ((StatementContext)_localctx).op.getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast)); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public If ast;
		public Token op;
		public ExpressionContext ex;
		public StatementBlockContext sb;
		public StatementBlockContext sb1;
		public StatementBlockContext sb2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementBlockContext> statementBlock() {
			return getRuleContexts(StatementBlockContext.class);
		}
		public StatementBlockContext statementBlock(int i) {
			return getRuleContext(StatementBlockContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((IfStatementContext)_localctx).op = match(T__25);
				setState(179);
				match(T__0);
				setState(180);
				((IfStatementContext)_localctx).ex = expression(0);
				setState(181);
				match(T__1);
				setState(182);
				((IfStatementContext)_localctx).sb = statementBlock();
				 ((IfStatementContext)_localctx).ast =  new If(((IfStatementContext)_localctx).op.getLine(), ((IfStatementContext)_localctx).op.getCharPositionInLine()+1, ((IfStatementContext)_localctx).ex.ast, ((IfStatementContext)_localctx).sb.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				((IfStatementContext)_localctx).op = match(T__25);
				setState(186);
				match(T__0);
				setState(187);
				((IfStatementContext)_localctx).ex = expression(0);
				setState(188);
				match(T__1);
				setState(189);
				((IfStatementContext)_localctx).sb1 = statementBlock();
				setState(190);
				match(T__26);
				setState(191);
				((IfStatementContext)_localctx).sb2 = statementBlock();
				 ((IfStatementContext)_localctx).ast =  new If(((IfStatementContext)_localctx).op.getLine(), ((IfStatementContext)_localctx).op.getCharPositionInLine()+1, ((IfStatementContext)_localctx).ex.ast, ((IfStatementContext)_localctx).sb1.ast, ((IfStatementContext)_localctx).sb2.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public While ast;
		public Token op;
		public ExpressionContext ex;
		public StatementBlockContext sb;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			((WhileStatementContext)_localctx).op = match(T__27);
			setState(197);
			match(T__0);
			setState(198);
			((WhileStatementContext)_localctx).ex = expression(0);
			setState(199);
			match(T__1);
			setState(200);
			((WhileStatementContext)_localctx).sb = statementBlock();
			 ((WhileStatementContext)_localctx).ast =  new While(((WhileStatementContext)_localctx).op.getLine(), ((WhileStatementContext)_localctx).op.getCharPositionInLine()+1, ((WhileStatementContext)_localctx).ex.ast, ((WhileStatementContext)_localctx).sb.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext st1;
		public StatementContext st2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementBlock);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__28);
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					((StatementBlockContext)_localctx).st1 = statement();
					 _localctx.ast.addAll(((StatementBlockContext)_localctx).st1.ast); 
					}
					}
					setState(209); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__16) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0) );
				setState(211);
				match(T__29);
				}
				break;
			case T__0:
			case T__5:
			case T__16:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__27:
			case REAL_CONSTANT:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				((StatementBlockContext)_localctx).st2 = statement();
				 _localctx.ast.addAll(((StatementBlockContext)_localctx).st2.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionSequenceContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpressionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(218);
			((ExpressionSequenceContext)_localctx).e1 = expression(0);
			 _localctx.ast.add(((ExpressionSequenceContext)_localctx).e1.ast); 
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(220);
				match(T__19);
				setState(221);
				((ExpressionSequenceContext)_localctx).e2 = expression(0);
				 _localctx.ast.add(((ExpressionSequenceContext)_localctx).e2.ast); 
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public VarDefinitionContext vd;
		public FunctionDefinitionContext fd;
		public MainDefinitionContext md;
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public MainDefinitionContext mainDefinition() {
			return getRuleContext(MainDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definition);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				((DefinitionContext)_localctx).vd = varDefinition();
				 _localctx.ast.addAll(((DefinitionContext)_localctx).vd.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				((DefinitionContext)_localctx).fd = functionDefinition();
				 _localctx.ast.add(((DefinitionContext)_localctx).fd.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				((DefinitionContext)_localctx).md = mainDefinition();
				 _localctx.ast.add(((DefinitionContext)_localctx).md.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public int counter = 0;
		public TypeContext type;
		public Token id1;
		public Token id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVarDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVarDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVarDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			((VarDefinitionContext)_localctx).type = type(0);
			setState(241);
			((VarDefinitionContext)_localctx).id1 = match(ID);
			 _localctx.ast.add(new VarDefinition(((VarDefinitionContext)_localctx).id1.getLine(), ((VarDefinitionContext)_localctx).id1.getCharPositionInLine()+1, ((VarDefinitionContext)_localctx).type.ast, (((VarDefinitionContext)_localctx).id1!=null?((VarDefinitionContext)_localctx).id1.getText():null), _localctx.counter));
			        _localctx.counter++; 
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(243);
				match(T__19);
				setState(244);
				((VarDefinitionContext)_localctx).id2 = match(ID);
				 _localctx.ast.add(new VarDefinition(((VarDefinitionContext)_localctx).id2.getLine(), ((VarDefinitionContext)_localctx).id2.getCharPositionInLine()+1, ((VarDefinitionContext)_localctx).type.ast, (((VarDefinitionContext)_localctx).id2!=null?((VarDefinitionContext)_localctx).id2.getText():null), _localctx.counter));
				       _localctx.counter++; 
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<VarDefinition> vdefs = new ArrayList<VarDefinition>();
		public List<Statement> stmnts = new ArrayList<Statement>();
		public ReturnableTypeContext rtype;
		public VariableContext var;
		public ArgumentsDefinitionContext ad;
		public VarDefinitionContext vd;
		public StatementContext stmnt;
		public ReturnableTypeContext returnableType() {
			return getRuleContext(ReturnableTypeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ArgumentsDefinitionContext argumentsDefinition() {
			return getRuleContext(ArgumentsDefinitionContext.class,0);
		}
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			((FunctionDefinitionContext)_localctx).rtype = returnableType();
			setState(254);
			((FunctionDefinitionContext)_localctx).var = variable();
			setState(255);
			match(T__0);
			setState(256);
			((FunctionDefinitionContext)_localctx).ad = argumentsDefinition();
			setState(257);
			match(T__1);
			 FunctionType ftype = new FunctionType(((FunctionDefinitionContext)_localctx).var.ast.getLine(), ((FunctionDefinitionContext)_localctx).var.ast.getColumn(), ((FunctionDefinitionContext)_localctx).rtype.ast, ((FunctionDefinitionContext)_localctx).ad.ast); 
			setState(259);
			match(T__28);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				{
				setState(260);
				((FunctionDefinitionContext)_localctx).vd = varDefinition();
				 _localctx.vdefs.addAll(((FunctionDefinitionContext)_localctx).vd.ast); 
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__16) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(268);
				((FunctionDefinitionContext)_localctx).stmnt = statement();
				 _localctx.stmnts.addAll(((FunctionDefinitionContext)_localctx).stmnt.ast); 
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			match(T__29);
			 ((FunctionDefinitionContext)_localctx).ast =  new FunctionDefinition(((FunctionDefinitionContext)_localctx).var.ast.getLine(), ((FunctionDefinitionContext)_localctx).var.ast.getColumn(), ftype, ((FunctionDefinitionContext)_localctx).var.ast.getName(), _localctx.vdefs,
			        _localctx.stmnts); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public int counter = 0;
		public PrimitiveTypeContext t1;
		public Token id1;
		public PrimitiveTypeContext t2;
		public Token id2;
		public List<PrimitiveTypeContext> primitiveType() {
			return getRuleContexts(PrimitiveTypeContext.class);
		}
		public PrimitiveTypeContext primitiveType(int i) {
			return getRuleContext(PrimitiveTypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ArgumentsDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterArgumentsDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitArgumentsDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitArgumentsDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsDefinitionContext argumentsDefinition() throws RecognitionException {
		ArgumentsDefinitionContext _localctx = new ArgumentsDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argumentsDefinition);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				((ArgumentsDefinitionContext)_localctx).t1 = primitiveType();
				setState(280);
				((ArgumentsDefinitionContext)_localctx).id1 = match(ID);
				 _localctx.ast.add(new VarDefinition(((ArgumentsDefinitionContext)_localctx).id1.getLine(), ((ArgumentsDefinitionContext)_localctx).id1.getCharPositionInLine()+1, ((ArgumentsDefinitionContext)_localctx).t1.ast, (((ArgumentsDefinitionContext)_localctx).id1!=null?((ArgumentsDefinitionContext)_localctx).id1.getText():null), _localctx.counter));
				        _localctx.counter++; 
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(282);
					match(T__19);
					setState(283);
					((ArgumentsDefinitionContext)_localctx).t2 = primitiveType();
					setState(284);
					((ArgumentsDefinitionContext)_localctx).id2 = match(ID);
					 _localctx.ast.add(new VarDefinition(((ArgumentsDefinitionContext)_localctx).id2.getLine(), ((ArgumentsDefinitionContext)_localctx).id2.getCharPositionInLine()+1, ((ArgumentsDefinitionContext)_localctx).t2.ast, (((ArgumentsDefinitionContext)_localctx).id2!=null?((ArgumentsDefinitionContext)_localctx).id2.getText():null), _localctx.counter));
					        _localctx.counter++; 
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainDefinitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<VarDefinition> vdefs = new ArrayList<VarDefinition>();
		public List<Statement> stmnts = new ArrayList<Statement>();
		public Token rType;
		public Token name;
		public VarDefinitionContext vd;
		public StatementContext stmnt;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMainDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMainDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMainDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDefinitionContext mainDefinition() throws RecognitionException {
		MainDefinitionContext _localctx = new MainDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mainDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			((MainDefinitionContext)_localctx).rType = match(T__30);
			setState(296);
			((MainDefinitionContext)_localctx).name = match(T__31);
			setState(297);
			match(T__0);
			setState(298);
			match(T__1);
			setState(299);
			match(T__28);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				{
				setState(300);
				((MainDefinitionContext)_localctx).vd = varDefinition();
				 _localctx.vdefs.addAll(((MainDefinitionContext)_localctx).vd.ast); 
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__16) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(308);
				((MainDefinitionContext)_localctx).stmnt = statement();
				 _localctx.stmnts.addAll(((MainDefinitionContext)_localctx).stmnt.ast); 
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316);
			match(T__29);
			 Variable var = new Variable(((MainDefinitionContext)_localctx).name.getLine(), ((MainDefinitionContext)_localctx).name.getCharPositionInLine()+1, (((MainDefinitionContext)_localctx).name!=null?((MainDefinitionContext)_localctx).name.getText():null)); 
			 FunctionType ftype = new FunctionType(var.getLine(), var.getColumn(), new VoidType(
			        ((MainDefinitionContext)_localctx).rType.getLine(), ((MainDefinitionContext)_localctx).rType.getCharPositionInLine()+1), new ArrayList<VarDefinition>()); 
			 ((MainDefinitionContext)_localctx).ast =  new FunctionDefinition(var.getLine(), var.getColumn(), ftype, var.getName(), _localctx.vdefs, _localctx.stmnts); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> rfields = new ArrayList<RecordField>();
		public LinkedList<Integer> arraySizes = new LinkedList<Integer>();
		public TypeContext at;
		public PrimitiveTypeContext pt;
		public Token word;
		public RecordFieldDefinitionContext rfd;
		public VoidTypeContext vt;
		public Token size;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<RecordFieldDefinitionContext> recordFieldDefinition() {
			return getRuleContexts(RecordFieldDefinitionContext.class);
		}
		public RecordFieldDefinitionContext recordFieldDefinition(int i) {
			return getRuleContext(RecordFieldDefinitionContext.class,i);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> INT_CONSTANT() { return getTokens(CmmParser.INT_CONSTANT); }
		public TerminalNode INT_CONSTANT(int i) {
			return getToken(CmmParser.INT_CONSTANT, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				{
				setState(322);
				((TypeContext)_localctx).pt = primitiveType();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).pt.ast; 
				}
				break;
			case T__32:
				{
				setState(325);
				((TypeContext)_localctx).word = match(T__32);
				setState(326);
				match(T__28);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
					{
					{
					setState(327);
					((TypeContext)_localctx).rfd = recordFieldDefinition();
					 _localctx.rfields.addAll(((TypeContext)_localctx).rfd.ast); 
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(335);
				match(T__29);
				 ((TypeContext)_localctx).ast =  new RecordType(((TypeContext)_localctx).word.getLine(), ((TypeContext)_localctx).word.getCharPositionInLine()+1, _localctx.rfields); 
				}
				break;
			case T__30:
				{
				setState(337);
				((TypeContext)_localctx).vt = voidType();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).vt.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(355);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.at = _prevctx;
					_localctx.at = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(342);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					 Type result = ((TypeContext)_localctx).at.ast; 
					setState(348); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(344);
							match(T__2);
							setState(345);
							((TypeContext)_localctx).size = match(INT_CONSTANT);
							setState(346);
							match(T__3);
							 _localctx.arraySizes.addFirst(LexerHelper.lexemeToInt((((TypeContext)_localctx).size!=null?((TypeContext)_localctx).size.getText():null))); 
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(350); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					 for (Integer size : _localctx.arraySizes)
					                      result = new ArrayType(((TypeContext)_localctx).at.ast.getLine(), ((TypeContext)_localctx).at.ast.getColumn(), result, size);
					                    ((TypeContext)_localctx).ast =  result; 
					}
					} 
				}
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public Type ast;
		public Token word;
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primitiveType);
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				((PrimitiveTypeContext)_localctx).word = match(T__33);
				 ((PrimitiveTypeContext)_localctx).ast =  new IntType(((PrimitiveTypeContext)_localctx).word.getLine(), ((PrimitiveTypeContext)_localctx).word.getCharPositionInLine()+1); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				((PrimitiveTypeContext)_localctx).word = match(T__34);
				 ((PrimitiveTypeContext)_localctx).ast =  new DoubleType(((PrimitiveTypeContext)_localctx).word.getLine(), ((PrimitiveTypeContext)_localctx).word.getCharPositionInLine()+1); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				((PrimitiveTypeContext)_localctx).word = match(T__35);
				 ((PrimitiveTypeContext)_localctx).ast =  new CharType(((PrimitiveTypeContext)_localctx).word.getLine(), ((PrimitiveTypeContext)_localctx).word.getCharPositionInLine()+1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnableTypeContext extends ParserRuleContext {
		public Type ast;
		public PrimitiveTypeContext pt;
		public VoidTypeContext vt;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public ReturnableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnableType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterReturnableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitReturnableType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitReturnableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnableTypeContext returnableType() throws RecognitionException {
		ReturnableTypeContext _localctx = new ReturnableTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnableType);
		try {
			setState(372);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				((ReturnableTypeContext)_localctx).pt = primitiveType();
				 ((ReturnableTypeContext)_localctx).ast =  ((ReturnableTypeContext)_localctx).pt.ast; 
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				((ReturnableTypeContext)_localctx).vt = voidType();
				 ((ReturnableTypeContext)_localctx).ast =  ((ReturnableTypeContext)_localctx).vt.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidTypeContext extends ParserRuleContext {
		public VoidType ast;
		public Token texp;
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			((VoidTypeContext)_localctx).texp = match(T__30);
			 ((VoidTypeContext)_localctx).ast =  new VoidType(((VoidTypeContext)_localctx).texp.getLine(), ((VoidTypeContext)_localctx).texp.getCharPositionInLine()+1); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordFieldDefinitionContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public int counter = 0;
		public TypeContext type;
		public Token id1;
		public Token id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public RecordFieldDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordFieldDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterRecordFieldDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitRecordFieldDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitRecordFieldDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordFieldDefinitionContext recordFieldDefinition() throws RecognitionException {
		RecordFieldDefinitionContext _localctx = new RecordFieldDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_recordFieldDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			((RecordFieldDefinitionContext)_localctx).type = type(0);
			setState(378);
			((RecordFieldDefinitionContext)_localctx).id1 = match(ID);
			 _localctx.ast.add(new RecordField(((RecordFieldDefinitionContext)_localctx).id1.getLine(), ((RecordFieldDefinitionContext)_localctx).id1.getCharPositionInLine()+1, ((RecordFieldDefinitionContext)_localctx).type.ast, (((RecordFieldDefinitionContext)_localctx).id1!=null?((RecordFieldDefinitionContext)_localctx).id1.getText():null), _localctx.counter));
			        _localctx.counter++; 
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(380);
				match(T__19);
				setState(381);
				((RecordFieldDefinitionContext)_localctx).id2 = match(ID);
				 _localctx.ast.add(new RecordField(((RecordFieldDefinitionContext)_localctx).id2.getLine(), ((RecordFieldDefinitionContext)_localctx).id2.getCharPositionInLine()+1, ((RecordFieldDefinitionContext)_localctx).type.ast, (((RecordFieldDefinitionContext)_localctx).id2!=null?((RecordFieldDefinitionContext)_localctx).id2.getText():null), _localctx.counter));
				       _localctx.counter++; 
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 15:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0189\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3X\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"x\n\3\f\3\16\3{\13\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\6\5\6\u0092\n\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b3\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c5\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\6\n\u00d2\n\n\r\n\16\n\u00d3"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00db\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00e3\n\13\f\13\16\13\u00e6\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00f1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f9\n\r\f\r\16\r\u00fc\13"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u010a"+
		"\n\16\f\16\16\16\u010d\13\16\3\16\3\16\3\16\7\16\u0112\n\16\f\16\16\16"+
		"\u0115\13\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7"+
		"\17\u0122\n\17\f\17\16\17\u0125\13\17\3\17\5\17\u0128\n\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\7\20\u0132\n\20\f\20\16\20\u0135\13\20\3"+
		"\20\3\20\3\20\7\20\u013a\n\20\f\20\16\20\u013d\13\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u014d\n\21"+
		"\f\21\16\21\u0150\13\21\3\21\3\21\3\21\3\21\3\21\5\21\u0157\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\6\21\u015f\n\21\r\21\16\21\u0160\3\21\7\21\u0164"+
		"\n\21\f\21\16\21\u0167\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u016f"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0177\n\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u0182\n\25\f\25\16\25\u0185\13\25\3\25"+
		"\3\25\3\25\2\4\4 \26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\6"+
		"\3\2\t\13\4\2\b\b\f\f\3\2\r\22\3\2\24\25\2\u01a1\2/\3\2\2\2\4W\3\2\2\2"+
		"\6|\3\2\2\2\b\177\3\2\2\2\n\u0091\3\2\2\2\f\u00b2\3\2\2\2\16\u00c4\3\2"+
		"\2\2\20\u00c6\3\2\2\2\22\u00da\3\2\2\2\24\u00dc\3\2\2\2\26\u00f0\3\2\2"+
		"\2\30\u00f2\3\2\2\2\32\u00ff\3\2\2\2\34\u0127\3\2\2\2\36\u0129\3\2\2\2"+
		" \u0156\3\2\2\2\"\u016e\3\2\2\2$\u0176\3\2\2\2&\u0178\3\2\2\2(\u017b\3"+
		"\2\2\2*+\5\26\f\2+,\b\2\1\2,.\3\2\2\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2"+
		"/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\5\36\20\2\63\64\b\2\1\2\64"+
		"\65\7\2\2\3\65\66\b\2\1\2\66\3\3\2\2\2\678\b\3\1\289\7\3\2\29:\5\4\3\2"+
		":;\7\4\2\2;<\b\3\1\2<X\3\2\2\2=>\7\3\2\2>?\5\"\22\2?@\7\4\2\2@A\5\4\3"+
		"\16AB\b\3\1\2BX\3\2\2\2CD\7\b\2\2DE\5\4\3\rEF\b\3\1\2FX\3\2\2\2GH\7\23"+
		"\2\2HI\5\4\3\tIJ\b\3\1\2JX\3\2\2\2KL\5\b\5\2LM\b\3\1\2MX\3\2\2\2NO\7,"+
		"\2\2OX\b\3\1\2PQ\7+\2\2QX\b\3\1\2RS\7-\2\2SX\b\3\1\2TU\5\6\4\2UV\b\3\1"+
		"\2VX\3\2\2\2W\67\3\2\2\2W=\3\2\2\2WC\3\2\2\2WG\3\2\2\2WK\3\2\2\2WN\3\2"+
		"\2\2WP\3\2\2\2WR\3\2\2\2WT\3\2\2\2Xy\3\2\2\2YZ\f\f\2\2Z[\t\2\2\2[\\\5"+
		"\4\3\r\\]\b\3\1\2]x\3\2\2\2^_\f\13\2\2_`\t\3\2\2`a\5\4\3\fab\b\3\1\2b"+
		"x\3\2\2\2cd\f\n\2\2de\t\4\2\2ef\5\4\3\13fg\b\3\1\2gx\3\2\2\2hi\f\b\2\2"+
		"ij\t\5\2\2jk\5\4\3\tkl\b\3\1\2lx\3\2\2\2mn\f\20\2\2no\7\5\2\2op\5\4\3"+
		"\2pq\7\6\2\2qr\b\3\1\2rx\3\2\2\2st\f\17\2\2tu\7\7\2\2uv\7.\2\2vx\b\3\1"+
		"\2wY\3\2\2\2w^\3\2\2\2wc\3\2\2\2wh\3\2\2\2wm\3\2\2\2ws\3\2\2\2x{\3\2\2"+
		"\2yw\3\2\2\2yz\3\2\2\2z\5\3\2\2\2{y\3\2\2\2|}\7.\2\2}~\b\4\1\2~\7\3\2"+
		"\2\2\177\u0080\7.\2\2\u0080\u0081\7\3\2\2\u0081\u0082\5\n\6\2\u0082\u0083"+
		"\7\4\2\2\u0083\u0084\b\5\1\2\u0084\t\3\2\2\2\u0085\u0086\5\4\3\2\u0086"+
		"\u008d\b\6\1\2\u0087\u0088\7\26\2\2\u0088\u0089\5\4\3\2\u0089\u008a\b"+
		"\6\1\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0092\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u0085\3\2\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\13\3\2\2\2\u0093\u0094\5\4\3\2\u0094\u0095\7\27\2\2\u0095\u0096\5\4\3"+
		"\2\u0096\u0097\7\30\2\2\u0097\u0098\b\7\1\2\u0098\u00b3\3\2\2\2\u0099"+
		"\u009a\5\16\b\2\u009a\u009b\b\7\1\2\u009b\u00b3\3\2\2\2\u009c\u009d\5"+
		"\20\t\2\u009d\u009e\b\7\1\2\u009e\u00b3\3\2\2\2\u009f\u00a0\7\31\2\2\u00a0"+
		"\u00a1\5\24\13\2\u00a1\u00a2\7\30\2\2\u00a2\u00a3\b\7\1\2\u00a3\u00b3"+
		"\3\2\2\2\u00a4\u00a5\7\32\2\2\u00a5\u00a6\5\24\13\2\u00a6\u00a7\7\30\2"+
		"\2\u00a7\u00a8\b\7\1\2\u00a8\u00b3\3\2\2\2\u00a9\u00aa\5\b\5\2\u00aa\u00ab"+
		"\7\30\2\2\u00ab\u00ac\b\7\1\2\u00ac\u00b3\3\2\2\2\u00ad\u00ae\7\33\2\2"+
		"\u00ae\u00af\5\4\3\2\u00af\u00b0\7\30\2\2\u00b0\u00b1\b\7\1\2\u00b1\u00b3"+
		"\3\2\2\2\u00b2\u0093\3\2\2\2\u00b2\u0099\3\2\2\2\u00b2\u009c\3\2\2\2\u00b2"+
		"\u009f\3\2\2\2\u00b2\u00a4\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00ad\3\2"+
		"\2\2\u00b3\r\3\2\2\2\u00b4\u00b5\7\34\2\2\u00b5\u00b6\7\3\2\2\u00b6\u00b7"+
		"\5\4\3\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5\22\n\2\u00b9\u00ba\b\b\1\2"+
		"\u00ba\u00c5\3\2\2\2\u00bb\u00bc\7\34\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00be"+
		"\5\4\3\2\u00be\u00bf\7\4\2\2\u00bf\u00c0\5\22\n\2\u00c0\u00c1\7\35\2\2"+
		"\u00c1\u00c2\5\22\n\2\u00c2\u00c3\b\b\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00b4"+
		"\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c5\17\3\2\2\2\u00c6\u00c7\7\36\2\2\u00c7"+
		"\u00c8\7\3\2\2\u00c8\u00c9\5\4\3\2\u00c9\u00ca\7\4\2\2\u00ca\u00cb\5\22"+
		"\n\2\u00cb\u00cc\b\t\1\2\u00cc\21\3\2\2\2\u00cd\u00d1\7\37\2\2\u00ce\u00cf"+
		"\5\f\7\2\u00cf\u00d0\b\n\1\2\u00d0\u00d2\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d6\7 \2\2\u00d6\u00db\3\2\2\2\u00d7\u00d8\5\f\7\2\u00d8"+
		"\u00d9\b\n\1\2\u00d9\u00db\3\2\2\2\u00da\u00cd\3\2\2\2\u00da\u00d7\3\2"+
		"\2\2\u00db\23\3\2\2\2\u00dc\u00dd\5\4\3\2\u00dd\u00e4\b\13\1\2\u00de\u00df"+
		"\7\26\2\2\u00df\u00e0\5\4\3\2\u00e0\u00e1\b\13\1\2\u00e1\u00e3\3\2\2\2"+
		"\u00e2\u00de\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\25\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\5\30\r\2\u00e8"+
		"\u00e9\b\f\1\2\u00e9\u00f1\3\2\2\2\u00ea\u00eb\5\32\16\2\u00eb\u00ec\b"+
		"\f\1\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee\5\36\20\2\u00ee\u00ef\b\f\1\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00ed\3\2"+
		"\2\2\u00f1\27\3\2\2\2\u00f2\u00f3\5 \21\2\u00f3\u00f4\7.\2\2\u00f4\u00fa"+
		"\b\r\1\2\u00f5\u00f6\7\26\2\2\u00f6\u00f7\7.\2\2\u00f7\u00f9\b\r\1\2\u00f8"+
		"\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7\30\2\2\u00fe"+
		"\31\3\2\2\2\u00ff\u0100\5$\23\2\u0100\u0101\5\6\4\2\u0101\u0102\7\3\2"+
		"\2\u0102\u0103\5\34\17\2\u0103\u0104\7\4\2\2\u0104\u0105\b\16\1\2\u0105"+
		"\u010b\7\37\2\2\u0106\u0107\5\30\r\2\u0107\u0108\b\16\1\2\u0108\u010a"+
		"\3\2\2\2\u0109\u0106\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u0113\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\5\f"+
		"\7\2\u010f\u0110\b\16\1\2\u0110\u0112\3\2\2\2\u0111\u010e\3\2\2\2\u0112"+
		"\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2"+
		"\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7 \2\2\u0117\u0118\b\16\1\2\u0118"+
		"\33\3\2\2\2\u0119\u011a\5\"\22\2\u011a\u011b\7.\2\2\u011b\u0123\b\17\1"+
		"\2\u011c\u011d\7\26\2\2\u011d\u011e\5\"\22\2\u011e\u011f\7.\2\2\u011f"+
		"\u0120\b\17\1\2\u0120\u0122\3\2\2\2\u0121\u011c\3\2\2\2\u0122\u0125\3"+
		"\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0128\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0119\3\2\2\2\u0127\u0126\3\2"+
		"\2\2\u0128\35\3\2\2\2\u0129\u012a\7!\2\2\u012a\u012b\7\"\2\2\u012b\u012c"+
		"\7\3\2\2\u012c\u012d\7\4\2\2\u012d\u0133\7\37\2\2\u012e\u012f\5\30\r\2"+
		"\u012f\u0130\b\20\1\2\u0130\u0132\3\2\2\2\u0131\u012e\3\2\2\2\u0132\u0135"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u013b\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0136\u0137\5\f\7\2\u0137\u0138\b\20\1\2\u0138\u013a\3"+
		"\2\2\2\u0139\u0136\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7 "+
		"\2\2\u013f\u0140\b\20\1\2\u0140\u0141\b\20\1\2\u0141\u0142\b\20\1\2\u0142"+
		"\37\3\2\2\2\u0143\u0144\b\21\1\2\u0144\u0145\5\"\22\2\u0145\u0146\b\21"+
		"\1\2\u0146\u0157\3\2\2\2\u0147\u0148\7#\2\2\u0148\u014e\7\37\2\2\u0149"+
		"\u014a\5(\25\2\u014a\u014b\b\21\1\2\u014b\u014d\3\2\2\2\u014c\u0149\3"+
		"\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f"+
		"\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7 \2\2\u0152\u0157\b\21"+
		"\1\2\u0153\u0154\5&\24\2\u0154\u0155\b\21\1\2\u0155\u0157\3\2\2\2\u0156"+
		"\u0143\3\2\2\2\u0156\u0147\3\2\2\2\u0156\u0153\3\2\2\2\u0157\u0165\3\2"+
		"\2\2\u0158\u0159\f\5\2\2\u0159\u015e\b\21\1\2\u015a\u015b\7\5\2\2\u015b"+
		"\u015c\7,\2\2\u015c\u015d\7\6\2\2\u015d\u015f\b\21\1\2\u015e\u015a\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u0164\b\21\1\2\u0163\u0158\3\2\2\2\u0164\u0167\3"+
		"\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166!\3\2\2\2\u0167\u0165"+
		"\3\2\2\2\u0168\u0169\7$\2\2\u0169\u016f\b\22\1\2\u016a\u016b\7%\2\2\u016b"+
		"\u016f\b\22\1\2\u016c\u016d\7&\2\2\u016d\u016f\b\22\1\2\u016e\u0168\3"+
		"\2\2\2\u016e\u016a\3\2\2\2\u016e\u016c\3\2\2\2\u016f#\3\2\2\2\u0170\u0171"+
		"\5\"\22\2\u0171\u0172\b\23\1\2\u0172\u0177\3\2\2\2\u0173\u0174\5&\24\2"+
		"\u0174\u0175\b\23\1\2\u0175\u0177\3\2\2\2\u0176\u0170\3\2\2\2\u0176\u0173"+
		"\3\2\2\2\u0177%\3\2\2\2\u0178\u0179\7!\2\2\u0179\u017a\b\24\1\2\u017a"+
		"\'\3\2\2\2\u017b\u017c\5 \21\2\u017c\u017d\7.\2\2\u017d\u0183\b\25\1\2"+
		"\u017e\u017f\7\26\2\2\u017f\u0180\7.\2\2\u0180\u0182\b\25\1\2\u0181\u017e"+
		"\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7\30\2\2\u0187)\3\2\2\2"+
		"\34/Wwy\u008d\u0091\u00b2\u00c4\u00d3\u00da\u00e4\u00f0\u00fa\u010b\u0113"+
		"\u0123\u0127\u0133\u013b\u014e\u0156\u0160\u0165\u016e\u0176\u0183";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}