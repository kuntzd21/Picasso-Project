package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Subtraction;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the minus or "subtraction function".
 * 
 * @author Linkimals
 * 
 */
public class MinusAnalyzer implements SemanticAnalyzerInterface {
	
	private static MinusAnalyzer singleton;

	public static MinusAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new MinusAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Remove the minus token
		tokens.pop();
		
		// the parameters are the next tokens on the stack.
		// But, they need to be processed	
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new Subtraction(left, right);
	}

}
