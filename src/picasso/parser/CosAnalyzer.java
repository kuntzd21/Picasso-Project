package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cosine;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the cosine function.
 * 
 * @author Nick Steinert
 * 
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {
	
	private static CosAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a CosAnalyzer
	 */
	public static CosAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new CosAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the ceiling token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Cosine Function Token") {
			throw new ParseException("Not a cosine function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Cosine(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
