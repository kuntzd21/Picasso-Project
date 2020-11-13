package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the clamp function.
 * 
 * @author Linkimals
 * 
 */
public class ClampAnalyzer extends UnaryFunctionAnalyzer {
	
	private static ClampAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a ClampAnalyzer
	 */
	public static ClampAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ClampAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the clamp token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Clamp Function Token") {
			throw new ParseException("Not a clamp function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Clamp(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
