package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.tokens.Token;

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
		tokens.pop();
		
		// the parameters are the next tokens on the stack.
		// But, they need to be processed	
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new Addition(left, right);
	}

}
