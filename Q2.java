import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Q2 {

	public static void main(String[] args) {
		String text = readFile("src/Q2Example.java");
		scan(text);

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

	public static void scan(String prog) {

		int n = prog.length();
		int index = 0; // index initialized as 0
		int lineCount = 1; // line number used to store the current line number - increments if \ encountered initlialized outside of the loop so the value is not reset

		while (index < n) {

			// current char at index n
			char ch = prog.charAt(index);

			TokenType op = getOp(ch); // is it an operator or null?
			TokenType sym = getSymbol(ch); // is it a symbol or null?

			boolean bSpace = isSpace(ch); // is it white space?
			boolean bLetter = isLetter(ch); // boolean to detect letters
			boolean bDigit = isDigit(ch); // boolean to detect digits
			
			if (ch == '\r') { //if new line is encountered, increment line count - tried \n || \r but it would increment it twice each time
				lineCount++;
				index++;
				continue;
			}

			// if the value is a space, increment and continue
			if (bSpace) {
				index++;
				continue;

				// if the value is a symbol, print the token type and the character
				// !null means it is true and the tokentype sym will have an assigned value
			} else if (sym != null) {
				System.out.println(lineCount + ". " + sym + ", " + ch); // print the tokentype and character
				index++;
				continue;

				// if the value is a single operator, print the token type and the character
			} else if (op != null) {
				System.out.println(lineCount + ". " + op + ", " + ch);
				index++;
				continue;

			// if the value of ch is a digit and the next value is a ., print double rather                                                                             
			// than integer
			}else if (bDigit) { 
				String word = "";
				word = word + ch;
				index++;
				while (index < n) { // collects all digits in the string
					ch = prog.charAt(index);
					if (isDigit(ch) || ch == '.') { //while the character is not a digit continue to traverse the input
						word = word + ch; //add the characters encountered to the string of characters
						index++; //increment the index (move along the string)
						continue;
					}else {
						break;
		
					}
					
					
				}
				
				if (word.contains(".")) { //if the created word (number) contains a period
					System.out.println(lineCount + ". " + TokenType.DOUBLE + ", " + word); //it is a double
				}else {					
					System.out.println(lineCount + ". " + TokenType.INTEGER + ", " + word); //else it is an integer
					
				}

			
			}
			
			// if the value is a string of letters (a string/word), print the token type and
			// the string of characters
			else if (bLetter) {
				String word = "";
				word = word + ch;
				index++;
				while (index < n) { // collects all of the letters in a word
					ch = prog.charAt(index);
					if (isLetter(ch)) {
						word = word + ch;
						index++;
						continue;
					} else {
						break; // stops the while loop when non-letter character is encountered

					}

				}

				//checks if the word is equal to the list of keywords in weeJava specification
				TokenType keyword = getKeyword(word); // is the word a keyword or null?

				if (keyword != null) { //if keyword is true
					System.out.println(lineCount + ". " + keyword + ", " + word); //print token type of keyword and word under consideration
					index++;
					continue;
				}
					else if (word.equals("true") || word.equals("false")) { //otherwise if it equals true or false
						word = word + ';'; //with a semicolon at the end
						System.out.println(lineCount + ". " + TokenType.BOOLEAN + ", " + word); //tokentype is equal to boolean, output this and the word
						index++;
						continue;
				} else {
					System.out.println(lineCount + ". " + TokenType.IDENTIFIER + ", " + word); //else if the word is not boolean/literal or keyword it is an identifier
					continue;
				}
				

			} else if (ch == '"') {  //if the character is a " quotation 
				String word = "";
				word = word + ch;
				index ++;
				while (index < n) { // collects the characters 
					ch = prog.charAt(index);
					if (ch != '"') { //collects characters that are not equal to "
						word = word + ch;
						index ++;
						continue;                                                                
					}
					else { //else the word is a string ending in " 
						word = word + '"'; 
						index++;
						break;
					}
					
				}
				
				System.out.println(lineCount + ". " + TokenType.STRING + ", " + word); //outputs token and the string within quotes
			
			}
			else if (ch == '=' || ch == '>' || ch == '<' || ch == '&' || ch == '!' || ch == '|') {
				String doubleOperator = "";
				doubleOperator = doubleOperator + ch;
				index++;
				while (index < n) {
					ch = prog.charAt(index);
					if (ch == '=' || ch == '&' || ch == '|') {
						doubleOperator = doubleOperator + ch;
						index++;
						continue;
					}
					else {
						break;
					}
				}
				
				TokenType doubleOp = getOp(doubleOperator);
				if (doubleOp != null) {
					System.out.println(lineCount + ". " + doubleOp + ", " + doubleOperator);
			}else {
				continue;
				}
				
			}
			
			
		}
	
	}


	

		/**
		 * To read the content of a file into a string
		 * @param fname the file name
		 * @return the string representing the file content
		 */
		public static String readFile(String fname) {
			String content = null;
			try {
		        content = new String(Files.readAllBytes(Paths.get(fname)));
			} catch (IOException e) {
				System.out.println("Fail to read a file");
			}
			
			return content;
		}
		
	

}