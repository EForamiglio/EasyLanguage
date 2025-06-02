// Generated from EasyLanguage.g4 by ANTLR 4.12.0
package com.erik.DavaiLang.model.parser;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyLanguageParser}.
 */
public interface EasyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(EasyLanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(EasyLanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#funcoes}.
	 * @param ctx the parse tree
	 */
	void enterFuncoes(EasyLanguageParser.FuncoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#funcoes}.
	 * @param ctx the parse tree
	 */
	void exitFuncoes(EasyLanguageParser.FuncoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#funcaoDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncaoDecl(EasyLanguageParser.FuncaoDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#funcaoDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncaoDecl(EasyLanguageParser.FuncaoDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(EasyLanguageParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(EasyLanguageParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(EasyLanguageParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(EasyLanguageParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(EasyLanguageParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(EasyLanguageParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(EasyLanguageParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(EasyLanguageParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#blocoPrincipal}.
	 * @param ctx the parse tree
	 */
	void enterBlocoPrincipal(EasyLanguageParser.BlocoPrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#blocoPrincipal}.
	 * @param ctx the parse tree
	 */
	void exitBlocoPrincipal(EasyLanguageParser.BlocoPrincipalContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#blocoFun}.
	 * @param ctx the parse tree
	 */
	void enterBlocoFun(EasyLanguageParser.BlocoFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#blocoFun}.
	 * @param ctx the parse tree
	 */
	void exitBlocoFun(EasyLanguageParser.BlocoFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(EasyLanguageParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(EasyLanguageParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(EasyLanguageParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(EasyLanguageParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(EasyLanguageParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(EasyLanguageParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdSelecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdSelecao(EasyLanguageParser.CmdSelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdSelecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdSelecao(EasyLanguageParser.CmdSelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdRetorno}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorno(EasyLanguageParser.CmdRetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdRetorno}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorno(EasyLanguageParser.CmdRetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdCall}.
	 * @param ctx the parse tree
	 */
	void enterCmdCall(EasyLanguageParser.CmdCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdCall}.
	 * @param ctx the parse tree
	 */
	void exitCmdCall(EasyLanguageParser.CmdCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(EasyLanguageParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(EasyLanguageParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EasyLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EasyLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(EasyLanguageParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(EasyLanguageParser.ExprListContext ctx);
}