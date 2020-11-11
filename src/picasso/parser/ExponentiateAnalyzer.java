/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponentiate;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the exponentiate or "exponentiate function".
 * 
 * @author Linkimals
 *
 */
public class ExponentiateAnalyzer implements SemanticAnalyzerInterface {
	
	private static ExponentiateAnalyzer singleton;

	public static ExponentiateAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ExponentiateAnalyzer();
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
			
		return new Exponentiate(left, right);
	}
}
