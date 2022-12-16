// Generated from /Users/ahmed-korom/git/PDS-TP2-java/src/main/antlr/VSLLexer.g by ANTLR 4.9.2

  package TP2;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LP=3, RP=4, LC=5, RC=6, LB=7, RB=8, VG=9, VAR=10, VOID=11, 
		RETURN=12, PLUS=13, SOUS=14, MULT=15, DIV=16, IF=17, ELSE=18, THEN=19, 
		FI=20, WHILE=21, DO=22, DONE=23, AFFSYMBOL=24, PROTO=25, FUNC=26, PRINT=27, 
		READ=28, IDENT=29, TEXT=30, INTEGER=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "COMMENT", "LETTER", "DIGIT", "ASCII", "LP", "RP", "LC", "RC", 
			"LB", "RB", "VG", "VAR", "VOID", "RETURN", "PLUS", "SOUS", "MULT", "DIV", 
			"IF", "ELSE", "THEN", "FI", "WHILE", "DO", "DONE", "AFFSYMBOL", "PROTO", 
			"FUNC", "PRINT", "READ", "IDENT", "TEXT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'INT'", 
			"'VOID'", "'RETURN'", "'+'", "'-'", "'*'", "'/'", "'IF'", "'ELSE'", "'THEN'", 
			"'FI'", "'WHILE'", "'DO'", "'DONE'", "':='", "'PROTO'", "'FUNC'", "'PRINT'", 
			"'READ'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "LP", "RP", "LC", "RC", "LB", "RB", "VG", "VAR", 
			"VOID", "RETURN", "PLUS", "SOUS", "MULT", "DIV", "IF", "ELSE", "THEN", 
			"FI", "WHILE", "DO", "DONE", "AFFSYMBOL", "PROTO", "FUNC", "PRINT", "READ", 
			"IDENT", "TEXT", "INTEGER"
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


	public VSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "VSLLexer.g"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32:
			TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setText(getText().substring(1, getText().length() - 1)); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00d0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3P\n\3\f\3\16\3S\13"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\7!\u00bd"+
		"\n!\f!\16!\u00c0\13!\3\"\3\"\7\"\u00c4\n\"\f\"\16\"\u00c7\13\"\3\"\3\""+
		"\3\"\3#\6#\u00cd\n#\r#\16#\u00ce\2\2$\3\3\5\4\7\2\t\2\13\2\r\5\17\6\21"+
		"\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/"+
		"\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!\3\2\5\4\2\13\f\"\""+
		"\3\2\f\f\4\2\f\f$$\2\u00d1\2\3\3\2\2\2\2\5\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5K\3\2\2"+
		"\2\7V\3\2\2\2\tX\3\2\2\2\13Z\3\2\2\2\r\\\3\2\2\2\17^\3\2\2\2\21`\3\2\2"+
		"\2\23b\3\2\2\2\25d\3\2\2\2\27f\3\2\2\2\31h\3\2\2\2\33j\3\2\2\2\35n\3\2"+
		"\2\2\37s\3\2\2\2!z\3\2\2\2#|\3\2\2\2%~\3\2\2\2\'\u0080\3\2\2\2)\u0082"+
		"\3\2\2\2+\u0085\3\2\2\2-\u008a\3\2\2\2/\u008f\3\2\2\2\61\u0092\3\2\2\2"+
		"\63\u0098\3\2\2\2\65\u009b\3\2\2\2\67\u00a0\3\2\2\29\u00a3\3\2\2\2;\u00a9"+
		"\3\2\2\2=\u00ae\3\2\2\2?\u00b4\3\2\2\2A\u00b9\3\2\2\2C\u00c1\3\2\2\2E"+
		"\u00cc\3\2\2\2GH\t\2\2\2HI\3\2\2\2IJ\b\2\2\2J\4\3\2\2\2KL\7\61\2\2LM\7"+
		"\61\2\2MQ\3\2\2\2NP\n\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT"+
		"\3\2\2\2SQ\3\2\2\2TU\b\3\2\2U\6\3\2\2\2VW\4c|\2W\b\3\2\2\2XY\4\62;\2Y"+
		"\n\3\2\2\2Z[\n\4\2\2[\f\3\2\2\2\\]\7*\2\2]\16\3\2\2\2^_\7+\2\2_\20\3\2"+
		"\2\2`a\7}\2\2a\22\3\2\2\2bc\7\177\2\2c\24\3\2\2\2de\7]\2\2e\26\3\2\2\2"+
		"fg\7_\2\2g\30\3\2\2\2hi\7.\2\2i\32\3\2\2\2jk\7K\2\2kl\7P\2\2lm\7V\2\2"+
		"m\34\3\2\2\2no\7X\2\2op\7Q\2\2pq\7K\2\2qr\7F\2\2r\36\3\2\2\2st\7T\2\2"+
		"tu\7G\2\2uv\7V\2\2vw\7W\2\2wx\7T\2\2xy\7P\2\2y \3\2\2\2z{\7-\2\2{\"\3"+
		"\2\2\2|}\7/\2\2}$\3\2\2\2~\177\7,\2\2\177&\3\2\2\2\u0080\u0081\7\61\2"+
		"\2\u0081(\3\2\2\2\u0082\u0083\7K\2\2\u0083\u0084\7H\2\2\u0084*\3\2\2\2"+
		"\u0085\u0086\7G\2\2\u0086\u0087\7N\2\2\u0087\u0088\7U\2\2\u0088\u0089"+
		"\7G\2\2\u0089,\3\2\2\2\u008a\u008b\7V\2\2\u008b\u008c\7J\2\2\u008c\u008d"+
		"\7G\2\2\u008d\u008e\7P\2\2\u008e.\3\2\2\2\u008f\u0090\7H\2\2\u0090\u0091"+
		"\7K\2\2\u0091\60\3\2\2\2\u0092\u0093\7Y\2\2\u0093\u0094\7J\2\2\u0094\u0095"+
		"\7K\2\2\u0095\u0096\7N\2\2\u0096\u0097\7G\2\2\u0097\62\3\2\2\2\u0098\u0099"+
		"\7F\2\2\u0099\u009a\7Q\2\2\u009a\64\3\2\2\2\u009b\u009c\7F\2\2\u009c\u009d"+
		"\7Q\2\2\u009d\u009e\7P\2\2\u009e\u009f\7G\2\2\u009f\66\3\2\2\2\u00a0\u00a1"+
		"\7<\2\2\u00a1\u00a2\7?\2\2\u00a28\3\2\2\2\u00a3\u00a4\7R\2\2\u00a4\u00a5"+
		"\7T\2\2\u00a5\u00a6\7Q\2\2\u00a6\u00a7\7V\2\2\u00a7\u00a8\7Q\2\2\u00a8"+
		":\3\2\2\2\u00a9\u00aa\7H\2\2\u00aa\u00ab\7W\2\2\u00ab\u00ac\7P\2\2\u00ac"+
		"\u00ad\7E\2\2\u00ad<\3\2\2\2\u00ae\u00af\7R\2\2\u00af\u00b0\7T\2\2\u00b0"+
		"\u00b1\7K\2\2\u00b1\u00b2\7P\2\2\u00b2\u00b3\7V\2\2\u00b3>\3\2\2\2\u00b4"+
		"\u00b5\7T\2\2\u00b5\u00b6\7G\2\2\u00b6\u00b7\7C\2\2\u00b7\u00b8\7F\2\2"+
		"\u00b8@\3\2\2\2\u00b9\u00be\5\7\4\2\u00ba\u00bd\5\7\4\2\u00bb\u00bd\5"+
		"\t\5\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bfB\3\2\2\2\u00c0\u00be\3\2\2\2"+
		"\u00c1\u00c5\7$\2\2\u00c2\u00c4\5\13\6\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00c9\7$\2\2\u00c9\u00ca\b\"\3\2\u00caD\3\2\2\2\u00cb"+
		"\u00cd\5\t\5\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cfF\3\2\2\2\b\2Q\u00bc\u00be\u00c5\u00ce\4"+
		"\b\2\2\3\"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}