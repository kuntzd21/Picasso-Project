package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Atan;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.language.expressions.Sin;
import picasso.parser.language.expressions.Tan;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the Arc tangent function.
 * 
 * @author Nick Steinert
 * 
 */
public class AtanAnalyzer extends UnaryFunctionAnalyzer {
	
	private static AtanAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a AtanAnalyzer
	 */
	public static AtanAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new AtanAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the ceiling token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Atan Function Token") {
			throw new ParseException("Not an atan function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Atan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
