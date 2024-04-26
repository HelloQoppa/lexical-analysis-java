public class Token {

    private TokenType type;

    private String value;

    public Token() {
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return this.type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Token type(TokenType type) {
        setType(type);
        return this;
    }

    public Token value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " type='" + getType() + "'" +
                ", value='" + getValue() + "'" +
                "}";
    }

}
