package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Perlin BW function.
 * 
 * @author Nick Steinert
 * 
 */
public class PerlinBWAnalyzer implements SemanticAnalyzerInterface  {
	
	private static PerlinBWAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a PerlinBW
	 */
	public static PerlinBWAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new PerlinBWAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the Perlin BW token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Perlin BW Function Token") {
			throw new ParseException("Not a Perlin BW function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new PerlinBW(left, right);
		
	}

}
