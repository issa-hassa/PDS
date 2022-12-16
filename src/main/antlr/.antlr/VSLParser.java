// Generated from /Users/ahmed-korom/git/PDS-TP2-java/src/main/antlr/VSLParser.g by ANTLR 4.9.2

  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LP=3, RP=4, LC=5, RC=6, LB=7, RB=8, VG=9, VAR=10, VOID=11, 
		RETURN=12, PLUS=13, SOUS=14, MULT=15, DIV=16, IF=17, ELSE=18, THEN=19, 
		FI=20, WHILE=21, DO=22, DONE=23, AFFSYMBOL=24, PROTO=25, FUNC=26, PRINT=27, 
		READ=28, IDENT=29, TEXT=30, INTEGER=31;
	public static final int
		RULE_program = 0, RULE_listFunc = 1, RULE_listDeclInstructions = 2, RULE_instructionRet = 3, 
		RULE_instructions = 4, RULE_declarations = 5, RULE_declaration = 6, RULE_instruction = 7, 
		RULE_instructionRead = 8, RULE_instructionprint = 9, RULE_printItems = 10, 
		RULE_printItem = 11, RULE_stringConst = 12, RULE_instructionBlock = 13, 
		RULE_affectation = 14, RULE_instructionif = 15, RULE_instructionfunction = 16, 
		RULE_listArg = 17, RULE_type = 18, RULE_instructionwhile = 19, RULE_listeExpression = 20, 
		RULE_expression = 21, RULE_factor = 22, RULE_primary = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "listFunc", "listDeclInstructions", "instructionRet", "instructions", 
			"declarations", "declaration", "instruction", "instructionRead", "instructionprint", 
			"printItems", "printItem", "stringConst", "instructionBlock", "affectation", 
			"instructionif", "instructionfunction", "listArg", "type", "instructionwhile", 
			"listeExpression", "expression", "factor", "primary"
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

	@Override
	public String getGrammarFileName() { return "VSLParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TP2.ASD.Program out;
		public ListFuncContext i;
		public TerminalNode EOF() { return getToken(VSLParser.EOF, 0); }
		public ListFuncContext listFunc() {
			return getRuleContext(ListFuncContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			((ProgramContext)_localctx).i = listFunc();
			setState(49);
			match(EOF);
			 ((ProgramContext)_localctx).out =  new TP2.ASD.Program(((ProgramContext)_localctx).i.out); 
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

	public static class ListFuncContext extends ParserRuleContext {
		public ArrayList<TP2.ASD.Instruction.Instruction> out;
		public InstructionfunctionContext f;
		public List<InstructionfunctionContext> instructionfunction() {
			return getRuleContexts(InstructionfunctionContext.class);
		}
		public InstructionfunctionContext instructionfunction(int i) {
			return getRuleContext(InstructionfunctionContext.class,i);
		}
		public ListFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFunc; }
	}

	public final ListFuncContext listFunc() throws RecognitionException {
		ListFuncContext _localctx = new ListFuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ListFuncContext)_localctx).out =  new ArrayList<>();
			setState(53);
			((ListFuncContext)_localctx).f = instructionfunction();
			_localctx.out.add(((ListFuncContext)_localctx).f.out);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROTO || _la==FUNC) {
				{
				{
				setState(55);
				((ListFuncContext)_localctx).f = instructionfunction();
				_localctx.out.add(((ListFuncContext)_localctx).f.out);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ListDeclInstructionsContext extends ParserRuleContext {
		public ArrayList<TP2.ASD.Instruction.Instruction> out;
		public DeclarationsContext d;
		public InstructionsContext i;
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public ListDeclInstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDeclInstructions; }
	}

	public final ListDeclInstructionsContext listDeclInstructions() throws RecognitionException {
		ListDeclInstructionsContext _localctx = new ListDeclInstructionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listDeclInstructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ListDeclInstructionsContext)_localctx).out =  new ArrayList<>();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(64);
				((ListDeclInstructionsContext)_localctx).d = declarations();
				 _localctx.out.addAll(((ListDeclInstructionsContext)_localctx).d.out);
				}
			}

			setState(69);
			((ListDeclInstructionsContext)_localctx).i = instructions();
			 _localctx.out.addAll(((ListDeclInstructionsContext)_localctx).i.out);
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

	public static class InstructionRetContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public ExpressionContext e;
		public TerminalNode RETURN() { return getToken(VSLParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionRetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionRet; }
	}

	public final InstructionRetContext instructionRet() throws RecognitionException {
		InstructionRetContext _localctx = new InstructionRetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instructionRet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(RETURN);
			setState(73);
			((InstructionRetContext)_localctx).e = expression(0);
			((InstructionRetContext)_localctx).out =  new TP2.ASD.Instruction.InstructionRet(((InstructionRetContext)_localctx).e.out);
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

	public static class InstructionsContext extends ParserRuleContext {
		public ArrayList<TP2.ASD.Instruction.Instruction> out;
		public InstructionContext i;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((InstructionsContext)_localctx).out =  new ArrayList<>();
			setState(77);
			((InstructionsContext)_localctx).i = instruction();
			_localctx.out.add(((InstructionsContext)_localctx).i.out) ;
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LC) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << PROTO) | (1L << FUNC) | (1L << PRINT) | (1L << READ) | (1L << IDENT))) != 0)) {
				{
				{
				setState(79);
				((InstructionsContext)_localctx).i = instruction();
				_localctx.out.add(((InstructionsContext)_localctx).i.out) ;
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public List<TP2.ASD.Declaration.Declaration> out;
		public DeclarationContext d;
		public TerminalNode VAR() { return getToken(VSLParser.VAR, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> VG() { return getTokens(VSLParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(VSLParser.VG, i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclarationsContext)_localctx).out =  new ArrayList<>(); 
			{
			setState(88);
			match(VAR);
			setState(89);
			((DeclarationsContext)_localctx).d = declaration();
			_localctx.out.add(((DeclarationsContext)_localctx).d.out);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(91);
				match(VG);
				setState(92);
				((DeclarationsContext)_localctx).d = declaration();
				_localctx.out.add(((DeclarationsContext)_localctx).d.out);
				}
				}
				setState(99);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TP2.ASD.Declaration.Declaration out;
		public Token IDENT;
		public Token INTEGER;
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public TerminalNode LB() { return getToken(VSLParser.LB, 0); }
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode RB() { return getToken(VSLParser.RB, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				((DeclarationContext)_localctx).IDENT = match(IDENT);
				 ((DeclarationContext)_localctx).out =  new TP2.ASD.Declaration.DeclarationInt (((DeclarationContext)_localctx).IDENT.getText()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((DeclarationContext)_localctx).IDENT = match(IDENT);
				setState(103);
				match(LB);
				setState(104);
				((DeclarationContext)_localctx).INTEGER = match(INTEGER);
				setState(105);
				match(RB);
				((DeclarationContext)_localctx).out =  new TP2.ASD.Declaration.DeclarationTab(((DeclarationContext)_localctx).IDENT.getText(), (((DeclarationContext)_localctx).INTEGER!=null?Integer.valueOf(((DeclarationContext)_localctx).INTEGER.getText()):0));
						
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

	public static class InstructionContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public AffectationContext a;
		public InstructionifContext i;
		public InstructionfunctionContext f;
		public InstructionwhileContext w;
		public InstructionBlockContext b;
		public InstructionRetContext ret;
		public InstructionprintContext p;
		public InstructionReadContext r;
		public AffectationContext affectation() {
			return getRuleContext(AffectationContext.class,0);
		}
		public InstructionifContext instructionif() {
			return getRuleContext(InstructionifContext.class,0);
		}
		public InstructionfunctionContext instructionfunction() {
			return getRuleContext(InstructionfunctionContext.class,0);
		}
		public InstructionwhileContext instructionwhile() {
			return getRuleContext(InstructionwhileContext.class,0);
		}
		public InstructionBlockContext instructionBlock() {
			return getRuleContext(InstructionBlockContext.class,0);
		}
		public InstructionRetContext instructionRet() {
			return getRuleContext(InstructionRetContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(VSLParser.PRINT, 0); }
		public InstructionprintContext instructionprint() {
			return getRuleContext(InstructionprintContext.class,0);
		}
		public TerminalNode READ() { return getToken(VSLParser.READ, 0); }
		public InstructionReadContext instructionRead() {
			return getRuleContext(InstructionReadContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instruction);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				((InstructionContext)_localctx).a = affectation();
				 ((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).a.out; 
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				((InstructionContext)_localctx).i = instructionif();
				 ((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).i.out ;
				}
				break;
			case PROTO:
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				((InstructionContext)_localctx).f = instructionfunction();
				 ((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).f.out ;
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				((InstructionContext)_localctx).w = instructionwhile();
				 ((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).w.out; 
				}
				break;
			case LC:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				((InstructionContext)_localctx).b = instructionBlock();
				((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).b.out;  
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				((InstructionContext)_localctx).ret = instructionRet();
				((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).ret.out;  
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(127);
				match(PRINT);
				setState(128);
				((InstructionContext)_localctx).p = instructionprint();
				 ((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).p.out ;
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				match(READ);
				setState(132);
				((InstructionContext)_localctx).r = instructionRead();
				 ((InstructionContext)_localctx).out =  ((InstructionContext)_localctx).r.out ;
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

	public static class InstructionReadContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public Token i;
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public InstructionReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionRead; }
	}

	public final InstructionReadContext instructionRead() throws RecognitionException {
		InstructionReadContext _localctx = new InstructionReadContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instructionRead);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ArrayList<String> idents = new ArrayList<>(); 
			setState(140); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(138);
					((InstructionReadContext)_localctx).i = match(IDENT);
					idents.add(((InstructionReadContext)_localctx).i.getText());
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(142); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			 ((InstructionReadContext)_localctx).out =  new  TP2.ASD.Instruction.InstructionRead(idents) ; 
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

	public static class InstructionprintContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public PrintItemsContext printItems;
		public PrintItemsContext printItems() {
			return getRuleContext(PrintItemsContext.class,0);
		}
		public InstructionprintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionprint; }
	}

	public final InstructionprintContext instructionprint() throws RecognitionException {
		InstructionprintContext _localctx = new InstructionprintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instructionprint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((InstructionprintContext)_localctx).printItems = printItems();
			((InstructionprintContext)_localctx).out =  new  TP2.ASD.Instruction.InstructionPrint(((InstructionprintContext)_localctx).printItems.out) ;
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

	public static class PrintItemsContext extends ParserRuleContext {
		public ArrayList <TP2 .ASD .Expression .Expression> out;
		public PrintItemContext e;
		public List<PrintItemContext> printItem() {
			return getRuleContexts(PrintItemContext.class);
		}
		public PrintItemContext printItem(int i) {
			return getRuleContext(PrintItemContext.class,i);
		}
		public List<TerminalNode> VG() { return getTokens(VSLParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(VSLParser.VG, i);
		}
		public PrintItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printItems; }
	}

	public final PrintItemsContext printItems() throws RecognitionException {
		PrintItemsContext _localctx = new PrintItemsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_printItems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((PrintItemsContext)_localctx).out =  new ArrayList<>();
			setState(150);
			((PrintItemsContext)_localctx).e = printItem();
			_localctx.out.add(((PrintItemsContext)_localctx).e.out); 
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(152);
				match(VG);
				setState(153);
				((PrintItemsContext)_localctx).e = printItem();
				_localctx.out.add(((PrintItemsContext)_localctx).e.out);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PrintItemContext extends ParserRuleContext {
		public TP2.ASD.Expression.Expression out;
		public StringConstContext t;
		public ExpressionContext e;
		public StringConstContext stringConst() {
			return getRuleContext(StringConstContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printItem; }
	}

	public final PrintItemContext printItem() throws RecognitionException {
		PrintItemContext _localctx = new PrintItemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_printItem);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				((PrintItemContext)_localctx).t = stringConst();
				((PrintItemContext)_localctx).out =  ((PrintItemContext)_localctx).t.out;
				}
				break;
			case LP:
			case IDENT:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				((PrintItemContext)_localctx).e = expression(0);
				 ((PrintItemContext)_localctx).out =  ((PrintItemContext)_localctx).e.out;
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

	public static class StringConstContext extends ParserRuleContext {
		public TP2.ASD.Expression.Expression out;
		public Token TEXT;
		public TerminalNode TEXT() { return getToken(VSLParser.TEXT, 0); }
		public StringConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConst; }
	}

	public final StringConstContext stringConst() throws RecognitionException {
		StringConstContext _localctx = new StringConstContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stringConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((StringConstContext)_localctx).TEXT = match(TEXT);
			 ((StringConstContext)_localctx).out =  new TP2.ASD.Expression.TextExpression(((StringConstContext)_localctx).TEXT.getText()); 
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

	public static class InstructionBlockContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public ListDeclInstructionsContext i;
		public TerminalNode LC() { return getToken(VSLParser.LC, 0); }
		public TerminalNode RC() { return getToken(VSLParser.RC, 0); }
		public ListDeclInstructionsContext listDeclInstructions() {
			return getRuleContext(ListDeclInstructionsContext.class,0);
		}
		public InstructionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionBlock; }
	}

	public final InstructionBlockContext instructionBlock() throws RecognitionException {
		InstructionBlockContext _localctx = new InstructionBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_instructionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(LC);
			setState(173);
			((InstructionBlockContext)_localctx).i = listDeclInstructions();
			setState(174);
			match(RC);
			 ((InstructionBlockContext)_localctx).out =  new TP2.ASD.Instruction.InstructionBlock(((InstructionBlockContext)_localctx).i.out);
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

	public static class AffectationContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public Token IDENT;
		public ExpressionContext e;
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public TerminalNode AFFSYMBOL() { return getToken(VSLParser.AFFSYMBOL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AffectationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectation; }
	}

	public final AffectationContext affectation() throws RecognitionException {
		AffectationContext _localctx = new AffectationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			((AffectationContext)_localctx).IDENT = match(IDENT);
			setState(178);
			match(AFFSYMBOL);
			setState(179);
			((AffectationContext)_localctx).e = expression(0);
			((AffectationContext)_localctx).out =  new TP2.ASD.Instruction.AffectationInt(((AffectationContext)_localctx).IDENT.getText(),((AffectationContext)_localctx).e.out);
					
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

	public static class InstructionifContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public ExpressionContext e;
		public InstructionsContext i;
		public InstructionsContext i2;
		public TerminalNode IF() { return getToken(VSLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(VSLParser.THEN, 0); }
		public TerminalNode FI() { return getToken(VSLParser.FI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(VSLParser.ELSE, 0); }
		public InstructionifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionif; }
	}

	public final InstructionifContext instructionif() throws RecognitionException {
		InstructionifContext _localctx = new InstructionifContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instructionif);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(IF);
				setState(183);
				((InstructionifContext)_localctx).e = expression(0);
				setState(184);
				match(THEN);
				setState(185);
				((InstructionifContext)_localctx).i = instructions();
				setState(186);
				match(FI);
				((InstructionifContext)_localctx).out =  new TP2.ASD.Instruction.InstructionIf(((InstructionifContext)_localctx).e.out,((InstructionifContext)_localctx).i.out); 
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(IF);
				setState(190);
				((InstructionifContext)_localctx).e = expression(0);
				setState(191);
				match(THEN);
				setState(192);
				((InstructionifContext)_localctx).i = instructions();
				setState(193);
				match(ELSE);
				setState(194);
				((InstructionifContext)_localctx).i2 = instructions();
				setState(195);
				match(FI);
				((InstructionifContext)_localctx).out =  new TP2.ASD.Instruction.InstructionIf(((InstructionifContext)_localctx).e.out,((InstructionifContext)_localctx).i.out,((InstructionifContext)_localctx).i2.out); 
						
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

	public static class InstructionfunctionContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public TypeContext t;
		public Token id;
		public ListArgContext l;
		public InstructionBlockContext b;
		public TerminalNode FUNC() { return getToken(VSLParser.FUNC, 0); }
		public TerminalNode LP() { return getToken(VSLParser.LP, 0); }
		public TerminalNode RP() { return getToken(VSLParser.RP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public ListArgContext listArg() {
			return getRuleContext(ListArgContext.class,0);
		}
		public InstructionBlockContext instructionBlock() {
			return getRuleContext(InstructionBlockContext.class,0);
		}
		public TerminalNode PROTO() { return getToken(VSLParser.PROTO, 0); }
		public InstructionfunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionfunction; }
	}

	public final InstructionfunctionContext instructionfunction() throws RecognitionException {
		InstructionfunctionContext _localctx = new InstructionfunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_instructionfunction);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(FUNC);
				setState(201);
				((InstructionfunctionContext)_localctx).t = type();
				setState(202);
				((InstructionfunctionContext)_localctx).id = match(IDENT);
				setState(203);
				match(LP);
				setState(204);
				((InstructionfunctionContext)_localctx).l = listArg();
				setState(205);
				match(RP);
				setState(206);
				((InstructionfunctionContext)_localctx).b = instructionBlock();
				((InstructionfunctionContext)_localctx).out =  new TP2.ASD.Instruction.InstructionFunc(((InstructionfunctionContext)_localctx).id.getText(),((InstructionfunctionContext)_localctx).t.out,((InstructionfunctionContext)_localctx).l.out,((InstructionfunctionContext)_localctx).b.out);
						
				}
				break;
			case PROTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(PROTO);
				setState(210);
				((InstructionfunctionContext)_localctx).t = type();
				setState(211);
				((InstructionfunctionContext)_localctx).id = match(IDENT);
				setState(212);
				match(LP);
				setState(213);
				((InstructionfunctionContext)_localctx).l = listArg();
				setState(214);
				match(RP);
				((InstructionfunctionContext)_localctx).out =  new TP2.ASD.Instruction.InstructionProto(((InstructionfunctionContext)_localctx).id.getText(),((InstructionfunctionContext)_localctx).t.out,((InstructionfunctionContext)_localctx).l.out);
						
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

	public static class ListArgContext extends ParserRuleContext {
		public ArrayList<String> out;
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(VSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VSLParser.IDENT, i);
		}
		public List<TerminalNode> VG() { return getTokens(VSLParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(VSLParser.VG, i);
		}
		public ListArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listArg; }
	}

	public final ListArgContext listArg() throws RecognitionException {
		ListArgContext _localctx = new ListArgContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ListArgContext)_localctx).out =  new ArrayList<String>();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(220);
				((ListArgContext)_localctx).IDENT = match(IDENT);
				_localctx.out.add(((ListArgContext)_localctx).IDENT.getText());
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VG) {
					{
					{
					setState(222);
					match(VG);
					setState(223);
					((ListArgContext)_localctx).IDENT = match(IDENT);
					_localctx.out.add(((ListArgContext)_localctx).IDENT.getText());
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class TypeContext extends ParserRuleContext {
		public TP2.ASD.Type.Type out;
		public TerminalNode VAR() { return getToken(VSLParser.VAR, 0); }
		public TerminalNode VOID() { return getToken(VSLParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(VAR);
				((TypeContext)_localctx).out =  new TP2.ASD.Type.Int();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(VOID);
				((TypeContext)_localctx).out =  new TP2.ASD.Type.Void();
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

	public static class InstructionwhileContext extends ParserRuleContext {
		public TP2.ASD.Instruction.Instruction out;
		public ExpressionContext e;
		public InstructionBlockContext s;
		public TerminalNode WHILE() { return getToken(VSLParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(VSLParser.DO, 0); }
		public TerminalNode DONE() { return getToken(VSLParser.DONE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionBlockContext instructionBlock() {
			return getRuleContext(InstructionBlockContext.class,0);
		}
		public InstructionwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionwhile; }
	}

	public final InstructionwhileContext instructionwhile() throws RecognitionException {
		InstructionwhileContext _localctx = new InstructionwhileContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_instructionwhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(WHILE);
			setState(239);
			((InstructionwhileContext)_localctx).e = expression(0);
			setState(240);
			match(DO);
			setState(241);
			((InstructionwhileContext)_localctx).s = instructionBlock();
			setState(242);
			match(DONE);
			((InstructionwhileContext)_localctx).out =  new TP2.ASD.Instruction.InstructionWhile(((InstructionwhileContext)_localctx).e.out,((InstructionwhileContext)_localctx).s.out);
					
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

	public static class ListeExpressionContext extends ParserRuleContext {
		public ArrayList<TP2.ASD.Expression.Expression> out;
		public ExpressionContext e;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> VG() { return getTokens(VSLParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(VSLParser.VG, i);
		}
		public ListeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listeExpression; }
	}

	public final ListeExpressionContext listeExpression() throws RecognitionException {
		ListeExpressionContext _localctx = new ListeExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_listeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ListeExpressionContext)_localctx).out =  new ArrayList<>();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(246);
				((ListeExpressionContext)_localctx).e = expression(0);
				 _localctx.out.add(((ListeExpressionContext)_localctx).e.out); 
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VG) {
					{
					{
					setState(248);
					match(VG);
					setState(249);
					((ListeExpressionContext)_localctx).e = expression(0);
					 _localctx.out.add(((ListeExpressionContext)_localctx).e.out); 
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public TP2.ASD.Expression.Expression out;
		public ExpressionContext r;
		public FactorContext f;
		public FactorContext l;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(VSLParser.PLUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SOUS() { return getToken(VSLParser.SOUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(263);
			((ExpressionContext)_localctx).f = factor();
			((ExpressionContext)_localctx).out = ((ExpressionContext)_localctx).f.out; 
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(276);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.r = _prevctx;
						_localctx.r = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(266);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(267);
						match(PLUS);
						setState(268);
						((ExpressionContext)_localctx).l = factor();
						 ((ExpressionContext)_localctx).out =  new TP2.ASD.Expression.AddExpression(((ExpressionContext)_localctx).l.out, ((ExpressionContext)_localctx).r.out); 
						          			
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.r = _prevctx;
						_localctx.r = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(272);
						match(SOUS);
						setState(273);
						((ExpressionContext)_localctx).l = factor();
						 ((ExpressionContext)_localctx).out =  new TP2.ASD.Expression.SousExpression(((ExpressionContext)_localctx).r.out, ((ExpressionContext)_localctx).l.out); 
						          		
						}
						break;
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public TP2.ASD.Expression.Expression out;
		public PrimaryContext p;
		public PrimaryContext l;
		public PrimaryContext r;
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public TerminalNode MULT() { return getToken(VSLParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(VSLParser.DIV, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_factor);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				((FactorContext)_localctx).p = primary();
				 ((FactorContext)_localctx).out =  ((FactorContext)_localctx).p.out; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				((FactorContext)_localctx).l = primary();
				setState(285);
				match(MULT);
				setState(286);
				((FactorContext)_localctx).r = primary();
				 ((FactorContext)_localctx).out =  new TP2.ASD.Expression.MultExpression(((FactorContext)_localctx).l.out, ((FactorContext)_localctx).r.out); 
							
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(289);
				((FactorContext)_localctx).r = primary();
				setState(290);
				match(DIV);
				setState(291);
				((FactorContext)_localctx).l = primary();
				 ((FactorContext)_localctx).out = new  TP2.ASD.Expression.DivExpression(((FactorContext)_localctx).r.out, ((FactorContext)_localctx).l.out); 
							
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

	public static class PrimaryContext extends ParserRuleContext {
		public TP2.ASD.Expression.Expression out;
		public Token INTEGER;
		public ExpressionContext e;
		public Token IDENT;
		public Token i;
		public ListeExpressionContext l;
		public TerminalNode INTEGER() { return getToken(VSLParser.INTEGER, 0); }
		public TerminalNode LP() { return getToken(VSLParser.LP, 0); }
		public TerminalNode RP() { return getToken(VSLParser.RP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(VSLParser.IDENT, 0); }
		public ListeExpressionContext listeExpression() {
			return getRuleContext(ListeExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primary);
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((PrimaryContext)_localctx).INTEGER = match(INTEGER);
				 ((PrimaryContext)_localctx).out =  new TP2.ASD.Expression.IntegerExpression((((PrimaryContext)_localctx).INTEGER!=null?Integer.valueOf(((PrimaryContext)_localctx).INTEGER.getText()):0)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(LP);
				setState(299);
				((PrimaryContext)_localctx).e = expression(0);
				setState(300);
				match(RP);
				 ((PrimaryContext)_localctx).out =  ((PrimaryContext)_localctx).e.out ;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				((PrimaryContext)_localctx).IDENT = match(IDENT);
				((PrimaryContext)_localctx).out =  new TP2.ASD.Expression.VarIntExpression(((PrimaryContext)_localctx).IDENT.getText());
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
				((PrimaryContext)_localctx).i = match(IDENT);
				setState(306);
				match(LP);
				setState(307);
				((PrimaryContext)_localctx).l = listeExpression();
				setState(308);
				match(RP);
				((PrimaryContext)_localctx).out =  new TP2.ASD.Expression.AppelFun(((PrimaryContext)_localctx).i.getText(),((PrimaryContext)_localctx).l.out);
						
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\4\3"+
		"\4\3\4\3\4\5\4F\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\7\6U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7b\n\7\f"+
		"\7\16\7e\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u008a\n\t\3\n\3\n\3\n\6\n\u008f\n\n\r\n\16\n\u0090"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009f\n\f\f\f"+
		"\16\f\u00a2\13\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00aa\n\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00c9"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00dc\n\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u00e4\n\23\f\23\16\23\u00e7\13\23\5\23\u00e9\n\23\3\24\3\24\3\24\3\24"+
		"\5\24\u00ef\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\7\26\u00ff\n\26\f\26\16\26\u0102\13\26\7\26\u0104\n\26"+
		"\f\26\16\26\u0107\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\7\27\u0117\n\27\f\27\16\27\u011a\13\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0129"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u013a\n\31\3\31\2\3,\32\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\2\2\2\u0140\2\62\3\2\2\2\4\66\3\2\2\2\6A\3\2\2\2"+
		"\bJ\3\2\2\2\nN\3\2\2\2\fY\3\2\2\2\16m\3\2\2\2\20\u0089\3\2\2\2\22\u008b"+
		"\3\2\2\2\24\u0094\3\2\2\2\26\u0097\3\2\2\2\30\u00a9\3\2\2\2\32\u00ab\3"+
		"\2\2\2\34\u00ae\3\2\2\2\36\u00b3\3\2\2\2 \u00c8\3\2\2\2\"\u00db\3\2\2"+
		"\2$\u00dd\3\2\2\2&\u00ee\3\2\2\2(\u00f0\3\2\2\2*\u00f7\3\2\2\2,\u0108"+
		"\3\2\2\2.\u0128\3\2\2\2\60\u0139\3\2\2\2\62\63\5\4\3\2\63\64\7\2\2\3\64"+
		"\65\b\2\1\2\65\3\3\2\2\2\66\67\b\3\1\2\678\5\"\22\28>\b\3\1\29:\5\"\22"+
		"\2:;\b\3\1\2;=\3\2\2\2<9\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\5\3\2"+
		"\2\2@>\3\2\2\2AE\b\4\1\2BC\5\f\7\2CD\b\4\1\2DF\3\2\2\2EB\3\2\2\2EF\3\2"+
		"\2\2FG\3\2\2\2GH\5\n\6\2HI\b\4\1\2I\7\3\2\2\2JK\7\16\2\2KL\5,\27\2LM\b"+
		"\5\1\2M\t\3\2\2\2NO\b\6\1\2OP\5\20\t\2PV\b\6\1\2QR\5\20\t\2RS\b\6\1\2"+
		"SU\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2\2"+
		"\2YZ\b\7\1\2Z[\7\f\2\2[\\\5\16\b\2\\c\b\7\1\2]^\7\13\2\2^_\5\16\b\2_`"+
		"\b\7\1\2`b\3\2\2\2a]\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\r\3\2\2\2"+
		"ec\3\2\2\2fg\7\37\2\2gn\b\b\1\2hi\7\37\2\2ij\7\t\2\2jk\7!\2\2kl\7\n\2"+
		"\2ln\b\b\1\2mf\3\2\2\2mh\3\2\2\2n\17\3\2\2\2op\5\36\20\2pq\b\t\1\2q\u008a"+
		"\3\2\2\2rs\5 \21\2st\b\t\1\2t\u008a\3\2\2\2uv\5\"\22\2vw\b\t\1\2w\u008a"+
		"\3\2\2\2xy\5(\25\2yz\b\t\1\2z\u008a\3\2\2\2{|\5\34\17\2|}\b\t\1\2}\u008a"+
		"\3\2\2\2~\177\5\b\5\2\177\u0080\b\t\1\2\u0080\u008a\3\2\2\2\u0081\u0082"+
		"\7\35\2\2\u0082\u0083\5\24\13\2\u0083\u0084\b\t\1\2\u0084\u008a\3\2\2"+
		"\2\u0085\u0086\7\36\2\2\u0086\u0087\5\22\n\2\u0087\u0088\b\t\1\2\u0088"+
		"\u008a\3\2\2\2\u0089o\3\2\2\2\u0089r\3\2\2\2\u0089u\3\2\2\2\u0089x\3\2"+
		"\2\2\u0089{\3\2\2\2\u0089~\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0085\3\2"+
		"\2\2\u008a\21\3\2\2\2\u008b\u008e\b\n\1\2\u008c\u008d\7\37\2\2\u008d\u008f"+
		"\b\n\1\2\u008e\u008c\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\n\1\2\u0093\23\3\2\2"+
		"\2\u0094\u0095\5\26\f\2\u0095\u0096\b\13\1\2\u0096\25\3\2\2\2\u0097\u0098"+
		"\b\f\1\2\u0098\u0099\5\30\r\2\u0099\u00a0\b\f\1\2\u009a\u009b\7\13\2\2"+
		"\u009b\u009c\5\30\r\2\u009c\u009d\b\f\1\2\u009d\u009f\3\2\2\2\u009e\u009a"+
		"\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\27\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\5\32\16\2\u00a4\u00a5\b\r"+
		"\1\2\u00a5\u00aa\3\2\2\2\u00a6\u00a7\5,\27\2\u00a7\u00a8\b\r\1\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\31\3\2\2"+
		"\2\u00ab\u00ac\7 \2\2\u00ac\u00ad\b\16\1\2\u00ad\33\3\2\2\2\u00ae\u00af"+
		"\7\7\2\2\u00af\u00b0\5\6\4\2\u00b0\u00b1\7\b\2\2\u00b1\u00b2\b\17\1\2"+
		"\u00b2\35\3\2\2\2\u00b3\u00b4\7\37\2\2\u00b4\u00b5\7\32\2\2\u00b5\u00b6"+
		"\5,\27\2\u00b6\u00b7\b\20\1\2\u00b7\37\3\2\2\2\u00b8\u00b9\7\23\2\2\u00b9"+
		"\u00ba\5,\27\2\u00ba\u00bb\7\25\2\2\u00bb\u00bc\5\n\6\2\u00bc\u00bd\7"+
		"\26\2\2\u00bd\u00be\b\21\1\2\u00be\u00c9\3\2\2\2\u00bf\u00c0\7\23\2\2"+
		"\u00c0\u00c1\5,\27\2\u00c1\u00c2\7\25\2\2\u00c2\u00c3\5\n\6\2\u00c3\u00c4"+
		"\7\24\2\2\u00c4\u00c5\5\n\6\2\u00c5\u00c6\7\26\2\2\u00c6\u00c7\b\21\1"+
		"\2\u00c7\u00c9\3\2\2\2\u00c8\u00b8\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c9!"+
		"\3\2\2\2\u00ca\u00cb\7\34\2\2\u00cb\u00cc\5&\24\2\u00cc\u00cd\7\37\2\2"+
		"\u00cd\u00ce\7\5\2\2\u00ce\u00cf\5$\23\2\u00cf\u00d0\7\6\2\2\u00d0\u00d1"+
		"\5\34\17\2\u00d1\u00d2\b\22\1\2\u00d2\u00dc\3\2\2\2\u00d3\u00d4\7\33\2"+
		"\2\u00d4\u00d5\5&\24\2\u00d5\u00d6\7\37\2\2\u00d6\u00d7\7\5\2\2\u00d7"+
		"\u00d8\5$\23\2\u00d8\u00d9\7\6\2\2\u00d9\u00da\b\22\1\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00ca\3\2\2\2\u00db\u00d3\3\2\2\2\u00dc#\3\2\2\2\u00dd\u00e8"+
		"\b\23\1\2\u00de\u00df\7\37\2\2\u00df\u00e5\b\23\1\2\u00e0\u00e1\7\13\2"+
		"\2\u00e1\u00e2\7\37\2\2\u00e2\u00e4\b\23\1\2\u00e3\u00e0\3\2\2\2\u00e4"+
		"\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e9\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00de\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"%\3\2\2\2\u00ea\u00eb\7\f\2\2\u00eb\u00ef\b\24\1\2\u00ec\u00ed\7\r\2\2"+
		"\u00ed\u00ef\b\24\1\2\u00ee\u00ea\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\'"+
		"\3\2\2\2\u00f0\u00f1\7\27\2\2\u00f1\u00f2\5,\27\2\u00f2\u00f3\7\30\2\2"+
		"\u00f3\u00f4\5\34\17\2\u00f4\u00f5\7\31\2\2\u00f5\u00f6\b\25\1\2\u00f6"+
		")\3\2\2\2\u00f7\u0105\b\26\1\2\u00f8\u00f9\5,\27\2\u00f9\u0100\b\26\1"+
		"\2\u00fa\u00fb\7\13\2\2\u00fb\u00fc\5,\27\2\u00fc\u00fd\b\26\1\2\u00fd"+
		"\u00ff\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0103"+
		"\u00f8\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106+\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\b\27\1\2\u0109\u010a"+
		"\5.\30\2\u010a\u010b\b\27\1\2\u010b\u0118\3\2\2\2\u010c\u010d\f\5\2\2"+
		"\u010d\u010e\7\17\2\2\u010e\u010f\5.\30\2\u010f\u0110\b\27\1\2\u0110\u0117"+
		"\3\2\2\2\u0111\u0112\f\4\2\2\u0112\u0113\7\20\2\2\u0113\u0114\5.\30\2"+
		"\u0114\u0115\b\27\1\2\u0115\u0117\3\2\2\2\u0116\u010c\3\2\2\2\u0116\u0111"+
		"\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"-\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\5\60\31\2\u011c\u011d\b\30\1"+
		"\2\u011d\u0129\3\2\2\2\u011e\u011f\5\60\31\2\u011f\u0120\7\21\2\2\u0120"+
		"\u0121\5\60\31\2\u0121\u0122\b\30\1\2\u0122\u0129\3\2\2\2\u0123\u0124"+
		"\5\60\31\2\u0124\u0125\7\22\2\2\u0125\u0126\5\60\31\2\u0126\u0127\b\30"+
		"\1\2\u0127\u0129\3\2\2\2\u0128\u011b\3\2\2\2\u0128\u011e\3\2\2\2\u0128"+
		"\u0123\3\2\2\2\u0129/\3\2\2\2\u012a\u012b\7!\2\2\u012b\u013a\b\31\1\2"+
		"\u012c\u012d\7\5\2\2\u012d\u012e\5,\27\2\u012e\u012f\7\6\2\2\u012f\u0130"+
		"\b\31\1\2\u0130\u013a\3\2\2\2\u0131\u0132\7\37\2\2\u0132\u013a\b\31\1"+
		"\2\u0133\u0134\7\37\2\2\u0134\u0135\7\5\2\2\u0135\u0136\5*\26\2\u0136"+
		"\u0137\7\6\2\2\u0137\u0138\b\31\1\2\u0138\u013a\3\2\2\2\u0139\u012a\3"+
		"\2\2\2\u0139\u012c\3\2\2\2\u0139\u0131\3\2\2\2\u0139\u0133\3\2\2\2\u013a"+
		"\61\3\2\2\2\26>EVcm\u0089\u0090\u00a0\u00a9\u00c8\u00db\u00e5\u00e8\u00ee"+
		"\u0100\u0105\u0116\u0118\u0128\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}