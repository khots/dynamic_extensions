// Generated from AQL.g4 by ANTLR 4.1
package edu.common.dynamicextensions.query.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AQLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, WS=3, SELECT=4, WHERE=5, NTHCHILD=6, BETWEEN=7, MTHS_BTWN=8, 
		YRS_BTWN=9, CURR_DATE=10, MINS_BTWN=11, COUNT=12, DISTINCT=13, LIMIT=14, 
		OR=15, AND=16, PAND=17, NOT=18, ROUND=19, LP=20, RP=21, MOP=22, SOP=23, 
		EOP=24, OP=25, INT=26, FLOAT=27, BOOL=28, YEAR=29, MONTH=30, DAY=31, DIGIT=32, 
		ID=33, FIELD=34, SLITERAL=35, ESC=36, ARITH_OP=37, ERROR=38, QUOTE=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'as'", "','", "WS", "'select'", "'where'", "'nthchild'", "'between'", 
		"'months_between'", "'years_between'", "'current_date'", "'minutes_between'", 
		"'count'", "'distinct'", "'limit'", "'or'", "'and'", "'pand'", "'not'", 
		"'round'", "'('", "')'", "MOP", "SOP", "EOP", "OP", "INT", "FLOAT", "BOOL", 
		"YEAR", "MONTH", "DAY", "DIGIT", "ID", "FIELD", "SLITERAL", "ESC", "ARITH_OP", 
		"ERROR", "'\"'"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "WS", "SELECT", "WHERE", "NTHCHILD", "BETWEEN", "MTHS_BTWN", 
		"YRS_BTWN", "CURR_DATE", "MINS_BTWN", "COUNT", "DISTINCT", "LIMIT", "OR", 
		"AND", "PAND", "NOT", "ROUND", "LP", "RP", "MOP", "SOP", "EOP", "OP", 
		"INT", "FLOAT", "BOOL", "YEAR", "MONTH", "DAY", "DIGIT", "ID", "FIELD", 
		"SLITERAL", "ESC", "ARITH_OP", "ERROR", "SGUTS", "QUOTE"
	};


	public AQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 2: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2)\u018e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\6\4Z\n\4\r\4\16\4[\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00ef\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u010d"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u011f\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u012d\n\32\3\33\5\33\u0130\n\33\3\33\6\33\u0133"+
		"\n\33\r\33\16\33\u0134\3\34\5\34\u0138\n\34\3\34\6\34\u013b\n\34\r\34"+
		"\16\34\u013c\3\34\3\34\6\34\u0141\n\34\r\34\16\34\u0142\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u014e\n\35\3\36\6\36\u0151\n\36\r"+
		"\36\16\36\u0152\3\36\3\36\3\37\6\37\u0158\n\37\r\37\16\37\u0159\3\37\3"+
		"\37\3 \6 \u015f\n \r \16 \u0160\3 \3 \3!\3!\3\"\3\"\7\"\u0169\n\"\f\""+
		"\16\"\u016c\13\"\3#\3#\5#\u0170\n#\3#\3#\3#\3#\7#\u0176\n#\f#\16#\u0179"+
		"\13#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\7(\u0188\n(\f(\16(\u018b"+
		"\13(\3)\3)\2*\3\3\1\5\4\1\7\5\2\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13"+
		"\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1"+
		"= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O\2\1Q)\1\3\2\13\5\2\13\f\17\17"+
		"\"\"\4\2>>@@\4\2[[{{\4\2OOoo\4\2FFff\5\2C\\aac|\7\2\62;AAC\\aac|\4\2$"+
		"$^^\5\2,-//\61\61\u01a4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2Q\3\2\2\2\3"+
		"S\3\2\2\2\5V\3\2\2\2\7Y\3\2\2\2\t_\3\2\2\2\13f\3\2\2\2\rl\3\2\2\2\17u"+
		"\3\2\2\2\21}\3\2\2\2\23\u008c\3\2\2\2\25\u009a\3\2\2\2\27\u00a7\3\2\2"+
		"\2\31\u00b7\3\2\2\2\33\u00bd\3\2\2\2\35\u00c6\3\2\2\2\37\u00cc\3\2\2\2"+
		"!\u00cf\3\2\2\2#\u00d3\3\2\2\2%\u00d8\3\2\2\2\'\u00dc\3\2\2\2)\u00e2\3"+
		"\2\2\2+\u00e4\3\2\2\2-\u00ee\3\2\2\2/\u010c\3\2\2\2\61\u011e\3\2\2\2\63"+
		"\u012c\3\2\2\2\65\u012f\3\2\2\2\67\u0137\3\2\2\29\u014d\3\2\2\2;\u0150"+
		"\3\2\2\2=\u0157\3\2\2\2?\u015e\3\2\2\2A\u0164\3\2\2\2C\u0166\3\2\2\2E"+
		"\u016f\3\2\2\2G\u017a\3\2\2\2I\u017e\3\2\2\2K\u0181\3\2\2\2M\u0183\3\2"+
		"\2\2O\u0189\3\2\2\2Q\u018c\3\2\2\2ST\7c\2\2TU\7u\2\2U\4\3\2\2\2VW\7.\2"+
		"\2W\6\3\2\2\2XZ\t\2\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\]\3"+
		"\2\2\2]^\b\4\2\2^\b\3\2\2\2_`\7u\2\2`a\7g\2\2ab\7n\2\2bc\7g\2\2cd\7e\2"+
		"\2de\7v\2\2e\n\3\2\2\2fg\7y\2\2gh\7j\2\2hi\7g\2\2ij\7t\2\2jk\7g\2\2k\f"+
		"\3\2\2\2lm\7p\2\2mn\7v\2\2no\7j\2\2op\7e\2\2pq\7j\2\2qr\7k\2\2rs\7n\2"+
		"\2st\7f\2\2t\16\3\2\2\2uv\7d\2\2vw\7g\2\2wx\7v\2\2xy\7y\2\2yz\7g\2\2z"+
		"{\7g\2\2{|\7p\2\2|\20\3\2\2\2}~\7o\2\2~\177\7q\2\2\177\u0080\7p\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7j\2\2\u0082\u0083\7u\2\2\u0083\u0084\7a\2\2"+
		"\u0084\u0085\7d\2\2\u0085\u0086\7g\2\2\u0086\u0087\7v\2\2\u0087\u0088"+
		"\7y\2\2\u0088\u0089\7g\2\2\u0089\u008a\7g\2\2\u008a\u008b\7p\2\2\u008b"+
		"\22\3\2\2\2\u008c\u008d\7{\2\2\u008d\u008e\7g\2\2\u008e\u008f\7c\2\2\u008f"+
		"\u0090\7t\2\2\u0090\u0091\7u\2\2\u0091\u0092\7a\2\2\u0092\u0093\7d\2\2"+
		"\u0093\u0094\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7y\2\2\u0096\u0097"+
		"\7g\2\2\u0097\u0098\7g\2\2\u0098\u0099\7p\2\2\u0099\24\3\2\2\2\u009a\u009b"+
		"\7e\2\2\u009b\u009c\7w\2\2\u009c\u009d\7t\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7g\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7a\2\2"+
		"\u00a2\u00a3\7f\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\26\3\2\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa"+
		"\7p\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7g\2\2\u00ad"+
		"\u00ae\7u\2\2\u00ae\u00af\7a\2\2\u00af\u00b0\7d\2\2\u00b0\u00b1\7g\2\2"+
		"\u00b1\u00b2\7v\2\2\u00b2\u00b3\7y\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5"+
		"\7g\2\2\u00b5\u00b6\7p\2\2\u00b6\30\3\2\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9"+
		"\7q\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7v\2\2\u00bc"+
		"\32\3\2\2\2\u00bd\u00be\7f\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7u\2\2\u00c0"+
		"\u00c1\7v\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7e\2\2"+
		"\u00c4\u00c5\7v\2\2\u00c5\34\3\2\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7"+
		"k\2\2\u00c8\u00c9\7o\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7v\2\2\u00cb\36"+
		"\3\2\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7t\2\2\u00ce \3\2\2\2\u00cf\u00d0"+
		"\7c\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7f\2\2\u00d2\"\3\2\2\2\u00d3\u00d4"+
		"\7r\2\2\u00d4\u00d5\7c\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7f\2\2\u00d7"+
		"$\3\2\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7v\2\2\u00db"+
		"&\3\2\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7w\2\2\u00df"+
		"\u00e0\7p\2\2\u00e0\u00e1\7f\2\2\u00e1(\3\2\2\2\u00e2\u00e3\7*\2\2\u00e3"+
		"*\3\2\2\2\u00e4\u00e5\7+\2\2\u00e5,\3\2\2\2\u00e6\u00e7\7k\2\2\u00e7\u00ef"+
		"\7p\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb\7v\2\2\u00eb"+
		"\u00ec\7\"\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ef\7p\2\2\u00ee\u00e6\3\2\2"+
		"\2\u00ee\u00e8\3\2\2\2\u00ef.\3\2\2\2\u00f0\u00f1\7e\2\2\u00f1\u00f2\7"+
		"q\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6"+
		"\7k\2\2\u00f6\u00f7\7p\2\2\u00f7\u010d\7u\2\2\u00f8\u00f9\7u\2\2\u00f9"+
		"\u00fa\7v\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd\7v\2\2"+
		"\u00fd\u00fe\7u\2\2\u00fe\u00ff\7\"\2\2\u00ff\u0100\7y\2\2\u0100\u0101"+
		"\7k\2\2\u0101\u0102\7v\2\2\u0102\u010d\7j\2\2\u0103\u0104\7g\2\2\u0104"+
		"\u0105\7p\2\2\u0105\u0106\7f\2\2\u0106\u0107\7u\2\2\u0107\u0108\7\"\2"+
		"\2\u0108\u0109\7y\2\2\u0109\u010a\7k\2\2\u010a\u010b\7v\2\2\u010b\u010d"+
		"\7j\2\2\u010c\u00f0\3\2\2\2\u010c\u00f8\3\2\2\2\u010c\u0103\3\2\2\2\u010d"+
		"\60\3\2\2\2\u010e\u010f\7g\2\2\u010f\u0110\7z\2\2\u0110\u0111\7k\2\2\u0111"+
		"\u0112\7u\2\2\u0112\u0113\7v\2\2\u0113\u011f\7u\2\2\u0114\u0115\7p\2\2"+
		"\u0115\u0116\7q\2\2\u0116\u0117\7v\2\2\u0117\u0118\7\"\2\2\u0118\u0119"+
		"\7g\2\2\u0119\u011a\7z\2\2\u011a\u011b\7k\2\2\u011b\u011c\7u\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011f\7u\2\2\u011e\u010e\3\2\2\2\u011e\u0114\3\2\2"+
		"\2\u011f\62\3\2\2\2\u0120\u012d\t\3\2\2\u0121\u0122\7@\2\2\u0122\u012d"+
		"\7?\2\2\u0123\u0124\7>\2\2\u0124\u012d\7?\2\2\u0125\u012d\7?\2\2\u0126"+
		"\u0127\7#\2\2\u0127\u012d\7?\2\2\u0128\u0129\7n\2\2\u0129\u012a\7k\2\2"+
		"\u012a\u012b\7m\2\2\u012b\u012d\7g\2\2\u012c\u0120\3\2\2\2\u012c\u0121"+
		"\3\2\2\2\u012c\u0123\3\2\2\2\u012c\u0125\3\2\2\2\u012c\u0126\3\2\2\2\u012c"+
		"\u0128\3\2\2\2\u012d\64\3\2\2\2\u012e\u0130\7/\2\2\u012f\u012e\3\2\2\2"+
		"\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u0133\5A!\2\u0132\u0131"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\66\3\2\2\2\u0136\u0138\7/\2\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2"+
		"\u0138\u013a\3\2\2\2\u0139\u013b\5A!\2\u013a\u0139\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\7\60\2\2\u013f\u0141\5A!\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u01438\3\2\2\2\u0144\u0145"+
		"\7v\2\2\u0145\u0146\7t\2\2\u0146\u0147\7w\2\2\u0147\u014e\7g\2\2\u0148"+
		"\u0149\7h\2\2\u0149\u014a\7c\2\2\u014a\u014b\7n\2\2\u014b\u014c\7u\2\2"+
		"\u014c\u014e\7g\2\2\u014d\u0144\3\2\2\2\u014d\u0148\3\2\2\2\u014e:\3\2"+
		"\2\2\u014f\u0151\5A!\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\t\4\2\2\u0155"+
		"<\3\2\2\2\u0156\u0158\5A!\2\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\t\5"+
		"\2\2\u015c>\3\2\2\2\u015d\u015f\5A!\2\u015e\u015d\3\2\2\2\u015f\u0160"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0163\t\6\2\2\u0163@\3\2\2\2\u0164\u0165\4\62;\2\u0165B\3\2\2\2\u0166"+
		"\u016a\t\7\2\2\u0167\u0169\t\b\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016bD\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016d\u0170\5\65\33\2\u016e\u0170\5C\"\2\u016f\u016d\3\2\2\2"+
		"\u016f\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7\60\2\2\u0172\u0177"+
		"\5C\"\2\u0173\u0174\7\60\2\2\u0174\u0176\5C\"\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178F\3\2\2\2"+
		"\u0179\u0177\3\2\2\2\u017a\u017b\7$\2\2\u017b\u017c\5O(\2\u017c\u017d"+
		"\7$\2\2\u017dH\3\2\2\2\u017e\u017f\7^\2\2\u017f\u0180\t\t\2\2\u0180J\3"+
		"\2\2\2\u0181\u0182\t\n\2\2\u0182L\3\2\2\2\u0183\u0184\13\2\2\2\u0184N"+
		"\3\2\2\2\u0185\u0188\5I%\2\u0186\u0188\n\t\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2"+
		"\2\2\u018aP\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u018d\7$\2\2\u018dR\3\2"+
		"\2\2\26\2[\u00ee\u010c\u011e\u012c\u012f\u0134\u0137\u013c\u0142\u014d"+
		"\u0152\u0159\u0160\u016a\u016f\u0177\u0187\u0189";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}