package com.erik.DavaiLang.model.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class CustomErrorListener extends BaseErrorListener {

    public static final CustomErrorListener INSTANCE = new CustomErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        // Aqui você pode customizar a mensagem do modo que desejar.
        String errorMessage = "Erro na linha " + line + ", posição " + charPositionInLine + ": ";

        // Exemplo de mensagem customizada para token ausente:
        if (msg.contains("missing")) {
            errorMessage += "Token faltante. " + msg;
        } else {
            errorMessage += msg;
        }

        // Lança uma exceção customizada (ou use outro mecanismo de sua escolha)
        throw new ParseCancellationException(errorMessage);
    }
}