package com.erik.DavaiLang.model.abstractsyntaxtree;

import java.util.List;
import java.util.ArrayList;
import com.erik.DavaiLang.model.datastructures.EasyVariable;

public class EasyFunction {
    private String name;
    private List<EasyVariable> params = new ArrayList<>();
    private int returnType;
    private List<AbstractCommand> body;

    
    public EasyFunction() {
        this.params = new ArrayList<>();
        this.body = new ArrayList<>(); // Inicializa `body` corretamente
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<EasyVariable> getParams() {
        return params;
    }

    public void setReturnType(int returnType) {
        this.returnType = returnType;
    }

    public void setBody(List<AbstractCommand> body) {
        this.body = body;
    }
    
    public String getBody() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (AbstractCommand cmd : body) {
            sb.append("    ").append(cmd.generateJavaCode()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        String ret = returnType == EasyVariable.NUMBER ? "int" : "String";
        sb.append("public static ").append(ret)
          .append(" ").append(name).append("(");
        for (int i = 0; i < params.size(); i++) {
            EasyVariable p = params.get(i);
            String t = p.getType() == EasyVariable.NUMBER ? "int" : "String";
            sb.append(t).append(" ").append(p.getName());
            if (i < params.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");
        for (AbstractCommand cmd : body) {
            // Use 4 espaços para recuo
            sb.append("    ").append(cmd.generateJavaCode()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
