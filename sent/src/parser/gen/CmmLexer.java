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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "BLANK_SPACES", "EOL", "ONE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "DECIMAL_PART", "REAL_NUMBER", "REAL_CONSTANT", 
			"INT_CONSTANT", "CHAR_CONSTANT", "ID"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0144\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\6&\u00d8\n&\r&\16&\u00d9"+
		"\3&\5&\u00dd\n&\3&\3&\3\'\6\'\u00e2\n\'\r\'\16\'\u00e3\3\'\3\'\3(\3(\3"+
		"(\3(\7(\u00ec\n(\f(\16(\u00ef\13(\3(\3(\5(\u00f3\n(\3(\3(\3)\3)\3)\3)"+
		"\7)\u00fb\n)\f)\16)\u00fe\13)\3)\3)\3)\3)\3)\3*\7*\u0106\n*\f*\16*\u0109"+
		"\13*\3*\3*\3+\5+\u010e\n+\3+\3+\3+\3+\3+\5+\u0115\n+\5+\u0117\n+\3,\3"+
		",\3,\5,\u011c\n,\3,\3,\5,\u0120\n,\3,\3,\5,\u0124\n,\3-\3-\7-\u0128\n"+
		"-\f-\16-\u012b\13-\3-\5-\u012e\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3."+
		"\5.\u013c\n.\3/\3/\7/\u0140\n/\f/\16/\u0143\13/\4\u00ed\u00fc\2\60\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S\2U\2W+Y,[-].\3\2\f\4\2\13\13\"\"\4\2\f\f\17\17\3"+
		"\2\62;\3\2\63;\4\2GGgg\4\2--//\3\2))\4\2ppvv\5\2C\\aac|\6\2\62;C\\aac"+
		"|\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7c\3\2"+
		"\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23o\3\2"+
		"\2\2\25q\3\2\2\2\27s\3\2\2\2\31v\3\2\2\2\33y\3\2\2\2\35{\3\2\2\2\37}\3"+
		"\2\2\2!\u0080\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0088\3\2\2\2)\u008b"+
		"\3\2\2\2+\u008d\3\2\2\2-\u008f\3\2\2\2/\u0091\3\2\2\2\61\u0096\3\2\2\2"+
		"\63\u009c\3\2\2\2\65\u00a3\3\2\2\2\67\u00a6\3\2\2\29\u00ab\3\2\2\2;\u00b1"+
		"\3\2\2\2=\u00b3\3\2\2\2?\u00b5\3\2\2\2A\u00ba\3\2\2\2C\u00bf\3\2\2\2E"+
		"\u00c6\3\2\2\2G\u00ca\3\2\2\2I\u00d1\3\2\2\2K\u00dc\3\2\2\2M\u00e1\3\2"+
		"\2\2O\u00e7\3\2\2\2Q\u00f6\3\2\2\2S\u0107\3\2\2\2U\u0116\3\2\2\2W\u0123"+
		"\3\2\2\2Y\u012d\3\2\2\2[\u013b\3\2\2\2]\u013d\3\2\2\2_`\7*\2\2`\4\3\2"+
		"\2\2ab\7+\2\2b\6\3\2\2\2cd\7]\2\2d\b\3\2\2\2ef\7_\2\2f\n\3\2\2\2gh\7\60"+
		"\2\2h\f\3\2\2\2ij\7/\2\2j\16\3\2\2\2kl\7,\2\2l\20\3\2\2\2mn\7\61\2\2n"+
		"\22\3\2\2\2op\7\'\2\2p\24\3\2\2\2qr\7-\2\2r\26\3\2\2\2st\7?\2\2tu\7?\2"+
		"\2u\30\3\2\2\2vw\7#\2\2wx\7?\2\2x\32\3\2\2\2yz\7@\2\2z\34\3\2\2\2{|\7"+
		">\2\2|\36\3\2\2\2}~\7>\2\2~\177\7?\2\2\177 \3\2\2\2\u0080\u0081\7@\2\2"+
		"\u0081\u0082\7?\2\2\u0082\"\3\2\2\2\u0083\u0084\7#\2\2\u0084$\3\2\2\2"+
		"\u0085\u0086\7(\2\2\u0086\u0087\7(\2\2\u0087&\3\2\2\2\u0088\u0089\7~\2"+
		"\2\u0089\u008a\7~\2\2\u008a(\3\2\2\2\u008b\u008c\7.\2\2\u008c*\3\2\2\2"+
		"\u008d\u008e\7?\2\2\u008e,\3\2\2\2\u008f\u0090\7=\2\2\u0090.\3\2\2\2\u0091"+
		"\u0092\7t\2\2\u0092\u0093\7g\2\2\u0093\u0094\7c\2\2\u0094\u0095\7f\2\2"+
		"\u0095\60\3\2\2\2\u0096\u0097\7y\2\2\u0097\u0098\7t\2\2\u0098\u0099\7"+
		"k\2\2\u0099\u009a\7v\2\2\u009a\u009b\7g\2\2\u009b\62\3\2\2\2\u009c\u009d"+
		"\7t\2\2\u009d\u009e\7g\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7w\2\2\u00a0"+
		"\u00a1\7t\2\2\u00a1\u00a2\7p\2\2\u00a2\64\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4"+
		"\u00a5\7h\2\2\u00a5\66\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7n\2\2\u00a8"+
		"\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7y\2\2\u00ac"+
		"\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7g\2\2"+
		"\u00b0:\3\2\2\2\u00b1\u00b2\7}\2\2\u00b2<\3\2\2\2\u00b3\u00b4\7\177\2"+
		"\2\u00b4>\3\2\2\2\u00b5\u00b6\7x\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7"+
		"k\2\2\u00b8\u00b9\7f\2\2\u00b9@\3\2\2\2\u00ba\u00bb\7o\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00beB\3\2\2\2\u00bf\u00c0"+
		"\7u\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7w\2\2\u00c3"+
		"\u00c4\7e\2\2\u00c4\u00c5\7v\2\2\u00c5D\3\2\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7p\2\2\u00c8\u00c9\7v\2\2\u00c9F\3\2\2\2\u00ca\u00cb\7f\2\2\u00cb"+
		"\u00cc\7q\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7d\2\2\u00ce\u00cf\7n\2\2"+
		"\u00cf\u00d0\7g\2\2\u00d0H\3\2\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7j\2"+
		"\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7t\2\2\u00d5J\3\2\2\2\u00d6\u00d8\t"+
		"\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00dd\7\2\2\3\u00dc\u00d7\3\2"+
		"\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b&\2\2\u00df"+
		"L\3\2\2\2\u00e0\u00e2\t\3\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6"+
		"\b\'\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00e9\7\61\2\2\u00e9"+
		"\u00ed\3\2\2\2\u00ea\u00ec\13\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f2\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f3\5M\'\2\u00f1\u00f3\7\2\2\3\u00f2\u00f0\3\2"+
		"\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b(\2\2\u00f5"+
		"P\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7\u00f8\7,\2\2\u00f8\u00fc\3\2\2\2"+
		"\u00f9\u00fb\13\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"\u0100\7,\2\2\u0100\u0101\7\61\2\2\u0101\u0102\3\2\2\2\u0102\u0103\b)"+
		"\2\2\u0103R\3\2\2\2\u0104\u0106\t\4\2\2\u0105\u0104\3\2\2\2\u0106\u0109"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u010a\u010b\t\5\2\2\u010bT\3\2\2\2\u010c\u010e\5Y-\2\u010d"+
		"\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\7\60"+
		"\2\2\u0110\u0117\5S*\2\u0111\u0112\5Y-\2\u0112\u0114\7\60\2\2\u0113\u0115"+
		"\5S*\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116"+
		"\u010d\3\2\2\2\u0116\u0111\3\2\2\2\u0117V\3\2\2\2\u0118\u0124\5U+\2\u0119"+
		"\u011c\5U+\2\u011a\u011c\5Y-\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2"+
		"\u011c\u011d\3\2\2\2\u011d\u011f\t\6\2\2\u011e\u0120\t\7\2\2\u011f\u011e"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\5Y-\2\u0122"+
		"\u0124\3\2\2\2\u0123\u0118\3\2\2\2\u0123\u011b\3\2\2\2\u0124X\3\2\2\2"+
		"\u0125\u0129\t\5\2\2\u0126\u0128\t\4\2\2\u0127\u0126\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012e\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012e\7\62\2\2\u012d\u0125\3\2\2\2\u012d\u012c\3"+
		"\2\2\2\u012eZ\3\2\2\2\u012f\u0130\7)\2\2\u0130\u0131\n\b\2\2\u0131\u013c"+
		"\7)\2\2\u0132\u0133\7)\2\2\u0133\u0134\7^\2\2\u0134\u0135\t\t\2\2\u0135"+
		"\u013c\7)\2\2\u0136\u0137\7)\2\2\u0137\u0138\7^\2\2\u0138\u0139\5Y-\2"+
		"\u0139\u013a\7)\2\2\u013a\u013c\3\2\2\2\u013b\u012f\3\2\2\2\u013b\u0132"+
		"\3\2\2\2\u013b\u0136\3\2\2\2\u013c\\\3\2\2\2\u013d\u0141\t\n\2\2\u013e"+
		"\u0140\t\13\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3"+
		"\2\2\2\u0141\u0142\3\2\2\2\u0142^\3\2\2\2\u0143\u0141\3\2\2\2\24\2\u00d9"+
		"\u00dc\u00e3\u00ed\u00f2\u00fc\u0107\u010d\u0114\u0116\u011b\u011f\u0123"+
		"\u0129\u012d\u013b\u0141\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}