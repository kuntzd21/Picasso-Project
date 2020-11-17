package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the perlin Color function.
 * 
 * @author Nick Steinert
 * 
 */
public class PerlinColorAnalyzer implements SemanticAnalyzerInterface  {
	
	private static PerlinColorAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a PerlinColor
	 */
	public static PerlinColorAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new PerlinColorAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the Perlin Color token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Perlin Color Function Token") {
			throw new ParseException("Not a Perlin Color function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new PerlinColor(left, right);
		
	}

}
