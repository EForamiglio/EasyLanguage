package com.erik.DavaiLang.model.abstractsyntaxtree;

import com.erik.DavaiLang.model.datastructures.EasySymbol;
import com.erik.DavaiLang.model.datastructures.EasySymbolTable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class EasyProgram {
    private EasySymbolTable varTable;
    private List<AbstractCommand> commands;
    private List<EasyFunction> functions;

    public void setVarTable(EasySymbolTable varTable) {
        this.varTable = varTable;
    }

    public void setComandos(List<AbstractCommand> commands) {
        this.commands = commands;
    }

    public List<AbstractCommand> getComandos() {
        return commands;
    }

    public void setFunctions(List<EasyFunction> functions) {
        this.functions = functions;
    }

    public List<EasyFunction> getFunctions() {
        return functions;
    }

    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.*;\n\n");
        str.append("public class MainClass {\n");
        // Declaração do Scanner para entrada de dados
        str.append("  public static Scanner _key = new Scanner(System.in);\n\n");

        // Geração das funções
        if (functions != null) {
            for (EasyFunction func : functions) {
                str.append("  ").append(func.generateJavaCode()).append("\n");
            }
        }

        str.append("  public static void main(String args[]){\n");

        // declarações de variáveis
        if (varTable != null) {
            for (EasySymbol sym : varTable.getAll()) {
                str.append("    ").append(sym.generateJavaCode()).append("\n");
            }
        }

        // comandos do main
        for (AbstractCommand c : commands) {
            str.append("    ").append(c.generateJavaCode()).append("\n");
        }

        str.append("  }\n");
        str.append("}\n");

        try {
            String baseDir = System.getProperty("user.dir");
            Path resourceDir = Paths.get(baseDir, "src", "main", "resources");
            Files.createDirectories(resourceDir); // só se puder faltar a pasta
            Path outputFile = resourceDir.resolve("MainClass.java");
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(outputFile.toFile()),
                    StandardCharsets.UTF_8)) {
                writer.write(str.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }


    }
}
