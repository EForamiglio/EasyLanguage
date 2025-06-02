package com.erik.DavaiLang.model.abstractsyntaxtree;

import java.util.List;

// CommandCall.java
public class CommandCall extends AbstractCommand {
    private String funcName;
    private List<String> args;
    public CommandCall(String funcName, List<String> args) {
        this.funcName = funcName; this.args = args;
    }
    @Override
    public String generateJavaCode() {
        System.out.println("DEBUG: Chamando função -> " + funcName); // Debug aqui
        if (funcName.equals("System.out.println")) {
            return funcName + "(" + String.join(" + ", args) + ");";
        }
        return funcName + "(" + String.join(", ", args) + ");";
    }
}
