package com.erik.DavaiLang.service;


import com.erik.DavaiLang.model.exceptions.EasySemanticException;
import com.erik.DavaiLang.model.parser.EasyLanguageLexer;
import com.erik.DavaiLang.model.parser.EasyLanguageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 * 
 * Arquivo fonte: extensao .easy
 * 
 */
public class MainService {

    public static void main(String[] args) {
        try {

            /*
                java -cp ./antlr-4.12.0-complete.jar org.antlr.v4.Tool EasyLanguage.g4 -package com.erik.DavaiLang.g4Generate -o .
             */
            EasyLanguageLexer lexer;
            EasyLanguageParser parser;

            // leio o arquivo "input.easy" e isso é entrada para o Analisador Lexico
            lexer = new EasyLanguageLexer(CharStreams.fromFileName("../../../resources/input.easy"));

            // crio um "fluxo de tokens" para passar para o PARSER
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // crio meu parser a partir desse tokenStream
            parser = new EasyLanguageParser(tokenStream);

            parser.prog();

            System.out.println("Compilation Successful");

            parser.exibeComandos();

            parser.generateCode();

        } catch (EasySemanticException ex) {
            System.err.println("Semantic error - " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR " + ex.getMessage());
        }

    }

}
