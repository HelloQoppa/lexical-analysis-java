import java.util.List;

public class App {
    public static void main(String[] args) {
        String sourceCode = "int x = 5 + 3;";
        Lexer lexer = new Lexer(sourceCode);
        List<Token> tokens = lexer.tokenize();

        for (Token token : tokens) {
            System.out.println(token.getType() + ": " + token.getValue());
        }
    }
}
