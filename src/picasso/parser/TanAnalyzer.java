package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.language.expressions.Sin;
import picasso.parser.language.expressions.Tan;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the tangent function.
 * 
 * @author Nick Steinert
 * 
 */
public class TanAnalyzer extends UnaryFunctionAnalyzer {
	
	private static TanAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a TanAnalyzer
	 */
	public static TanAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new TanAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the ceiling token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Tan Function Token") {
			throw new ParseException("Not a tan function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Tan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
