package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.language.expressions.Exp;
import picasso.parser.language.expressions.Log;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the logarithm function.
 * 
 * @author Nick Steinert
 * 
 */
public class LogAnalyzer extends UnaryFunctionAnalyzer {
	
	private static LogAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a LogAnalyzer
	 */
	public static LogAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new LogAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the exp token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Logarithm Function Token") {
			throw new ParseException("Not a log function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Log(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
