package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Random;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the random function.
 * 
 * @author Linkimals
 * 
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {
	
	private static RandomAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a RandomAnalyzer
	 */
	public static RandomAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new RandomAnalyzer();
		}
		return singleton;
	}
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the random token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Random Function Token") {
			throw new ParseException("Not a random function token.");
		}
		
		return new Random();
	}
}
