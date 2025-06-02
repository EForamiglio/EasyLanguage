package com.erik.DavaiLang.model.abstractsyntaxtree;

// CommandReturn.java
public class CommandReturn extends AbstractCommand {
    private String expr;

    public CommandReturn(String expr) { 
        this.expr = expr; 
    }

    @Override
    public String generateJavaCode() {
        return "return " + expr + ";"; // Certifique-se de que "expr" está correto
    }
}