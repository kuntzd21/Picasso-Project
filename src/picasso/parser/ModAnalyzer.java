package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Modulo;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the mod or "modulo function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Nick Steinert
 * 
 */
public class ModAnalyzer implements SemanticAnalyzerInterface {
	
	private static ModAnalyzer singleton;

	public static ModAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ModAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Remove the mod token
		tokens.pop();
		
		// the parameters are the next tokens on the stack.
		// But, they need to be processed	
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new Modulo(left, right);
	}

}
