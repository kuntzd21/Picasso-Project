package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.tokens.NumberToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.PlusToken;

/**
 * Handles parsing the plus or "addition function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class PlusAnalyzer implements SemanticAnalyzerInterface {
	
	private static PlusAnalyzer singleton;

	public static PlusAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new PlusAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Remove the plus token
		PlusToken ptoken = (PlusToken) tokens.pop(); 
		
		if (ptoken.isFunction() != true) {
			throw new ParseException("Not a function.");
		}
		
		// the parameters are the next tokens on the stack.
		NumberToken ntoken = (NumberToken) tokens.pop();
		
		// But, they need to be processed
		double value = ntoken.value();
		
		if (value < -1 || value > 1) {
			throw new ParseException("Constant is out of range [-1, 1]");
		}
		
		// TODO: Need to finish.
		return new Addition(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens), SemanticAnalyzer.getInstance().generateExpressionTree(
						tokens) );
	}

}
