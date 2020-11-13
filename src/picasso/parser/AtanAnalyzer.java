package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ATangent;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the tangent function.
 * 
 * @author Linkimals
 * 
 */
public class AtanAnalyzer extends UnaryFunctionAnalyzer {
	
	private static AtanAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a TanAnalyzer
	 */
	public static AtanAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new AtanAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the tangent value token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Atan Function Token") {
			throw new ParseException("Not an arc tangent function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new ATangent(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
