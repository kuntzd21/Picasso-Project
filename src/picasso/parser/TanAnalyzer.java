package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tangent;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the tangent function.
 * 
 * @author Linkimals
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
		// Need to remove the tangent value token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Tangent Function Token") {
			throw new ParseException("Not a tangent function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Tangent(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
