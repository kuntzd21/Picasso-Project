package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Multiplication;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the * or "multiplication function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class MultiplicationAnalyzer implements SemanticAnalyzerInterface {
	
	private static MultiplicationAnalyzer singleton;

	public static MultiplicationAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new MultiplicationAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Remove the multiply token
		tokens.pop();
		
		// the parameters are the next tokens on the stack.
		// But, they need to be processed	
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new Multiplication(left, right);
	}

}