// Generated from EasyLanguage.g4 by ANTLR 4.12.0
package com.erik.DavaiLang.model.parser;


    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

	import com.erik.DavaiLang.model.abstractsyntaxtree.AbstractCommand;
	import com.erik.DavaiLang.model.abstractsyntaxtree.EasyFunction;
	import com.erik.DavaiLang.model.abstractsyntaxtree.EasyProgram;
	import com.erik.DavaiLang.model.datastructures.EasySymbol;
	import com.erik.DavaiLang.model.datastructures.EasySymbolTable;
	import com.erik.DavaiLang.model.exceptions.EasySemanticException;
	import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EasyLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, AP=17, 
		FP=18, SC=19, OP=20, ATTR=21, VIR=22, OPREL=23, ID=24, NUMBER=25, WS=26, 
		COMMENT=27, STRING=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "AP", "FP", 
			"SC", "OP", "ATTR", "VIR", "OPREL", "ID", "NUMBER", "WS", "COMMENT", 
			"STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprograma'", "'funcao'", "':'", "'inicio'", "'fim'", 
			"'var'", "'inteiro'", "'texto'", "'ler'", "'escrever'", "'se'", "'entao'", 
			"'senao'", "'fimse'", "'retornar'", "'('", "')'", "';'", null, "'='", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", "VIR", 
			"OPREL", "ID", "NUMBER", "WS", "COMMENT", "STRING"
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


	public EasyLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EasyLanguage.g4"; }

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
		"\u0004\u0000\u001c\u00e5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u00b5\b\u0016\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u00b9\b\u0017\n\u0017\f\u0017\u00bc\t\u0017\u0001\u0018\u0004\u0018\u00bf"+
		"\b\u0018\u000b\u0018\f\u0018\u00c0\u0001\u0018\u0001\u0018\u0004\u0018"+
		"\u00c5\b\u0018\u000b\u0018\f\u0018\u00c6\u0003\u0018\u00c9\b\u0018\u0001"+
		"\u0019\u0004\u0019\u00cc\b\u0019\u000b\u0019\f\u0019\u00cd\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a"+
		"\u00d6\b\u001a\n\u001a\f\u001a\u00d9\t\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u00df\b\u001b\n\u001b\f\u001b\u00e2\t\u001b"+
		"\u0001\u001b\u0001\u001b\u0000\u0000\u001c\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c\u0001\u0000\b\u0003\u0000*+--//\u0002\u0000<<>>\u0003\u0000AZ"+
		"__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u0002\u0000"+
		"\n\n\r\r\u0001\u0000\"\"\u00ef\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00019\u0001\u0000\u0000\u0000\u0003B"+
		"\u0001\u0000\u0000\u0000\u0005N\u0001\u0000\u0000\u0000\u0007U\u0001\u0000"+
		"\u0000\u0000\tW\u0001\u0000\u0000\u0000\u000b^\u0001\u0000\u0000\u0000"+
		"\rb\u0001\u0000\u0000\u0000\u000ff\u0001\u0000\u0000\u0000\u0011n\u0001"+
		"\u0000\u0000\u0000\u0013t\u0001\u0000\u0000\u0000\u0015x\u0001\u0000\u0000"+
		"\u0000\u0017\u0081\u0001\u0000\u0000\u0000\u0019\u0084\u0001\u0000\u0000"+
		"\u0000\u001b\u008a\u0001\u0000\u0000\u0000\u001d\u0090\u0001\u0000\u0000"+
		"\u0000\u001f\u0096\u0001\u0000\u0000\u0000!\u009f\u0001\u0000\u0000\u0000"+
		"#\u00a1\u0001\u0000\u0000\u0000%\u00a3\u0001\u0000\u0000\u0000\'\u00a5"+
		"\u0001\u0000\u0000\u0000)\u00a7\u0001\u0000\u0000\u0000+\u00a9\u0001\u0000"+
		"\u0000\u0000-\u00b4\u0001\u0000\u0000\u0000/\u00b6\u0001\u0000\u0000\u0000"+
		"1\u00be\u0001\u0000\u0000\u00003\u00cb\u0001\u0000\u0000\u00005\u00d1"+
		"\u0001\u0000\u0000\u00007\u00dc\u0001\u0000\u0000\u00009:\u0005p\u0000"+
		"\u0000:;\u0005r\u0000\u0000;<\u0005o\u0000\u0000<=\u0005g\u0000\u0000"+
		"=>\u0005r\u0000\u0000>?\u0005a\u0000\u0000?@\u0005m\u0000\u0000@A\u0005"+
		"a\u0000\u0000A\u0002\u0001\u0000\u0000\u0000BC\u0005f\u0000\u0000CD\u0005"+
		"i\u0000\u0000DE\u0005m\u0000\u0000EF\u0005p\u0000\u0000FG\u0005r\u0000"+
		"\u0000GH\u0005o\u0000\u0000HI\u0005g\u0000\u0000IJ\u0005r\u0000\u0000"+
		"JK\u0005a\u0000\u0000KL\u0005m\u0000\u0000LM\u0005a\u0000\u0000M\u0004"+
		"\u0001\u0000\u0000\u0000NO\u0005f\u0000\u0000OP\u0005u\u0000\u0000PQ\u0005"+
		"n\u0000\u0000QR\u0005c\u0000\u0000RS\u0005a\u0000\u0000ST\u0005o\u0000"+
		"\u0000T\u0006\u0001\u0000\u0000\u0000UV\u0005:\u0000\u0000V\b\u0001\u0000"+
		"\u0000\u0000WX\u0005i\u0000\u0000XY\u0005n\u0000\u0000YZ\u0005i\u0000"+
		"\u0000Z[\u0005c\u0000\u0000[\\\u0005i\u0000\u0000\\]\u0005o\u0000\u0000"+
		"]\n\u0001\u0000\u0000\u0000^_\u0005f\u0000\u0000_`\u0005i\u0000\u0000"+
		"`a\u0005m\u0000\u0000a\f\u0001\u0000\u0000\u0000bc\u0005v\u0000\u0000"+
		"cd\u0005a\u0000\u0000de\u0005r\u0000\u0000e\u000e\u0001\u0000\u0000\u0000"+
		"fg\u0005i\u0000\u0000gh\u0005n\u0000\u0000hi\u0005t\u0000\u0000ij\u0005"+
		"e\u0000\u0000jk\u0005i\u0000\u0000kl\u0005r\u0000\u0000lm\u0005o\u0000"+
		"\u0000m\u0010\u0001\u0000\u0000\u0000no\u0005t\u0000\u0000op\u0005e\u0000"+
		"\u0000pq\u0005x\u0000\u0000qr\u0005t\u0000\u0000rs\u0005o\u0000\u0000"+
		"s\u0012\u0001\u0000\u0000\u0000tu\u0005l\u0000\u0000uv\u0005e\u0000\u0000"+
		"vw\u0005r\u0000\u0000w\u0014\u0001\u0000\u0000\u0000xy\u0005e\u0000\u0000"+
		"yz\u0005s\u0000\u0000z{\u0005c\u0000\u0000{|\u0005r\u0000\u0000|}\u0005"+
		"e\u0000\u0000}~\u0005v\u0000\u0000~\u007f\u0005e\u0000\u0000\u007f\u0080"+
		"\u0005r\u0000\u0000\u0080\u0016\u0001\u0000\u0000\u0000\u0081\u0082\u0005"+
		"s\u0000\u0000\u0082\u0083\u0005e\u0000\u0000\u0083\u0018\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005e\u0000\u0000\u0085\u0086\u0005n\u0000\u0000\u0086"+
		"\u0087\u0005t\u0000\u0000\u0087\u0088\u0005a\u0000\u0000\u0088\u0089\u0005"+
		"o\u0000\u0000\u0089\u001a\u0001\u0000\u0000\u0000\u008a\u008b\u0005s\u0000"+
		"\u0000\u008b\u008c\u0005e\u0000\u0000\u008c\u008d\u0005n\u0000\u0000\u008d"+
		"\u008e\u0005a\u0000\u0000\u008e\u008f\u0005o\u0000\u0000\u008f\u001c\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0005f\u0000\u0000\u0091\u0092\u0005i\u0000"+
		"\u0000\u0092\u0093\u0005m\u0000\u0000\u0093\u0094\u0005s\u0000\u0000\u0094"+
		"\u0095\u0005e\u0000\u0000\u0095\u001e\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0005r\u0000\u0000\u0097\u0098\u0005e\u0000\u0000\u0098\u0099\u0005t"+
		"\u0000\u0000\u0099\u009a\u0005o\u0000\u0000\u009a\u009b\u0005r\u0000\u0000"+
		"\u009b\u009c\u0005n\u0000\u0000\u009c\u009d\u0005a\u0000\u0000\u009d\u009e"+
		"\u0005r\u0000\u0000\u009e \u0001\u0000\u0000\u0000\u009f\u00a0\u0005("+
		"\u0000\u0000\u00a0\"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005)\u0000"+
		"\u0000\u00a2$\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005;\u0000\u0000\u00a4"+
		"&\u0001\u0000\u0000\u0000\u00a5\u00a6\u0007\u0000\u0000\u0000\u00a6(\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005=\u0000\u0000\u00a8*\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005,\u0000\u0000\u00aa,\u0001\u0000\u0000\u0000\u00ab"+
		"\u00b5\u0007\u0001\u0000\u0000\u00ac\u00ad\u0005<\u0000\u0000\u00ad\u00b5"+
		"\u0005=\u0000\u0000\u00ae\u00af\u0005>\u0000\u0000\u00af\u00b5\u0005="+
		"\u0000\u0000\u00b0\u00b1\u0005=\u0000\u0000\u00b1\u00b5\u0005=\u0000\u0000"+
		"\u00b2\u00b3\u0005!\u0000\u0000\u00b3\u00b5\u0005=\u0000\u0000\u00b4\u00ab"+
		"\u0001\u0000\u0000\u0000\u00b4\u00ac\u0001\u0000\u0000\u0000\u00b4\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b5.\u0001\u0000\u0000\u0000\u00b6\u00ba\u0007"+
		"\u0002\u0000\u0000\u00b7\u00b9\u0007\u0003\u0000\u0000\u00b8\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb0\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bf\u0007\u0004"+
		"\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c8\u0001\u0000\u0000\u0000\u00c2\u00c4\u0005.\u0000"+
		"\u0000\u00c3\u00c5\u0007\u0004\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c2\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c92\u0001\u0000\u0000\u0000\u00ca\u00cc\u0007\u0005\u0000\u0000"+
		"\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0006\u0019\u0000\u0000"+
		"\u00d04\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005/\u0000\u0000\u00d2\u00d3"+
		"\u0005/\u0000\u0000\u00d3\u00d7\u0001\u0000\u0000\u0000\u00d4\u00d6\b"+
		"\u0006\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0006\u001a\u0000\u0000\u00db6\u0001\u0000"+
		"\u0000\u0000\u00dc\u00e0\u0005\"\u0000\u0000\u00dd\u00df\b\u0007\u0000"+
		"\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0005\"\u0000\u0000\u00e48\u0001\u0000\u0000\u0000"+
		"\t\u0000\u00b4\u00ba\u00c0\u00c6\u00c8\u00cd\u00d7\u00e0\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}