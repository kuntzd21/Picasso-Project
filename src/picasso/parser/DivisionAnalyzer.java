package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the divide or "division function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class DivisionAnalyzer implements SemanticAnalyzerInterface {
	
	private static DivisionAnalyzer singleton;

	public static DivisionAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new DivisionAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Remove the division token
		tokens.pop();
		
		// the parameters are the next tokens on the stack.
		// But, they need to be processed	
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new Division(left, right);
	}

}
