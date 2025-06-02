package com.erik.DavaiLang.model.abstractsyntaxtree;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;

    public CommandDecisao(String condition, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf) {
        this.condition = condition;
        this.listaTrue = lt;
        this.listaFalse = lf;
    }

    @Override
public String generateJavaCode() {
    StringBuilder str = new StringBuilder();
    str.append("if (" + condition + ") {\n");

    for (AbstractCommand cmd : listaTrue) {
        str.append("    ").append(cmd.generateJavaCode()).append("\n");
    }

    str.append("} else {\n");
    for (AbstractCommand cmd : listaFalse) {
        str.append("    ").append(cmd.generateJavaCode()).append("\n");
    }
    str.append("}");

    System.out.println("DEBUG: Gerando decisão -> " + str.toString());
    return str.toString();
}

    @Override
    public String toString() {
        return "CommandDecisao [condition=" + condition + ", listaTrue=" + listaTrue + ", listaFalse=" + listaFalse
                + "]";
    }

}
