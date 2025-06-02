// Generated from EasyLanguage.g4 by ANTLR 4.12.0
package com.erik.DavaiLang.model.parser;

    import com.erik.DavaiLang.model.abstractsyntaxtree.AbstractCommand;
        import com.erik.DavaiLang.model.abstractsyntaxtree.CommandAtribuicao;
        import com.erik.DavaiLang.model.abstractsyntaxtree.CommandCall;
        import com.erik.DavaiLang.model.abstractsyntaxtree.CommandDecisao;
        import com.erik.DavaiLang.model.abstractsyntaxtree.CommandEscrita;
        import com.erik.DavaiLang.model.abstractsyntaxtree.CommandLeitura;
        import com.erik.DavaiLang.model.abstractsyntaxtree.CommandReturn;
        import com.erik.DavaiLang.model.abstractsyntaxtree.EasyFunction;
        import com.erik.DavaiLang.model.abstractsyntaxtree.EasyProgram;
        import com.erik.DavaiLang.model.datastructures.EasySymbol;
    	import com.erik.DavaiLang.model.datastructures.EasySymbolTable;
    	import com.erik.DavaiLang.model.datastructures.EasyVariable;
    	import com.erik.DavaiLang.model.exceptions.EasySemanticException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EasyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, AP=15, FP=16, SC=17, 
		OP=18, ATTR=19, VIR=20, OPREL=21, ID=22, NUMBER=23, WS=24, COMMENT=25, 
		STRING=26;
	public static final int
		RULE_prog = 0, RULE_funcoes = 1, RULE_funcaoDecl = 2, RULE_params = 3, 
		RULE_param = 4, RULE_decl = 5, RULE_varDecl = 6, RULE_tipo = 7, RULE_blocoPrincipal = 8, 
		RULE_blocoFun = 9, RULE_cmd = 10, RULE_cmdLeitura = 11, RULE_cmdEscrita = 12, 
		RULE_cmdAttrib = 13, RULE_cmdSelecao = 14, RULE_cmdRetorno = 15, RULE_cmdCall = 16, 
		RULE_args = 17, RULE_expr = 18, RULE_termo = 19, RULE_exprList = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "funcoes", "funcaoDecl", "params", "param", "decl", "varDecl", 
			"tipo", "blocoPrincipal", "blocoFun", "cmd", "cmdLeitura", "cmdEscrita", 
			"cmdAttrib", "cmdSelecao", "cmdRetorno", "cmdCall", "args", "expr", "termo", 
			"exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprograma'", "'funcao'", "':'", "'inicio'", "'fim'", 
			"'var'", "'ler'", "'escrever'", "'se'", "'entao'", "'senao'", "'fimse'", 
			"'retornar'", "'('", "')'", "';'", null, "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "AP", "FP", "SC", "OP", "ATTR", "VIR", "OPREL", "ID", 
			"NUMBER", "WS", "COMMENT", "STRING"
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
	public String getGrammarFileName() { return "EasyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int _tipo;
	    private String _varName;
	    private String _varValue;
	    private EasySymbolTable symbolTable = new EasySymbolTable();
	    private EasySymbol symbol;
	    private EasyProgram program = new EasyProgram();
	    private ArrayList<AbstractCommand> curThread;
	    private Stack<ArrayList<AbstractCommand>> stack = new Stack<>();
	    private String _readID;
	    private String _writeID;
	    private String _exprID;
	    private String _exprContent;
	    private String _exprDecision;
	    private ArrayList<AbstractCommand> listaTrue;
	    private ArrayList<AbstractCommand> listaFalse;
	    private List<EasyFunction> functions = new ArrayList<>();
	    private EasyFunction currentFunction;

	    public void verificaID(String id){
	        if (!symbolTable.exists(id)){
	            throw new EasySemanticException("Symbol " + id + " not declared");
	        }
	    }
	    public void verificaFuncao(String id) {
	        boolean functionExists = functions.stream().anyMatch(f -> f.getName().equals(id));
	        if (!functionExists) {
	            throw new EasySemanticException("Function " + id + " not declared");
	        }
	    }
	    public void exibeComandos(){
	        for (AbstractCommand c: program.getComandos()){
	            System.out.println(c);
	        }
	    }
	    public void generateCode(){
	        program.generateTarget();
	    }

	public EasyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public FuncoesContext funcoes() {
			return getRuleContext(FuncoesContext.class,0);
		}
		public BlocoPrincipalContext blocoPrincipal() {
			return getRuleContext(BlocoPrincipalContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener) ((EasyLanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(43);
			match(ID);
			setState(44);
			match(SC);
			setState(45);
			funcoes();
			setState(46);
			blocoPrincipal();
			setState(47);
			match(T__1);

			        program.setVarTable(symbolTable);
			        program.setFunctions(functions);
			        program.setComandos(stack.pop());
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncoesContext extends ParserRuleContext {
		public List<FuncaoDeclContext> funcaoDecl() {
			return getRuleContexts(FuncaoDeclContext.class);
		}
		public FuncaoDeclContext funcaoDecl(int i) {
			return getRuleContext(FuncaoDeclContext.class,i);
		}
		public FuncoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterFuncoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitFuncoes(this);
		}
	}

	public final FuncoesContext funcoes() throws RecognitionException {
		FuncoesContext _localctx = new FuncoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(50);
				funcaoDecl();
				}
				}
				setState(55);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncaoDeclContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public BlocoFunContext blocoFun() {
			return getRuleContext(BlocoFunContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<TerminalNode> SC() { return getTokens(EasyLanguageParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(EasyLanguageParser.SC, i);
		}
		public FuncaoDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcaoDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterFuncaoDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitFuncaoDecl(this);
		}
	}

	public final FuncaoDeclContext funcaoDecl() throws RecognitionException {
		FuncaoDeclContext _localctx = new FuncaoDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcaoDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__2);
			setState(57);
			((FuncaoDeclContext)_localctx).ID = match(ID);

			        currentFunction = new EasyFunction();
			        currentFunction.setName((((FuncaoDeclContext)_localctx).ID!=null?((FuncaoDeclContext)_localctx).ID.getText():null));
			        functions.add(currentFunction);
			      
			setState(59);
			match(AP);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(60);
				params();
				}
			}

			setState(63);
			match(FP);
			setState(64);
			match(T__3);
			setState(65);
			tipo();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SC) {
				{
				setState(66);
				match(SC);
				}
			}

			setState(69);
			match(T__4);

			        currentFunction.setReturnType(_tipo);
			        curThread = new ArrayList<>();
			        stack.push(curThread);
			      
			setState(71);
			blocoFun();
			setState(72);
			match(T__5);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SC) {
				{
				setState(73);
				match(SC);
				}
			}


			        // Se não encontrar comandos (ou se o token 'fim' não for lido corretamente), lance um erro:
			        if (_input.getText(_localctx.start, _input.LT(-1)) == null || _input.getText(_localctx.start, _input.LT(-1)).trim().isEmpty()) {
			          throw new EasySemanticException("Esperado o token 'fim' para fechar a função " + currentFunction.getName());
			        }
			        List<AbstractCommand> bodyCommands = stack.pop();
			        System.out.println("DEBUG: Comandos armazenados na função -> " + bodyCommands);
			        currentFunction.setBody(bodyCommands);
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			param();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(79);
				match(VIR);
				setState(80);
				param();
				}
				}
				setState(85);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((ParamContext)_localctx).ID = match(ID);
			setState(87);
			match(T__3);
			setState(88);
			tipo();

			        EasyVariable p = new EasyVariable((((ParamContext)_localctx).ID!=null?((ParamContext)_localctx).ID.getText():null), _tipo, null);
			        currentFunction.getParams().add(p);
			        symbolTable.add(p); // Adiciona à tabela de símbolos
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				varDecl();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__6);
			setState(97);
			((VarDeclContext)_localctx).ID = match(ID);
			setState(98);
			match(T__3);
			setState(99);
			tipo();
			setState(100);
			match(SC);

			        _varName = (((VarDeclContext)_localctx).ID!=null?((VarDeclContext)_localctx).ID.getText():null);
			        symbol = new EasyVariable(_varName, _tipo, null);
			        if (!symbolTable.exists(_varName)) symbolTable.add(symbol);
			        else throw new EasySemanticException("Symbol " + _varName + " already declared");
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public Token t;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			((TipoContext)_localctx).t = match(ID);

			          if ((((TipoContext)_localctx).t!=null?((TipoContext)_localctx).t.getText():null).equals("inteiro")) {
			              _tipo = EasyVariable.NUMBER;
			          } else if ((((TipoContext)_localctx).t!=null?((TipoContext)_localctx).t.getText():null).equals("texto")) {
			              _tipo = EasyVariable.TEXT;
			          } else {
			              throw new EasySemanticException("Tipo inválido: " + (((TipoContext)_localctx).t!=null?((TipoContext)_localctx).t.getText():null) + ". Tipos válidos: inteiro e texto.");
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoPrincipalContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoPrincipal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterBlocoPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitBlocoPrincipal(this);
		}
	}

	public final BlocoPrincipalContext blocoPrincipal() throws RecognitionException {
		BlocoPrincipalContext _localctx = new BlocoPrincipalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blocoPrincipal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__4);

			        curThread = new ArrayList<>();
			        stack.push(curThread);
			      
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(108);
				decl();
				}
			}

			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				cmd();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212480L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoFunContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterBlocoFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitBlocoFun(this);
		}
	}

	public final BlocoFunContext blocoFun() throws RecognitionException {
		BlocoFunContext _localctx = new BlocoFunContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blocoFun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				cmd();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212480L) != 0) );

			        if (!stack.isEmpty()) {
			            List<AbstractCommand> blocoComandos = stack.peek(); // NÃO removemos da pilha!
			            System.out.println("DEBUG: Comandos dentro de blocoFun -> " + blocoComandos);
			        } else {
			            System.out.println("DEBUG: Pilha vazia ao processar `blocoFun`!");
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdSelecaoContext cmdSelecao() {
			return getRuleContext(CmdSelecaoContext.class,0);
		}
		public CmdRetornoContext cmdRetorno() {
			return getRuleContext(CmdRetornoContext.class,0);
		}
		public CmdCallContext cmdCall() {
			return getRuleContext(CmdCallContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmd);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				cmdLeitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				cmdEscrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				cmdAttrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				cmdSelecao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				cmdRetorno();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				cmdCall();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__7);
			setState(132);
			match(AP);
			setState(133);
			((CmdLeituraContext)_localctx).ID = match(ID);
			setState(134);
			match(FP);
			setState(135);
			match(SC);

			        verificaID((((CmdLeituraContext)_localctx).ID!=null?((CmdLeituraContext)_localctx).ID.getText():null));
			        CommandLeitura cmd = new CommandLeitura((((CmdLeituraContext)_localctx).ID!=null?((CmdLeituraContext)_localctx).ID.getText():null),
			            (EasyVariable)symbolTable.get((((CmdLeituraContext)_localctx).ID!=null?((CmdLeituraContext)_localctx).ID.getText():null)));
			        stack.peek().add(cmd);
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public ExprListContext el;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdEscrita);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__8);
			setState(139);
			match(AP);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 79691776L) != 0)) {
				{
				setState(140);
				((CmdEscritaContext)_localctx).el = exprList();
				}
			}

			setState(143);
			match(FP);
			setState(144);
			match(SC);

				EasyLanguageParser.ExprListContext list = ((CmdEscritaContext)_localctx).el;
				_exprContent = "";
			        if (list != null) {
			            List<String> exprs = new ArrayList<>();
			            for (ExprContext exprCtx : list.expr()) {
			                exprs.add(exprCtx.getText());
			            }
			            CommandCall cmd = new CommandCall("System.out.println", exprs);
			            stack.peek().add(cmd);
			        } else {
			            CommandEscrita cmd = new CommandEscrita(_exprContent);
			            stack.peek().add(cmd);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((CmdAttribContext)_localctx).ID = match(ID);
			setState(148);
			match(ATTR);
			setState(149);
			expr();
			setState(150);
			match(SC);

			        verificaID((((CmdAttribContext)_localctx).ID!=null?((CmdAttribContext)_localctx).ID.getText():null));
			        System.out.println("DEBUG: Expressão atribuída -> " + _exprContent); // Debug
			        CommandAtribuicao cmd = new CommandAtribuicao((((CmdAttribContext)_localctx).ID!=null?((CmdAttribContext)_localctx).ID.getText():null), _exprContent);
			        stack.peek().add(cmd);
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdSelecaoContext extends ParserRuleContext {
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlocoFunContext> blocoFun() {
			return getRuleContexts(BlocoFunContext.class);
		}
		public BlocoFunContext blocoFun(int i) {
			return getRuleContext(BlocoFunContext.class,i);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdSelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSelecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdSelecao(this);
		}
	}

	public final CmdSelecaoContext cmdSelecao() throws RecognitionException {
		CmdSelecaoContext _localctx = new CmdSelecaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdSelecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__9);
			setState(154);
			((CmdSelecaoContext)_localctx).expr = expr();
			setState(155);
			match(T__10);

			        listaTrue = new ArrayList<>(); // Caso base deve estar em listaTrue
			        stack.push(listaTrue);
			        _exprDecision = (((CmdSelecaoContext)_localctx).expr!=null?_input.getText(((CmdSelecaoContext)_localctx).expr.start,((CmdSelecaoContext)_localctx).expr.stop):null);
			      
			setState(157);
			blocoFun();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(158);
				match(T__11);

				          listaFalse = new ArrayList<>(); // Passo recursivo deve estar em listaFalse
				          stack.push(listaFalse);
				        
				setState(160);
				blocoFun();
				}
			}

			setState(163);
			match(T__12);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SC) {
				{
				setState(164);
				match(SC);
				}
			}


			        List<AbstractCommand> f = stack.pop(); // Agora armazenamos corretamente
			        List<AbstractCommand> t = (!stack.isEmpty()) ? stack.pop() : new ArrayList<>();

			        CommandDecisao cmd = new CommandDecisao(
			            _exprDecision, 
			            new ArrayList<>(t), 
			            new ArrayList<>(f)
			        );

			        stack.peek().add(cmd);
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdRetornoContext extends ParserRuleContext {
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdRetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRetorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdRetorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdRetorno(this);
		}
	}

	public final CmdRetornoContext cmdRetorno() throws RecognitionException {
		CmdRetornoContext _localctx = new CmdRetornoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cmdRetorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__13);
			setState(170);
			((CmdRetornoContext)_localctx).expr = expr();
			setState(171);
			match(SC);

			        CommandReturn cmd = new CommandReturn((((CmdRetornoContext)_localctx).expr!=null?_input.getText(((CmdRetornoContext)_localctx).expr.start,((CmdRetornoContext)_localctx).expr.stop):null));
			        if (!stack.isEmpty()) {
			            stack.peek().add(cmd); // Adiciona dentro do bloco atual (if ou função)
			        } else {
			            System.out.println("DEBUG: Retorno fora de contexto! " + cmd.generateJavaCode());
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdCallContext extends ParserRuleContext {
		public Token ID;
		public ArgsContext al;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CmdCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdCall(this);
		}
	}

	public final CmdCallContext cmdCall() throws RecognitionException {
		CmdCallContext _localctx = new CmdCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cmdCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((CmdCallContext)_localctx).ID = match(ID);
			setState(175);
			match(AP);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 79691776L) != 0)) {
				{
				setState(176);
				((CmdCallContext)_localctx).al = args();
				}
			}

			setState(179);
			match(FP);
			setState(180);
			match(SC);

			        String funcName = (((CmdCallContext)_localctx).ID!=null?((CmdCallContext)_localctx).ID.getText():null).trim();
			        verificaFuncao(funcName);
			        List<String> lista = new ArrayList<>();
			        if (((CmdCallContext)_localctx).al.exps != null) {
			            for (ExprContext exprCtx : ((CmdCallContext)_localctx).al.exps) {
			                lista.add(exprCtx.getText());
			            }
			        }
			        CommandCall cmd = new CommandCall(funcName, lista);
			        stack.peek().add(cmd);

			        // Imprima para debug
			        System.out.println("Função chamada: " + funcName);
			      
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> exps;
		public ExprContext expr;
		public List<ExprContext> e = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((ArgsContext)_localctx).expr = expr();
			((ArgsContext)_localctx).e.add(((ArgsContext)_localctx).expr);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(184);
				match(VIR);
				setState(185);
				((ArgsContext)_localctx).expr = expr();
				((ArgsContext)_localctx).e.add(((ArgsContext)_localctx).expr);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((ArgsContext)_localctx).exps =  ((ArgsContext)_localctx).e; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(EasyLanguageParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(EasyLanguageParser.OP, i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				termo();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(194);
					match(OP);
					setState(195);
					termo();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				termo();
				setState(202);
				match(OPREL);
				setState(203);
				termo();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public Token ID;
		public ArgsContext a;
		public Token NUMBER;
		public Token STRING;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(EasyLanguageParser.STRING, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_termo);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				((TermoContext)_localctx).ID = match(ID);
				setState(208);
				match(AP);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 79691776L) != 0)) {
					{
					setState(209);
					((TermoContext)_localctx).a = args();
					}
				}

				setState(212);
				match(FP);

				        String funcName = (((TermoContext)_localctx).ID!=null?((TermoContext)_localctx).ID.getText():null).trim();
				        verificaFuncao(funcName);
				        _exprContent = funcName + "("; // Alterado: sem concatenação errada

				        if (((TermoContext)_localctx).a.exps != null) {
				            int i = 0;
				            for (ExprContext exprCtx : ((TermoContext)_localctx).a.exps) {
				                if (i++ > 0) _exprContent += ", ";
				                _exprContent += exprCtx.getText();
				            }
				        }
				        _exprContent += ")";
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				((TermoContext)_localctx).ID = match(ID);

				        verificaID((((TermoContext)_localctx).ID!=null?((TermoContext)_localctx).ID.getText():null));
				        _exprContent = (((TermoContext)_localctx).ID!=null?((TermoContext)_localctx).ID.getText():null); // Alterado: evita concatenação errada
				      
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				((TermoContext)_localctx).NUMBER = match(NUMBER);

				        _exprContent = (((TermoContext)_localctx).NUMBER!=null?((TermoContext)_localctx).NUMBER.getText():null);
				      
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				((TermoContext)_localctx).STRING = match(STRING);

				        _exprContent = (((TermoContext)_localctx).STRING!=null?((TermoContext)_localctx).STRING.getText():null);
				      
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			expr();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(223);
				match(VIR);
				setState(224);
				expr();
				}
				}
				setState(229);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u00e7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002D\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002K\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003R\b\u0003\n\u0003\f\u0003U\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005]\b"+
		"\u0005\u000b\u0005\f\u0005^\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0003\bn\b\b\u0001\b\u0004\bq\b\b\u000b"+
		"\b\f\br\u0001\t\u0004\tv\b\t\u000b\t\f\tw\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0082\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u008e\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00a2\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a6\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00b2\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00bb\b\u0011\n\u0011\f\u0011\u00be\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00c5"+
		"\b\u0012\n\u0012\f\u0012\u00c8\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00ce\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00d3\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00dd\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00e2\b\u0014\n\u0014"+
		"\f\u0014\u00e5\t\u0014\u0001\u0014\u0000\u0000\u0015\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(\u0000\u0000\u00eb\u0000*\u0001\u0000\u0000\u0000\u00025\u0001\u0000"+
		"\u0000\u0000\u00048\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000\u0000"+
		"\bV\u0001\u0000\u0000\u0000\n\\\u0001\u0000\u0000\u0000\f`\u0001\u0000"+
		"\u0000\u0000\u000eg\u0001\u0000\u0000\u0000\u0010j\u0001\u0000\u0000\u0000"+
		"\u0012u\u0001\u0000\u0000\u0000\u0014\u0081\u0001\u0000\u0000\u0000\u0016"+
		"\u0083\u0001\u0000\u0000\u0000\u0018\u008a\u0001\u0000\u0000\u0000\u001a"+
		"\u0093\u0001\u0000\u0000\u0000\u001c\u0099\u0001\u0000\u0000\u0000\u001e"+
		"\u00a9\u0001\u0000\u0000\u0000 \u00ae\u0001\u0000\u0000\u0000\"\u00b7"+
		"\u0001\u0000\u0000\u0000$\u00cd\u0001\u0000\u0000\u0000&\u00dc\u0001\u0000"+
		"\u0000\u0000(\u00de\u0001\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000"+
		"+,\u0005\u0016\u0000\u0000,-\u0005\u0011\u0000\u0000-.\u0003\u0002\u0001"+
		"\u0000./\u0003\u0010\b\u0000/0\u0005\u0002\u0000\u000001\u0006\u0000\uffff"+
		"\uffff\u00001\u0001\u0001\u0000\u0000\u000024\u0003\u0004\u0002\u0000"+
		"32\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000089\u0005\u0003\u0000\u00009:\u0005\u0016\u0000\u0000"+
		":;\u0006\u0002\uffff\uffff\u0000;=\u0005\u000f\u0000\u0000<>\u0003\u0006"+
		"\u0003\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0005\u0010\u0000\u0000@A\u0005\u0004\u0000\u0000"+
		"AC\u0003\u000e\u0007\u0000BD\u0005\u0011\u0000\u0000CB\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0005\u0005"+
		"\u0000\u0000FG\u0006\u0002\uffff\uffff\u0000GH\u0003\u0012\t\u0000HJ\u0005"+
		"\u0006\u0000\u0000IK\u0005\u0011\u0000\u0000JI\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0006\u0002\uffff"+
		"\uffff\u0000M\u0005\u0001\u0000\u0000\u0000NS\u0003\b\u0004\u0000OP\u0005"+
		"\u0014\u0000\u0000PR\u0003\b\u0004\u0000QO\u0001\u0000\u0000\u0000RU\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"T\u0007\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005\u0016"+
		"\u0000\u0000WX\u0005\u0004\u0000\u0000XY\u0003\u000e\u0007\u0000YZ\u0006"+
		"\u0004\uffff\uffff\u0000Z\t\u0001\u0000\u0000\u0000[]\u0003\f\u0006\u0000"+
		"\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005"+
		"\u0007\u0000\u0000ab\u0005\u0016\u0000\u0000bc\u0005\u0004\u0000\u0000"+
		"cd\u0003\u000e\u0007\u0000de\u0005\u0011\u0000\u0000ef\u0006\u0006\uffff"+
		"\uffff\u0000f\r\u0001\u0000\u0000\u0000gh\u0005\u0016\u0000\u0000hi\u0006"+
		"\u0007\uffff\uffff\u0000i\u000f\u0001\u0000\u0000\u0000jk\u0005\u0005"+
		"\u0000\u0000km\u0006\b\uffff\uffff\u0000ln\u0003\n\u0005\u0000ml\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"oq\u0003\u0014\n\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0011\u0001\u0000"+
		"\u0000\u0000tv\u0003\u0014\n\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0006\t\uffff\uffff\u0000z\u0013\u0001\u0000\u0000"+
		"\u0000{\u0082\u0003\u0016\u000b\u0000|\u0082\u0003\u0018\f\u0000}\u0082"+
		"\u0003\u001a\r\u0000~\u0082\u0003\u001c\u000e\u0000\u007f\u0082\u0003"+
		"\u001e\u000f\u0000\u0080\u0082\u0003 \u0010\u0000\u0081{\u0001\u0000\u0000"+
		"\u0000\u0081|\u0001\u0000\u0000\u0000\u0081}\u0001\u0000\u0000\u0000\u0081"+
		"~\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005\b\u0000\u0000\u0084\u0085\u0005\u000f\u0000\u0000\u0085\u0086\u0005"+
		"\u0016\u0000\u0000\u0086\u0087\u0005\u0010\u0000\u0000\u0087\u0088\u0005"+
		"\u0011\u0000\u0000\u0088\u0089\u0006\u000b\uffff\uffff\u0000\u0089\u0017"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\t\u0000\u0000\u008b\u008d\u0005"+
		"\u000f\u0000\u0000\u008c\u008e\u0003(\u0014\u0000\u008d\u008c\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0005\u0010\u0000\u0000\u0090\u0091\u0005\u0011"+
		"\u0000\u0000\u0091\u0092\u0006\f\uffff\uffff\u0000\u0092\u0019\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0005\u0016\u0000\u0000\u0094\u0095\u0005\u0013"+
		"\u0000\u0000\u0095\u0096\u0003$\u0012\u0000\u0096\u0097\u0005\u0011\u0000"+
		"\u0000\u0097\u0098\u0006\r\uffff\uffff\u0000\u0098\u001b\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0005\n\u0000\u0000\u009a\u009b\u0003$\u0012\u0000"+
		"\u009b\u009c\u0005\u000b\u0000\u0000\u009c\u009d\u0006\u000e\uffff\uffff"+
		"\u0000\u009d\u00a1\u0003\u0012\t\u0000\u009e\u009f\u0005\f\u0000\u0000"+
		"\u009f\u00a0\u0006\u000e\uffff\uffff\u0000\u00a0\u00a2\u0003\u0012\t\u0000"+
		"\u00a1\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005\r\u0000\u0000\u00a4"+
		"\u00a6\u0005\u0011\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0006\u000e\uffff\uffff\u0000\u00a8\u001d\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005\u000e\u0000\u0000\u00aa\u00ab\u0003$\u0012\u0000\u00ab"+
		"\u00ac\u0005\u0011\u0000\u0000\u00ac\u00ad\u0006\u000f\uffff\uffff\u0000"+
		"\u00ad\u001f\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0016\u0000\u0000"+
		"\u00af\u00b1\u0005\u000f\u0000\u0000\u00b0\u00b2\u0003\"\u0011\u0000\u00b1"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0010\u0000\u0000\u00b4"+
		"\u00b5\u0005\u0011\u0000\u0000\u00b5\u00b6\u0006\u0010\uffff\uffff\u0000"+
		"\u00b6!\u0001\u0000\u0000\u0000\u00b7\u00bc\u0003$\u0012\u0000\u00b8\u00b9"+
		"\u0005\u0014\u0000\u0000\u00b9\u00bb\u0003$\u0012\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001"+
		"\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0006"+
		"\u0011\uffff\uffff\u0000\u00c0#\u0001\u0000\u0000\u0000\u00c1\u00c6\u0003"+
		"&\u0013\u0000\u00c2\u00c3\u0005\u0012\u0000\u0000\u00c3\u00c5\u0003&\u0013"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c7\u00ce\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0003&\u0013\u0000\u00ca\u00cb\u0005\u0015\u0000\u0000"+
		"\u00cb\u00cc\u0003&\u0013\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000\u00cd"+
		"\u00c1\u0001\u0000\u0000\u0000\u00cd\u00c9\u0001\u0000\u0000\u0000\u00ce"+
		"%\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0016\u0000\u0000\u00d0\u00d2"+
		"\u0005\u000f\u0000\u0000\u00d1\u00d3\u0003\"\u0011\u0000\u00d2\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0005\u0010\u0000\u0000\u00d5\u00dd\u0006"+
		"\u0013\uffff\uffff\u0000\u00d6\u00d7\u0005\u0016\u0000\u0000\u00d7\u00dd"+
		"\u0006\u0013\uffff\uffff\u0000\u00d8\u00d9\u0005\u0017\u0000\u0000\u00d9"+
		"\u00dd\u0006\u0013\uffff\uffff\u0000\u00da\u00db\u0005\u001a\u0000\u0000"+
		"\u00db\u00dd\u0006\u0013\uffff\uffff\u0000\u00dc\u00cf\u0001\u0000\u0000"+
		"\u0000\u00dc\u00d6\u0001\u0000\u0000\u0000\u00dc\u00d8\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\'\u0001\u0000\u0000\u0000"+
		"\u00de\u00e3\u0003$\u0012\u0000\u00df\u00e0\u0005\u0014\u0000\u0000\u00e0"+
		"\u00e2\u0003$\u0012\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e4)\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001"+
		"\u0000\u0000\u0000\u00145=CJS^mrw\u0081\u008d\u00a1\u00a5\u00b1\u00bc"+
		"\u00c6\u00cd\u00d2\u00dc\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}