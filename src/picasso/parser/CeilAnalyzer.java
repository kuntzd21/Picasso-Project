package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the ceiling function.
 * 
 * @author Nick Steinert
 * 
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer {
	
	private static CeilAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a CeilAnalyzer
	 */
	public static CeilAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new CeilAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the ceiling token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Ceiling Function Token") {
			throw new ParseException("Not a ceiling function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Ceiling(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
