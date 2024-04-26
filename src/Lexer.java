import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lexer {
    private String sourceCode;
    private int currentPosition;

    public Lexer(String sourceCode) {
        this.sourceCode = sourceCode;
        this.currentPosition = 0;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (currentPosition < sourceCode.length()) {
            Token token = nextToken();
            if (token != null) {
                tokens.add(token);
            }
        }

        return tokens;
    }

    private Token nextToken() {
        // Expressões regulares para cada tipo de token
        String keywordPattern = "\\b(if|else|while|for)\\b";
        String identifierPattern = "[a-zA-Z][a-zA-Z0-9]*";
        String numberPattern = "\\d+";
        String symbolPattern = "[()+\\-*/]";

        // Padrões e suas respectivas enumerações de tipo de token
        Pattern keywordRegex = Pattern.compile(keywordPattern);
        Pattern identifierRegex = Pattern.compile(identifierPattern);
        Pattern numberRegex = Pattern.compile(numberPattern);
        Pattern symbolRegex = Pattern.compile(symbolPattern);

        String codeSnippet = sourceCode.substring(currentPosition);
        Matcher matcher;

        matcher = keywordRegex.matcher(codeSnippet);
        if (matcher.lookingAt()) {
            String value = matcher.group();
            currentPosition += value.length();
            return new Token(TokenType.PALAVRA_CHAVE, value);
        }

        matcher = identifierRegex.matcher(codeSnippet);
        if (matcher.lookingAt()) {
            String value = matcher.group();
            currentPosition += value.length();
            return new Token(TokenType.IDENTIFICADOR, value);
        }

        matcher = numberRegex.matcher(codeSnippet);
        if (matcher.lookingAt()) {
            String value = matcher.group();
            currentPosition += value.length();
            return new Token(TokenType.NUMERO, value);
        }

        matcher = symbolRegex.matcher(codeSnippet);
        if (matcher.lookingAt()) {
            String value = matcher.group();
            currentPosition += value.length();
            return new Token(TokenType.SIMBOLO, value);
        }

        currentPosition++; // Avança para o próximo caractere
        return null;
    }
}
