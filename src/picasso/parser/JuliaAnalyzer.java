package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Julia;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Julia function.
 * 
 * @author Linkimals
 * 
 */
public class JuliaAnalyzer implements SemanticAnalyzerInterface {
	
	private static JuliaAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a RandomAnalyzer
	 */
	public static JuliaAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new JuliaAnalyzer();
		}
		return singleton;
	}
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the random token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Julia Function Token") {
			throw new ParseException("Not a julia function token.");
		}
		
		return new Julia();
	}
}
