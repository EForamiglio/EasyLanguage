package com.erik.DavaiLang.controller;

import com.erik.DavaiLang.controller.dto.ParseRequest;
import com.erik.DavaiLang.controller.dto.ParseResponse;
import com.erik.DavaiLang.model.exceptions.EasySemanticException;
import com.erik.DavaiLang.model.parser.EasyLanguageLexer;
import com.erik.DavaiLang.model.parser.EasyLanguageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ParseController {

    // 1) Exibe a página Thymeleaf
    @GetMapping("/parse")
    public String showParsePage(Model model) {
        // Exemplo inicial para preencher a área "Exemplo de código"
        String exemplo =
                "programa ExemploFatorial;\n" +
                        " // Declaração de função para cálculo de fatorial\n" +
                        " funcao fatorial(n: inteiro): inteiro \n" +
                        " inicio \n" +
                        "   se n <= 1 entao \n" +
                        "     retornar 1; \n" +
                        "   senao \n" +
                        "     retornar n * fatorial(n - 1); \n" +
                        "   fimse \n" +
                        " fim \n" +
                        " // Programa principal \n" +
                        " inicio \n" +
                        "   var numero: inteiro; \n" +
                        "   var resultado: inteiro; \n" +
                        "   escrever(\"Digite um número para calcular o fatorial: \"); \n" +
                        "   ler(numero); \n" +
                        "   resultado = fatorial(numero); \n" +
                        "   escrever(\"O fatorial de \", numero, \" é \", resultado); \n" +
                        " fimprograma";
        model.addAttribute("exemplo", exemplo);
        return "parse";  // nome do arquivo Thymeleaf: parse.html
    }

    // 2) Endpoint que faz o parse em background
    @PostMapping(path = "/api/parse", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ParseResponse doParse(@RequestBody ParseRequest request) {
        try {
            // 1. Monta o lexer e parser do ANTLR a partir da string enviada
            EasyLanguageLexer lexer = new EasyLanguageLexer(CharStreams.fromString(request.getCode()));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EasyLanguageParser parser = new EasyLanguageParser(tokens);

            // 2. Inicia a regra principal
            parser.prog();  // se der erro de sintaxe/semântico, vai lançar exceção

            // 3. Gera o Java (arquivo MainClass.java em /resources)
            parser.generateCode();

            // 4. Lê o conteúdo do arquivo gerado "./resources/MainClass.java"
            Path resourceDir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources");
            Path outputFile = resourceDir.resolve("MainClass.java");
            String javaText = "";
            try {
                byte[] data = Files.readAllBytes(outputFile);
                javaText = new String(data, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                return new ParseResponse(null, "Erro lendo MainClass.java: " + ex.getMessage());
            }

            // 5. Retorna o resultado bem‐sucedido
            return new ParseResponse(javaText, null);
        } catch (EasySemanticException e) {
            // Erro semântico personalizado
            return new ParseResponse(null, "Erro semântico: " + e.getMessage());
        } catch (Exception e) {
            // Qualquer outro tipo de erro (sintaxe, I/O, etc.)
            return new ParseResponse(null, "Erro: " + e.getMessage());
        }
    }
}
