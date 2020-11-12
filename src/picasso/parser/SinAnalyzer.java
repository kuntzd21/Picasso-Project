package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.language.expressions.Sin;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the ceiling function.
 * 
 * @author Nick Steinert
 * 
 */
public class SinAnalyzer extends UnaryFunctionAnalyzer {
	
	private static SinAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a SinAnalyzer
	 */
	public static SinAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new SinAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the ceiling token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Sin Function Token") {
			throw new ParseException("Not a sin function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Sin(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
