grammar EasyLanguage;

@header{
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
}

@members{
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
}

prog
    : 'programa' ID SC funcoes blocoPrincipal 'fimprograma'
      {
        program.setVarTable(symbolTable);
        program.setFunctions(functions);
        program.setComandos(stack.pop());
      }
    ;

funcoes
    : (funcaoDecl)*
    ;

funcaoDecl
    : 'funcao' ID
      {
        currentFunction = new EasyFunction();
        currentFunction.setName($ID.text);
        functions.add(currentFunction);
      }
      AP params? FP ':' tipo SC? 'inicio'
      {
        currentFunction.setReturnType(_tipo);
        curThread = new ArrayList<>();
        stack.push(curThread);
      }
      blocoFun
      'fim' SC?
      {
        List<AbstractCommand> bodyCommands = stack.pop();
        System.out.println("DEBUG: Comandos armazenados na função -> " + bodyCommands);
        currentFunction.setBody(bodyCommands);
      }
    ;

params
    : param (VIR param)*
    ;

param
    : ID ':' tipo
      {
        EasyVariable p = new EasyVariable($ID.text, _tipo, null);
        currentFunction.getParams().add(p);
        symbolTable.add(p); // Adiciona à tabela de símbolos
      }
    ;

decl
    : varDecl+
    ;

varDecl
    : 'var' ID ':' tipo SC
      {
        _varName = $ID.text;
        symbol = new EasyVariable(_varName, _tipo, null);
        if (!symbolTable.exists(_varName)) symbolTable.add(symbol);
        else throw new EasySemanticException("Symbol " + _varName + " already declared");
      }
    ;

tipo
    : 'inteiro' { _tipo = EasyVariable.NUMBER; }
    | 'texto'   { _tipo = EasyVariable.TEXT; }
    ;

blocoPrincipal
    : 'inicio'
      {
        curThread = new ArrayList<>();
        stack.push(curThread);
      }
      decl? cmd+
    ;

blocoFun
    : cmd+
      {
        if (!stack.isEmpty()) {
            List<AbstractCommand> blocoComandos = stack.peek(); // NÃO removemos da pilha!
            System.out.println("DEBUG: Comandos dentro de blocoFun -> " + blocoComandos);
        } else {
            System.out.println("DEBUG: Pilha vazia ao processar `blocoFun`!");
        }
      }
    ;

cmd
    : cmdLeitura
    | cmdEscrita
    | cmdAttrib
    | cmdSelecao
    | cmdRetorno
    | cmdCall
    ;

cmdLeitura
    : 'ler' AP ID FP SC
      {
        verificaID($ID.text);
        CommandLeitura cmd = new CommandLeitura($ID.text,
            (EasyVariable)symbolTable.get($ID.text));
        stack.peek().add(cmd);
      }
    ;

cmdEscrita
    : 'escrever' AP el=exprList? FP SC
      {
        EasyLanguageParser.ExprListContext list = $el.text;
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
    ;

cmdAttrib
    : ID ATTR expr SC
      {
        verificaID($ID.text);
        System.out.println("DEBUG: Expressão atribuída -> " + _exprContent); // Debug
        CommandAtribuicao cmd = new CommandAtribuicao($ID.text, _exprContent);
        stack.peek().add(cmd);
      }
    ;


cmdSelecao
    : 'se' expr 'entao'
      {
        listaTrue = new ArrayList<>(); // Caso base deve estar em listaTrue
        stack.push(listaTrue);
        _exprDecision = $expr.text;
      }
      blocoFun
      ( 'senao'
        {
          listaFalse = new ArrayList<>(); // Passo recursivo deve estar em listaFalse
          stack.push(listaFalse);
        }
        blocoFun
      )?
      'fimse' SC?
      {
        List<AbstractCommand> f = stack.pop(); // Agora armazenamos corretamente
        List<AbstractCommand> t = (!stack.isEmpty()) ? stack.pop() : new ArrayList<>();

        CommandDecisao cmd = new CommandDecisao(
            _exprDecision, 
            new ArrayList<>(t), 
            new ArrayList<>(f)
        );

        stack.peek().add(cmd);
      }
    ;

cmdRetorno
    : 'retornar' expr SC
      {
        CommandReturn cmd = new CommandReturn($expr.text);
        if (!stack.isEmpty()) {
            stack.peek().add(cmd); // Adiciona dentro do bloco atual (if ou função)
        } else {
            System.out.println("DEBUG: Retorno fora de contexto! " + cmd.generateJavaCode());
        }
      }
    ;

cmdCall
    : ID AP al=args? FP SC
      {
        String funcName = $ID.text.trim();
        verificaFuncao(funcName);
        List<String> lista = new ArrayList<>();
        if ($al.exps != null) {
            for (ExprContext exprCtx : $al.exps) {
                lista.add(exprCtx.getText());
            }
        }
        CommandCall cmd = new CommandCall(funcName, lista);
        stack.peek().add(cmd);

        // Imprima para debug
        System.out.println("Função chamada: " + funcName);
      }
    ;

args returns [List<ExprContext> exps]
    : e+=expr (VIR e+=expr)* { $exps = $e; }
    ;

expr
    : termo (OP termo)*
    | termo OPREL termo
    ;

termo
    : ID AP a=args? FP
      {
        String funcName = $ID.text.trim();
        verificaFuncao(funcName);
        _exprContent = funcName + "("; // Alterado: sem concatenação errada

        if ($a.exps != null) {
            int i = 0;
            for (ExprContext exprCtx : $a.exps) {
                if (i++ > 0) _exprContent += ", ";
                _exprContent += exprCtx.getText();
            }
        }
        _exprContent += ")";
      }
    | ID
      {
        verificaID($ID.text);
        _exprContent = $ID.text; // Alterado: evita concatenação errada
      }
    | NUMBER
      {
        _exprContent = $NUMBER.text;
      }
    | STRING
      {
        _exprContent = $STRING.text;
      }
    ;


exprList
    : expr (VIR expr)*
    ;

AP   : '(';
FP   : ')';
SC   : ';';
OP   : '+' | '-' | '*' | '/';
ATTR : '=';
VIR  : ',';

OPREL : '>' | '<' | '<=' | '>=' | '==' | '!=';

ID     : [a-zA-Z_] [a-zA-Z0-9_]*;
NUMBER : [0-9]+ ('.' [0-9]+)?;
WS      : [ \t\r\n]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;

STRING : '"' (~["])* '"';