public class Q1 {

	public static void main(String[] args) {
	
	}

	public static TokenType getOp(char ch) {
		TokenType singleCharOperator = null;

		// checks if the character is a single character operator such as plus, minus,
		// times or division sign
		if (ch == '+') {
			singleCharOperator = TokenType.OP_ADD;
		} else if (ch == '-') {
			singleCharOperator = TokenType.OP_SUBTRACT;
		} else if (ch == '*') {
			singleCharOperator = TokenType.OP_MULTIPLY;
		} else if (ch == '/') {
			singleCharOperator = TokenType.OP_DIVIDE;
		} else if (ch == '.') {
			singleCharOperator = TokenType.OP_DOT;
		} else if (ch == '=') {
			singleCharOperator = TokenType.OP_ASSIGN;
		} else if (ch == '>') {
			singleCharOperator = TokenType.OP_GREATER;
		} else if (ch == '<') {
			singleCharOperator = TokenType.OP_LESS;
		} else if (ch == '!') {
			singleCharOperator = TokenType.OP_NOT;
		} else if (ch == '%') {
			singleCharOperator = TokenType.OP_MOD;
		} else {
			singleCharOperator = null;
		}
		return singleCharOperator;

	}

	public static TokenType getOp(String s) {
		TokenType doubleCharOperator = null;

		// checks if character is a double character operator such as greater than or
		// less than etc.
		if (s.equals(">=")) {
			doubleCharOperator = TokenType.OP_GREATEREQUAL;
		} else if (s.equals("<=")) {
			doubleCharOperator = TokenType.OP_LESSEQUAL;
		} else if (s.equals("==")) {
			doubleCharOperator = TokenType.OP_EQUAL;
		} else if (s.equals("!=")) {
			doubleCharOperator = TokenType.OP_NOTEQUAL;
		} else if (s.equals("||")) {
			doubleCharOperator = TokenType.OP_OR;
		} else if (s.equals("&&")) {
			doubleCharOperator = TokenType.OP_AND;
		} else {
			doubleCharOperator = null;
		}
		return doubleCharOperator;

	}

	public static TokenType getSymbol(char ch) {
		TokenType symbol = null;

		// used to check if the character is equal to one of the defined symbols
		if (ch == '(') {
			symbol = TokenType.LEFT_PAREN;
		} else if (ch == ')') {
			symbol = TokenType.RIGHT_PAREN;
		} else if (ch == '{') {
			symbol = TokenType.LEFT_BRACE;
		} else if (ch == '}') {
			symbol = TokenType.RIGHT_BRACE;
		} else if (ch == '[') {
			symbol = TokenType.LEFT_BRACKET;
		} else if (ch == ']') {
			symbol = TokenType.RIGHT_BRACKET;
		} else if (ch == ';') {
			symbol = TokenType.SEMICOLON;
		} else if (ch == ':') {
			symbol = TokenType.COLON;
		} else if (ch == ',') {
			symbol = TokenType.COMMA;
		} else {
			symbol = null;

		}
		return symbol;

	}

	public static TokenType getKeyword(String s) {
		TokenType keyword = null;

		// checks to see if the word is equal to a word from a list of keywords
		if (s.equals("if")) {
			keyword = TokenType.KEYWORD_IF;
		} else if (s.equals("else")) {
			keyword = TokenType.KEYWORD_ELSE;
		} else if (s.equals("while")) {
			keyword = TokenType.KEYWORD_WHILE;
		} else if (s.equals("return")) {
			keyword = TokenType.KEYWORD_RETURN;
		} else if (s.equals("main")) {
			keyword = TokenType.KEYWORD_MAIN;
		} else if (s.equals("int")) {
			keyword = TokenType.KEYWORD_INT;
		} else if (s.equals("double")) {
			keyword = TokenType.KEYWORD_DOUBLE;
		} else if (s.equals("boolean")) {
			keyword = TokenType.KEYWORD_BOOLEAN;
		} else if (s.equals("String")) {
			keyword = TokenType.KEYWORD_STRING;
		} else if (s.equals("public")) {
			keyword = TokenType.KEYWORD_PUBLIC;
		} else if (s.equals("class")) {
			keyword = TokenType.KEYWORD_CLASS;
		} else if (s.equals("void")) {
			keyword = TokenType.KEYWORD_VOID;
		} else if (s.equals("for")) {
			keyword = TokenType.KEYWORD_FOR;
		} else if (s.equals("case")) {
			keyword = TokenType.KEYWORD_CASE;
		} else if (s.equals("switch")) {
			keyword = TokenType.KEYWORD_SWITCH;
		} else if (s.equals("static")) {
			keyword = TokenType.KEYWORD_STATIC;
		} else if (s.equals("break")) {
			keyword = TokenType.KEYWORD_BREAK;
		} else if (s.equals("continue")) {
			keyword = TokenType.KEYWORD_CONTINUE;
		} else if (s.equals("default")) {
			keyword = TokenType.KEYWORD_DEFAULT;
		} else {
			keyword = null;

		}
		return keyword;

	}

	// checks to see if character is equal to any letter within the alphabet
	// includes lower case a to z and uppercase A to Z
	public static boolean isLetter(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		else if (ch >= 'A' && ch <= 'Z')
			return true;
		else
			return false;
	}

	// checks if the character is a digit from 0 to 9
	public static boolean isDigit(char ch) {
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;

	}

	// checks to see if character is a space or indentation
	public static boolean isSpace(char ch) {
		if (ch == ' ')
			return true;
		else if (ch == '\n')
			return true;
		else if (ch == '	')
			return true;
		else
			return false;

	}
}
