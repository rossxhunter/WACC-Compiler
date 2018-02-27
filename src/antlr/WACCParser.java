// Generated from ./WACCParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WACCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=41, NEWPAIR=53, ORDINAL=17, DO=48, CHR=18, LSQBRAC=21, SINGLEQUOTE=26, 
		MINUS=5, SEMICOLON=25, WHITESPACE=30, ELSE=45, IF=43, INTEGER=61, DONE=49, 
		NULL=57, LESSEQ=9, MODULO=3, TRUE=59, IS=56, STRLIT=65, READ=37, NOT=14, 
		EQUALITY=10, AND=12, NEGATIVE=15, CHARLIT=64, MULTIPLY=1, LESS=8, THEN=44, 
		END=51, EXIT=40, PLUS=4, CALL=52, FI=46, PRINTLN=42, LENGTH=16, CHAR=34, 
		BEGIN=50, FREE=38, DOUBLEQUOTE=27, INT=32, COMMENT=66, DIVIDE=2, RETURN=39, 
		GREATEREQ=7, ESCCHAR=63, RSQBRAC=22, SKIP=36, COMMA=23, OR=13, EOL=29, 
		RBRAC=20, EQUAL=24, GREATER=6, SLASH=28, FIRST=54, NOTEQ=11, LBRAC=19, 
		TAB=31, IDENT=62, BOOL=33, STRING=35, WHILE=47, SECOND=55, FALSE=60, PAIR=58;
	public static final String[] tokenNames = {
		"<INVALID>", "'*'", "'/'", "'%'", "'+'", "MINUS", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "NEGATIVE", "'len'", "'ord'", 
		"'chr'", "'('", "')'", "'['", "']'", "','", "'='", "';'", "'''", "'\"'", 
		"'\\'", "'\n'", "' '", "'\t'", "'int'", "'bool'", "'char'", "'string'", 
		"'skip'", "'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'begin'", 
		"'end'", "'call'", "'newpair'", "'fst'", "'snd'", "'is'", "'null'", "'pair'", 
		"'true'", "'false'", "INTEGER", "IDENT", "ESCCHAR", "CHARLIT", "STRLIT", 
		"COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_paramList = 2, RULE_param = 3, RULE_assign = 4, 
		RULE_declare = 5, RULE_ret = 6, RULE_free = 7, RULE_print = 8, RULE_println = 9, 
		RULE_read = 10, RULE_begin = 11, RULE_end = 12, RULE_exit = 13, RULE_ifStat = 14, 
		RULE_whileStat = 15, RULE_block = 16, RULE_statFunc = 17, RULE_stat = 18, 
		RULE_assignLHS = 19, RULE_assignRHS = 20, RULE_newPair = 21, RULE_call = 22, 
		RULE_argList = 23, RULE_pairElem = 24, RULE_type = 25, RULE_baseType = 26, 
		RULE_arrayType = 27, RULE_pairType = 28, RULE_pairElemType = 29, RULE_expr = 30, 
		RULE_unary = 31, RULE_ord = 32, RULE_unaryOper = 33, RULE_boolOper = 34, 
		RULE_compareOper = 35, RULE_binaryOp1 = 36, RULE_binaryOp2 = 37, RULE_ident = 38, 
		RULE_arrayElem = 39, RULE_intLit = 40, RULE_intSign = 41, RULE_boolLit = 42, 
		RULE_charLit = 43, RULE_strLit = 44, RULE_arrayLit = 45, RULE_pairLit = 46;
	public static final String[] ruleNames = {
		"program", "func", "paramList", "param", "assign", "declare", "ret", "free", 
		"print", "println", "read", "begin", "end", "exit", "ifStat", "whileStat", 
		"block", "statFunc", "stat", "assignLHS", "assignRHS", "newPair", "call", 
		"argList", "pairElem", "type", "baseType", "arrayType", "pairType", "pairElemType", 
		"expr", "unary", "ord", "unaryOper", "boolOper", "compareOper", "binaryOp1", 
		"binaryOp2", "ident", "arrayElem", "intLit", "intSign", "boolLit", "charLit", 
		"strLit", "arrayLit", "pairLit"
	};

	@Override
	public String getGrammarFileName() { return "WACCParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WACCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public BeginContext begin() {
			return getRuleContext(BeginContext.class,0);
		}
		public TerminalNode EOF() { return getToken(WACCParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(94); begin();
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(95); func();
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(101); stat(0);
			setState(102); end();
			setState(103); match(EOF);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(WACCParser.IS, 0); }
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<StatFuncContext> statFunc() {
			return getRuleContexts(StatFuncContext.class);
		}
		public StatFuncContext statFunc(int i) {
			return getRuleContext(StatFuncContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBRAC() { return getToken(WACCParser.LBRAC, 0); }
		public ExitContext exit() {
			return getRuleContext(ExitContext.class,0);
		}
		public TerminalNode RBRAC() { return getToken(WACCParser.RBRAC, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105); type(0);
			setState(106); ident();
			setState(107); match(LBRAC);
			setState(109);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(108); paramList();
				}
			}

			setState(111); match(RBRAC);
			setState(112); match(IS);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113); statFunc(0);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(121);
			switch (_input.LA(1)) {
			case RETURN:
				{
				setState(119); ret();
				}
				break;
			case EXIT:
				{
				setState(120); exit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(123); end();
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); param();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(126); match(COMMA);
				setState(127); param();
				}
				}
				setState(132);
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

	public static class ParamContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); type(0);
			setState(134); ident();
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(WACCParser.EQUAL, 0); }
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); assignLHS();
			setState(137); match(EQUAL);
			setState(138); assignRHS();
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

	public static class DeclareContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(WACCParser.EQUAL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AssignRHSContext assignRHS() {
			return getRuleContext(AssignRHSContext.class,0);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); type(0);
			setState(141); ident();
			setState(142); match(EQUAL);
			setState(143); assignRHS();
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

	public static class RetContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(WACCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(RETURN);
			setState(146); expr(0);
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

	public static class FreeContext extends ParserRuleContext {
		public TerminalNode FREE() { return getToken(WACCParser.FREE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_free; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitFree(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FreeContext free() throws RecognitionException {
		FreeContext _localctx = new FreeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_free);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(FREE);
			setState(149); expr(0);
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(WACCParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(PRINT);
			setState(152); expr(0);
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

	public static class PrintlnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(WACCParser.PRINTLN, 0); }
		public PrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPrintln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintlnContext println() throws RecognitionException {
		PrintlnContext _localctx = new PrintlnContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_println);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(PRINTLN);
			setState(155); expr(0);
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

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(WACCParser.READ, 0); }
		public AssignLHSContext assignLHS() {
			return getRuleContext(AssignLHSContext.class,0);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(READ);
			setState(158); assignLHS();
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

	public static class BeginContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(WACCParser.BEGIN, 0); }
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBegin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(BEGIN);
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

	public static class EndContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(WACCParser.END, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(END);
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

	public static class ExitContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(WACCParser.EXIT, 0); }
		public ExitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitExit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitContext exit() throws RecognitionException {
		ExitContext _localctx = new ExitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(EXIT);
			setState(165); expr(0);
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

	public static class IfStatContext extends ParserRuleContext {
		public TerminalNode FI() { return getToken(WACCParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(WACCParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(WACCParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(WACCParser.THEN, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(IF);
			setState(168); expr(0);
			setState(169); match(THEN);
			setState(170); stat(0);
			setState(171); match(ELSE);
			setState(172); stat(0);
			setState(173); match(FI);
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

	public static class WhileStatContext extends ParserRuleContext {
		public TerminalNode DONE() { return getToken(WACCParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(WACCParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(WACCParser.WHILE, 0); }
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); match(WHILE);
			setState(176); expr(0);
			setState(177); match(DO);
			setState(178); stat(0);
			setState(179); match(DONE);
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

	public static class BlockContext extends ParserRuleContext {
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public BeginContext begin() {
			return getRuleContext(BeginContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); begin();
			setState(182); stat(0);
			setState(183); end();
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

	public static class StatFuncContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(WACCParser.SEMICOLON, 0); }
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public FreeContext free() {
			return getRuleContext(FreeContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public PrintlnContext println() {
			return getRuleContext(PrintlnContext.class,0);
		}
		public DeclareContext declare() {
			return getRuleContext(DeclareContext.class,0);
		}
		public TerminalNode SKIP() { return getToken(WACCParser.SKIP, 0); }
		public StatFuncContext statFunc() {
			return getRuleContext(StatFuncContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statFunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStatFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatFuncContext statFunc() throws RecognitionException {
		return statFunc(0);
	}

	private StatFuncContext statFunc(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatFuncContext _localctx = new StatFuncContext(_ctx, _parentState);
		StatFuncContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_statFunc, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(186); match(SKIP);
				}
				break;
			case 2:
				{
				setState(187); declare();
				}
				break;
			case 3:
				{
				setState(188); assign();
				}
				break;
			case 4:
				{
				setState(189); read();
				}
				break;
			case 5:
				{
				setState(190); free();
				}
				break;
			case 6:
				{
				setState(191); print();
				}
				break;
			case 7:
				{
				setState(192); println();
				}
				break;
			case 8:
				{
				setState(193); ifStat();
				}
				break;
			case 9:
				{
				setState(194); whileStat();
				}
				break;
			case 10:
				{
				setState(195); block();
				}
				break;
			case 11:
				{
				setState(196); stat(0);
				setState(197); match(SEMICOLON);
				setState(198); stat(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatFuncContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statFunc);
					setState(202);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(203); match(SEMICOLON);
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(WACCParser.SEMICOLON, 0); }
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public FreeContext free() {
			return getRuleContext(FreeContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ExitContext exit() {
			return getRuleContext(ExitContext.class,0);
		}
		public PrintlnContext println() {
			return getRuleContext(PrintlnContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public DeclareContext declare() {
			return getRuleContext(DeclareContext.class,0);
		}
		public TerminalNode SKIP() { return getToken(WACCParser.SKIP, 0); }
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(210); match(SKIP);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				setState(211); declare();
				}
				break;
			case FIRST:
			case SECOND:
			case IDENT:
				{
				setState(212); assign();
				}
				break;
			case READ:
				{
				setState(213); read();
				}
				break;
			case FREE:
				{
				setState(214); free();
				}
				break;
			case RETURN:
				{
				setState(215); ret();
				}
				break;
			case EXIT:
				{
				setState(216); exit();
				}
				break;
			case PRINT:
				{
				setState(217); print();
				}
				break;
			case PRINTLN:
				{
				setState(218); println();
				}
				break;
			case IF:
				{
				setState(219); ifStat();
				}
				break;
			case WHILE:
				{
				setState(220); whileStat();
				}
				break;
			case BEGIN:
				{
				setState(221); block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(224);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(225); match(SEMICOLON);
					setState(226); stat(2);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class AssignLHSContext extends ParserRuleContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignLHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignLHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignLHSContext assignLHS() throws RecognitionException {
		AssignLHSContext _localctx = new AssignLHSContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignLHS);
		try {
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232); ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233); arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234); pairElem();
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

	public static class AssignRHSContext extends ParserRuleContext {
		public NewPairContext newPair() {
			return getRuleContext(NewPairContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ArrayLitContext arrayLit() {
			return getRuleContext(ArrayLitContext.class,0);
		}
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignRHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRHSContext assignRHS() throws RecognitionException {
		AssignRHSContext _localctx = new AssignRHSContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignRHS);
		try {
			setState(242);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT:
			case LENGTH:
			case ORDINAL:
			case CHR:
			case LBRAC:
			case NULL:
			case TRUE:
			case FALSE:
			case INTEGER:
			case IDENT:
			case CHARLIT:
			case STRLIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); expr(0);
				}
				break;
			case LSQBRAC:
				enterOuterAlt(_localctx, 2);
				{
				setState(238); arrayLit();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(239); newPair();
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(240); pairElem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(241); call();
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

	public static class NewPairContext extends ParserRuleContext {
		public TerminalNode NEWPAIR() { return getToken(WACCParser.NEWPAIR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public TerminalNode LBRAC() { return getToken(WACCParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(WACCParser.RBRAC, 0); }
		public NewPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitNewPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewPairContext newPair() throws RecognitionException {
		NewPairContext _localctx = new NewPairContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_newPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); match(NEWPAIR);
			setState(245); match(LBRAC);
			setState(246); expr(0);
			setState(247); match(COMMA);
			setState(248); expr(0);
			setState(249); match(RBRAC);
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

	public static class CallContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode CALL() { return getToken(WACCParser.CALL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LBRAC() { return getToken(WACCParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(WACCParser.RBRAC, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(CALL);
			setState(252); ident();
			setState(253); match(LBRAC);
			setState(255);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (PLUS - 4)) | (1L << (MINUS - 4)) | (1L << (NOT - 4)) | (1L << (LENGTH - 4)) | (1L << (ORDINAL - 4)) | (1L << (CHR - 4)) | (1L << (LBRAC - 4)) | (1L << (NULL - 4)) | (1L << (TRUE - 4)) | (1L << (FALSE - 4)) | (1L << (INTEGER - 4)) | (1L << (IDENT - 4)) | (1L << (CHARLIT - 4)) | (1L << (STRLIT - 4)))) != 0)) {
				{
				setState(254); argList();
				}
			}

			setState(257); match(RBRAC);
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

	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); expr(0);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(260); match(COMMA);
				setState(261); expr(0);
				}
				}
				setState(266);
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

	public static class PairElemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SECOND() { return getToken(WACCParser.SECOND, 0); }
		public TerminalNode FIRST() { return getToken(WACCParser.FIRST, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_pairElem);
		try {
			setState(271);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); match(FIRST);
				setState(268); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(269); match(SECOND);
				setState(270); expr(0);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode RSQBRAC() { return getToken(WACCParser.RSQBRAC, 0); }
		public TerminalNode LSQBRAC() { return getToken(WACCParser.LSQBRAC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitType(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(274); baseType();
				}
				break;
			case PAIR:
				{
				setState(275); pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(278);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(279); match(LSQBRAC);
					setState(280); match(RSQBRAC);
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public Token baseT;
		public TerminalNode BOOL() { return getToken(WACCParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(WACCParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(WACCParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(WACCParser.INT, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((BaseTypeContext)_localctx).baseT = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) ) {
				((BaseTypeContext)_localctx).baseT = (Token)_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode RSQBRAC() { return getToken(WACCParser.RSQBRAC, 0); }
		public TerminalNode LSQBRAC() { return getToken(WACCParser.LSQBRAC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); type(0);
			setState(289); match(LSQBRAC);
			setState(290); match(RSQBRAC);
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

	public static class PairTypeContext extends ParserRuleContext {
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public TerminalNode PAIR() { return getToken(WACCParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public TerminalNode LBRAC() { return getToken(WACCParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(WACCParser.RBRAC, 0); }
		public PairTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairTypeContext pairType() throws RecognitionException {
		PairTypeContext _localctx = new PairTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292); match(PAIR);
			setState(293); match(LBRAC);
			setState(294); pairElemType();
			setState(295); match(COMMA);
			setState(296); pairElemType();
			setState(297); match(RBRAC);
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

	public static class PairElemTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(WACCParser.PAIR, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairElemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairElemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_pairElemType);
		try {
			setState(302);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300); arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(301); match(PAIR);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public CompareOperContext compareOper() {
			return getRuleContext(CompareOperContext.class,0);
		}
		public BoolOperContext boolOper() {
			return getRuleContext(BoolOperContext.class,0);
		}
		public CharLitContext charLit() {
			return getRuleContext(CharLitContext.class,0);
		}
		public StrLitContext strLit() {
			return getRuleContext(StrLitContext.class,0);
		}
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public BinaryOp2Context binaryOp2() {
			return getRuleContext(BinaryOp2Context.class,0);
		}
		public BinaryOp1Context binaryOp1() {
			return getRuleContext(BinaryOp1Context.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public TerminalNode LBRAC() { return getToken(WACCParser.LBRAC, 0); }
		public PairLitContext pairLit() {
			return getRuleContext(PairLitContext.class,0);
		}
		public TerminalNode RBRAC() { return getToken(WACCParser.RBRAC, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(305); intLit();
				}
				break;
			case 2:
				{
				setState(306); boolLit();
				}
				break;
			case 3:
				{
				setState(307); charLit();
				}
				break;
			case 4:
				{
				setState(308); strLit();
				}
				break;
			case 5:
				{
				setState(309); pairLit();
				}
				break;
			case 6:
				{
				setState(310); ident();
				}
				break;
			case 7:
				{
				setState(311); arrayElem();
				}
				break;
			case 8:
				{
				setState(312); unary();
				}
				break;
			case 9:
				{
				setState(313); match(LBRAC);
				setState(314); expr(0);
				setState(315); match(RBRAC);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(335);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(320); binaryOp1();
						setState(321); expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(323);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(324); binaryOp2();
						setState(325); expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(327);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(328); compareOper();
						setState(329); expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(332); boolOper();
						setState(333); expr(3);
						}
						break;
					}
					} 
				}
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class UnaryContext extends ParserRuleContext {
		public UnaryOperContext unaryOper() {
			return getRuleContext(UnaryOperContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_unary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); unaryOper();
			setState(341); expr(0);
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

	public static class OrdContext extends ParserRuleContext {
		public TerminalNode ORDINAL() { return getToken(WACCParser.ORDINAL, 0); }
		public OrdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitOrd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrdContext ord() throws RecognitionException {
		OrdContext _localctx = new OrdContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); match(ORDINAL);
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

	public static class UnaryOperContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(WACCParser.NOT, 0); }
		public OrdContext ord() {
			return getRuleContext(OrdContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public TerminalNode LENGTH() { return getToken(WACCParser.LENGTH, 0); }
		public TerminalNode CHR() { return getToken(WACCParser.CHR, 0); }
		public UnaryOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitUnaryOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperContext unaryOper() throws RecognitionException {
		UnaryOperContext _localctx = new UnaryOperContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unaryOper);
		try {
			setState(350);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(345); match(NOT);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(346); match(MINUS);
				}
				break;
			case LENGTH:
				enterOuterAlt(_localctx, 3);
				{
				setState(347); match(LENGTH);
				}
				break;
			case ORDINAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(348); ord();
				}
				break;
			case CHR:
				enterOuterAlt(_localctx, 5);
				{
				setState(349); match(CHR);
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

	public static class BoolOperContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(WACCParser.AND, 0); }
		public TerminalNode OR() { return getToken(WACCParser.OR, 0); }
		public BoolOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBoolOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperContext boolOper() throws RecognitionException {
		BoolOperContext _localctx = new BoolOperContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_boolOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class CompareOperContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(WACCParser.LESS, 0); }
		public TerminalNode LESSEQ() { return getToken(WACCParser.LESSEQ, 0); }
		public TerminalNode GREATEREQ() { return getToken(WACCParser.GREATEREQ, 0); }
		public TerminalNode GREATER() { return getToken(WACCParser.GREATER, 0); }
		public TerminalNode EQUALITY() { return getToken(WACCParser.EQUALITY, 0); }
		public TerminalNode NOTEQ() { return getToken(WACCParser.NOTEQ, 0); }
		public CompareOperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitCompareOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareOperContext compareOper() throws RecognitionException {
		CompareOperContext _localctx = new CompareOperContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_compareOper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER) | (1L << GREATEREQ) | (1L << LESS) | (1L << LESSEQ) | (1L << EQUALITY) | (1L << NOTEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BinaryOp1Context extends ParserRuleContext {
		public TerminalNode DIVIDE() { return getToken(WACCParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(WACCParser.MODULO, 0); }
		public TerminalNode MULTIPLY() { return getToken(WACCParser.MULTIPLY, 0); }
		public BinaryOp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinaryOp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOp1Context binaryOp1() throws RecognitionException {
		BinaryOp1Context _localctx = new BinaryOp1Context(_ctx, getState());
		enterRule(_localctx, 72, RULE_binaryOp1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MODULO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BinaryOp2Context extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public BinaryOp2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinaryOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOp2Context binaryOp2() throws RecognitionException {
		BinaryOp2Context _localctx = new BinaryOp2Context(_ctx, getState());
		enterRule(_localctx, 74, RULE_binaryOp2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360); match(IDENT);
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

	public static class ArrayElemContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> RSQBRAC() { return getTokens(WACCParser.RSQBRAC); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<TerminalNode> LSQBRAC() { return getTokens(WACCParser.LSQBRAC); }
		public TerminalNode RSQBRAC(int i) {
			return getToken(WACCParser.RSQBRAC, i);
		}
		public TerminalNode LSQBRAC(int i) {
			return getToken(WACCParser.LSQBRAC, i);
		}
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(362); ident();
			setState(367); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(363); match(LSQBRAC);
					setState(364); expr(0);
					setState(365); match(RSQBRAC);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(369); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class IntLitContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(WACCParser.INTEGER, 0); }
		public IntSignContext intSign() {
			return getRuleContext(IntSignContext.class,0);
		}
		public IntLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIntLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntLitContext intLit() throws RecognitionException {
		IntLitContext _localctx = new IntLitContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_intLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(371); intSign();
				}
			}

			setState(374); match(INTEGER);
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

	public static class IntSignContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public IntSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intSign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIntSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntSignContext intSign() throws RecognitionException {
		IntSignContext _localctx = new IntSignContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_intSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BoolLitContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(WACCParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(WACCParser.TRUE, 0); }
		public BoolLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBoolLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLitContext boolLit() throws RecognitionException {
		BoolLitContext _localctx = new BoolLitContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_boolLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class CharLitContext extends ParserRuleContext {
		public TerminalNode CHARLIT() { return getToken(WACCParser.CHARLIT, 0); }
		public CharLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitCharLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharLitContext charLit() throws RecognitionException {
		CharLitContext _localctx = new CharLitContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_charLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); match(CHARLIT);
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

	public static class StrLitContext extends ParserRuleContext {
		public TerminalNode STRLIT() { return getToken(WACCParser.STRLIT, 0); }
		public StrLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStrLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrLitContext strLit() throws RecognitionException {
		StrLitContext _localctx = new StrLitContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_strLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); match(STRLIT);
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

	public static class ArrayLitContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode RSQBRAC() { return getToken(WACCParser.RSQBRAC, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public TerminalNode LSQBRAC() { return getToken(WACCParser.LSQBRAC, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public ArrayLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArrayLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLitContext arrayLit() throws RecognitionException {
		ArrayLitContext _localctx = new ArrayLitContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_arrayLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); match(LSQBRAC);
			setState(393);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (PLUS - 4)) | (1L << (MINUS - 4)) | (1L << (NOT - 4)) | (1L << (LENGTH - 4)) | (1L << (ORDINAL - 4)) | (1L << (CHR - 4)) | (1L << (LBRAC - 4)) | (1L << (NULL - 4)) | (1L << (TRUE - 4)) | (1L << (FALSE - 4)) | (1L << (INTEGER - 4)) | (1L << (IDENT - 4)) | (1L << (CHARLIT - 4)) | (1L << (STRLIT - 4)))) != 0)) {
				{
				setState(385); expr(0);
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(386); match(COMMA);
					setState(387); expr(0);
					}
					}
					setState(392);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(395); match(RSQBRAC);
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

	public static class PairLitContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(WACCParser.NULL, 0); }
		public PairLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairLitContext pairLit() throws RecognitionException {
		PairLitContext _localctx = new PairLitContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_pairLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); match(NULL);
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
		case 17: return statFunc_sempred((StatFuncContext)_localctx, predIndex);
		case 18: return stat_sempred((StatContext)_localctx, predIndex);
		case 25: return type_sempred((TypeContext)_localctx, predIndex);
		case 30: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 3);
		case 6: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean statFunc_sempred(StatFuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\7\2c\n\2\f\2\16\2f\13\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3p\n\3\3\3\3\3\3\3\7\3u\n\3\f\3\16\3x\13"+
		"\3\3\3\3\3\5\3|\n\3\3\3\3\3\3\4\3\4\3\4\7\4\u0083\n\4\f\4\16\4\u0086\13"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00cb\n\23\3\23\3\23\7\23\u00cf\n"+
		"\23\f\23\16\23\u00d2\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00e1\n\24\3\24\3\24\3\24\7\24\u00e6\n\24\f"+
		"\24\16\24\u00e9\13\24\3\25\3\25\3\25\5\25\u00ee\n\25\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u00f5\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\5\30\u0102\n\30\3\30\3\30\3\31\3\31\3\31\7\31\u0109\n\31\f"+
		"\31\16\31\u010c\13\31\3\32\3\32\3\32\3\32\5\32\u0112\n\32\3\33\3\33\3"+
		"\33\5\33\u0117\n\33\3\33\3\33\3\33\7\33\u011c\n\33\f\33\16\33\u011f\13"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\5\37\u0131\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5"+
		" \u0140\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0152\n"+
		" \f \16 \u0155\13 \3!\3!\3!\3\"\3\"\3#\3#\3#\3#\3#\5#\u0161\n#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\6)\u0172\n)\r)\16)\u0173\3*\5"+
		"*\u0177\n*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\7/\u0187\n/\f/\16"+
		"/\u018a\13/\5/\u018c\n/\3/\3/\3\60\3\60\3\60\2\6$&\64>\61\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^"+
		"\2\b\3\2\"%\3\2\16\17\3\2\b\r\3\2\3\5\3\2\6\7\3\2=>\u019f\2`\3\2\2\2\4"+
		"k\3\2\2\2\6\177\3\2\2\2\b\u0087\3\2\2\2\n\u008a\3\2\2\2\f\u008e\3\2\2"+
		"\2\16\u0093\3\2\2\2\20\u0096\3\2\2\2\22\u0099\3\2\2\2\24\u009c\3\2\2\2"+
		"\26\u009f\3\2\2\2\30\u00a2\3\2\2\2\32\u00a4\3\2\2\2\34\u00a6\3\2\2\2\36"+
		"\u00a9\3\2\2\2 \u00b1\3\2\2\2\"\u00b7\3\2\2\2$\u00ca\3\2\2\2&\u00e0\3"+
		"\2\2\2(\u00ed\3\2\2\2*\u00f4\3\2\2\2,\u00f6\3\2\2\2.\u00fd\3\2\2\2\60"+
		"\u0105\3\2\2\2\62\u0111\3\2\2\2\64\u0116\3\2\2\2\66\u0120\3\2\2\28\u0122"+
		"\3\2\2\2:\u0126\3\2\2\2<\u0130\3\2\2\2>\u013f\3\2\2\2@\u0156\3\2\2\2B"+
		"\u0159\3\2\2\2D\u0160\3\2\2\2F\u0162\3\2\2\2H\u0164\3\2\2\2J\u0166\3\2"+
		"\2\2L\u0168\3\2\2\2N\u016a\3\2\2\2P\u016c\3\2\2\2R\u0176\3\2\2\2T\u017a"+
		"\3\2\2\2V\u017c\3\2\2\2X\u017e\3\2\2\2Z\u0180\3\2\2\2\\\u0182\3\2\2\2"+
		"^\u018f\3\2\2\2`d\5\30\r\2ac\5\4\3\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3"+
		"\2\2\2eg\3\2\2\2fd\3\2\2\2gh\5&\24\2hi\5\32\16\2ij\7\2\2\3j\3\3\2\2\2"+
		"kl\5\64\33\2lm\5N(\2mo\7\25\2\2np\5\6\4\2on\3\2\2\2op\3\2\2\2pq\3\2\2"+
		"\2qr\7\26\2\2rv\7:\2\2su\5$\23\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2"+
		"\2w{\3\2\2\2xv\3\2\2\2y|\5\16\b\2z|\5\34\17\2{y\3\2\2\2{z\3\2\2\2|}\3"+
		"\2\2\2}~\5\32\16\2~\5\3\2\2\2\177\u0084\5\b\5\2\u0080\u0081\7\31\2\2\u0081"+
		"\u0083\5\b\5\2\u0082\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\7\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088"+
		"\5\64\33\2\u0088\u0089\5N(\2\u0089\t\3\2\2\2\u008a\u008b\5(\25\2\u008b"+
		"\u008c\7\32\2\2\u008c\u008d\5*\26\2\u008d\13\3\2\2\2\u008e\u008f\5\64"+
		"\33\2\u008f\u0090\5N(\2\u0090\u0091\7\32\2\2\u0091\u0092\5*\26\2\u0092"+
		"\r\3\2\2\2\u0093\u0094\7)\2\2\u0094\u0095\5> \2\u0095\17\3\2\2\2\u0096"+
		"\u0097\7(\2\2\u0097\u0098\5> \2\u0098\21\3\2\2\2\u0099\u009a\7+\2\2\u009a"+
		"\u009b\5> \2\u009b\23\3\2\2\2\u009c\u009d\7,\2\2\u009d\u009e\5> \2\u009e"+
		"\25\3\2\2\2\u009f\u00a0\7\'\2\2\u00a0\u00a1\5(\25\2\u00a1\27\3\2\2\2\u00a2"+
		"\u00a3\7\64\2\2\u00a3\31\3\2\2\2\u00a4\u00a5\7\65\2\2\u00a5\33\3\2\2\2"+
		"\u00a6\u00a7\7*\2\2\u00a7\u00a8\5> \2\u00a8\35\3\2\2\2\u00a9\u00aa\7-"+
		"\2\2\u00aa\u00ab\5> \2\u00ab\u00ac\7.\2\2\u00ac\u00ad\5&\24\2\u00ad\u00ae"+
		"\7/\2\2\u00ae\u00af\5&\24\2\u00af\u00b0\7\60\2\2\u00b0\37\3\2\2\2\u00b1"+
		"\u00b2\7\61\2\2\u00b2\u00b3\5> \2\u00b3\u00b4\7\62\2\2\u00b4\u00b5\5&"+
		"\24\2\u00b5\u00b6\7\63\2\2\u00b6!\3\2\2\2\u00b7\u00b8\5\30\r\2\u00b8\u00b9"+
		"\5&\24\2\u00b9\u00ba\5\32\16\2\u00ba#\3\2\2\2\u00bb\u00bc\b\23\1\2\u00bc"+
		"\u00cb\7&\2\2\u00bd\u00cb\5\f\7\2\u00be\u00cb\5\n\6\2\u00bf\u00cb\5\26"+
		"\f\2\u00c0\u00cb\5\20\t\2\u00c1\u00cb\5\22\n\2\u00c2\u00cb\5\24\13\2\u00c3"+
		"\u00cb\5\36\20\2\u00c4\u00cb\5 \21\2\u00c5\u00cb\5\"\22\2\u00c6\u00c7"+
		"\5&\24\2\u00c7\u00c8\7\33\2\2\u00c8\u00c9\5&\24\2\u00c9\u00cb\3\2\2\2"+
		"\u00ca\u00bb\3\2\2\2\u00ca\u00bd\3\2\2\2\u00ca\u00be\3\2\2\2\u00ca\u00bf"+
		"\3\2\2\2\u00ca\u00c0\3\2\2\2\u00ca\u00c1\3\2\2\2\u00ca\u00c2\3\2\2\2\u00ca"+
		"\u00c3\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c5\3\2\2\2\u00ca\u00c6\3\2"+
		"\2\2\u00cb\u00d0\3\2\2\2\u00cc\u00cd\f\3\2\2\u00cd\u00cf\7\33\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1%\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\b\24\1\2\u00d4\u00e1"+
		"\7&\2\2\u00d5\u00e1\5\f\7\2\u00d6\u00e1\5\n\6\2\u00d7\u00e1\5\26\f\2\u00d8"+
		"\u00e1\5\20\t\2\u00d9\u00e1\5\16\b\2\u00da\u00e1\5\34\17\2\u00db\u00e1"+
		"\5\22\n\2\u00dc\u00e1\5\24\13\2\u00dd\u00e1\5\36\20\2\u00de\u00e1\5 \21"+
		"\2\u00df\u00e1\5\"\22\2\u00e0\u00d3\3\2\2\2\u00e0\u00d5\3\2\2\2\u00e0"+
		"\u00d6\3\2\2\2\u00e0\u00d7\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00d9\3\2"+
		"\2\2\u00e0\u00da\3\2\2\2\u00e0\u00db\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e0"+
		"\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e7\3\2"+
		"\2\2\u00e2\u00e3\f\3\2\2\u00e3\u00e4\7\33\2\2\u00e4\u00e6\5&\24\4\u00e5"+
		"\u00e2\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\'\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ee\5N(\2\u00eb\u00ee"+
		"\5P)\2\u00ec\u00ee\5\62\32\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee)\3\2\2\2\u00ef\u00f5\5> \2\u00f0\u00f5\5\\/\2\u00f1"+
		"\u00f5\5,\27\2\u00f2\u00f5\5\62\32\2\u00f3\u00f5\5.\30\2\u00f4\u00ef\3"+
		"\2\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f5+\3\2\2\2\u00f6\u00f7\7\67\2\2\u00f7\u00f8\7\25\2"+
		"\2\u00f8\u00f9\5> \2\u00f9\u00fa\7\31\2\2\u00fa\u00fb\5> \2\u00fb\u00fc"+
		"\7\26\2\2\u00fc-\3\2\2\2\u00fd\u00fe\7\66\2\2\u00fe\u00ff\5N(\2\u00ff"+
		"\u0101\7\25\2\2\u0100\u0102\5\60\31\2\u0101\u0100\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\7\26\2\2\u0104/\3\2\2\2\u0105"+
		"\u010a\5> \2\u0106\u0107\7\31\2\2\u0107\u0109\5> \2\u0108\u0106\3\2\2"+
		"\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\61"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\78\2\2\u010e\u0112\5> \2\u010f"+
		"\u0110\79\2\2\u0110\u0112\5> \2\u0111\u010d\3\2\2\2\u0111\u010f\3\2\2"+
		"\2\u0112\63\3\2\2\2\u0113\u0114\b\33\1\2\u0114\u0117\5\66\34\2\u0115\u0117"+
		"\5:\36\2\u0116\u0113\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u011d\3\2\2\2\u0118"+
		"\u0119\f\4\2\2\u0119\u011a\7\27\2\2\u011a\u011c\7\30\2\2\u011b\u0118\3"+
		"\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\65\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\t\2\2\2\u0121\67\3\2\2\2\u0122"+
		"\u0123\5\64\33\2\u0123\u0124\7\27\2\2\u0124\u0125\7\30\2\2\u01259\3\2"+
		"\2\2\u0126\u0127\7<\2\2\u0127\u0128\7\25\2\2\u0128\u0129\5<\37\2\u0129"+
		"\u012a\7\31\2\2\u012a\u012b\5<\37\2\u012b\u012c\7\26\2\2\u012c;\3\2\2"+
		"\2\u012d\u0131\5\66\34\2\u012e\u0131\58\35\2\u012f\u0131\7<\2\2\u0130"+
		"\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131=\3\2\2\2"+
		"\u0132\u0133\b \1\2\u0133\u0140\5R*\2\u0134\u0140\5V,\2\u0135\u0140\5"+
		"X-\2\u0136\u0140\5Z.\2\u0137\u0140\5^\60\2\u0138\u0140\5N(\2\u0139\u0140"+
		"\5P)\2\u013a\u0140\5@!\2\u013b\u013c\7\25\2\2\u013c\u013d\5> \2\u013d"+
		"\u013e\7\26\2\2\u013e\u0140\3\2\2\2\u013f\u0132\3\2\2\2\u013f\u0134\3"+
		"\2\2\2\u013f\u0135\3\2\2\2\u013f\u0136\3\2\2\2\u013f\u0137\3\2\2\2\u013f"+
		"\u0138\3\2\2\2\u013f\u0139\3\2\2\2\u013f\u013a\3\2\2\2\u013f\u013b\3\2"+
		"\2\2\u0140\u0153\3\2\2\2\u0141\u0142\f\7\2\2\u0142\u0143\5J&\2\u0143\u0144"+
		"\5> \b\u0144\u0152\3\2\2\2\u0145\u0146\f\6\2\2\u0146\u0147\5L\'\2\u0147"+
		"\u0148\5> \7\u0148\u0152\3\2\2\2\u0149\u014a\f\5\2\2\u014a\u014b\5H%\2"+
		"\u014b\u014c\5> \6\u014c\u0152\3\2\2\2\u014d\u014e\f\4\2\2\u014e\u014f"+
		"\5F$\2\u014f\u0150\5> \5\u0150\u0152\3\2\2\2\u0151\u0141\3\2\2\2\u0151"+
		"\u0145\3\2\2\2\u0151\u0149\3\2\2\2\u0151\u014d\3\2\2\2\u0152\u0155\3\2"+
		"\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154?\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0156\u0157\5D#\2\u0157\u0158\5> \2\u0158A\3\2\2\2\u0159\u015a"+
		"\7\23\2\2\u015aC\3\2\2\2\u015b\u0161\7\20\2\2\u015c\u0161\7\7\2\2\u015d"+
		"\u0161\7\22\2\2\u015e\u0161\5B\"\2\u015f\u0161\7\24\2\2\u0160\u015b\3"+
		"\2\2\2\u0160\u015c\3\2\2\2\u0160\u015d\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u015f\3\2\2\2\u0161E\3\2\2\2\u0162\u0163\t\3\2\2\u0163G\3\2\2\2\u0164"+
		"\u0165\t\4\2\2\u0165I\3\2\2\2\u0166\u0167\t\5\2\2\u0167K\3\2\2\2\u0168"+
		"\u0169\t\6\2\2\u0169M\3\2\2\2\u016a\u016b\7@\2\2\u016bO\3\2\2\2\u016c"+
		"\u0171\5N(\2\u016d\u016e\7\27\2\2\u016e\u016f\5> \2\u016f\u0170\7\30\2"+
		"\2\u0170\u0172\3\2\2\2\u0171\u016d\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174Q\3\2\2\2\u0175\u0177\5T+\2\u0176\u0175"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\7?\2\2\u0179"+
		"S\3\2\2\2\u017a\u017b\t\6\2\2\u017bU\3\2\2\2\u017c\u017d\t\7\2\2\u017d"+
		"W\3\2\2\2\u017e\u017f\7B\2\2\u017fY\3\2\2\2\u0180\u0181\7C\2\2\u0181["+
		"\3\2\2\2\u0182\u018b\7\27\2\2\u0183\u0188\5> \2\u0184\u0185\7\31\2\2\u0185"+
		"\u0187\5> \2\u0186\u0184\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2"+
		"\2\u0188\u0189\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u0183"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\7\30\2\2"+
		"\u018e]\3\2\2\2\u018f\u0190\7;\2\2\u0190_\3\2\2\2\33dov{\u0084\u00ca\u00d0"+
		"\u00e0\u00e7\u00ed\u00f4\u0101\u010a\u0111\u0116\u011d\u0130\u013f\u0151"+
		"\u0153\u0160\u0173\u0176\u0188\u018b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}