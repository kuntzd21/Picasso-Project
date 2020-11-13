package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Sine;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the sine function.
 * 
 * @author Linkimals
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
		// Need to remove the sine value token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Sine Function Token") {
			throw new ParseException("Not a sine function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Sine(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
