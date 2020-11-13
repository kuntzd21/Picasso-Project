package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negation;
import picasso.parser.tokens.Token;
/**
 * Handles parsing the negate operator.
 * 
 * @author Linkimals
 * 
 */
public class NegateAnalyzer implements SemanticAnalyzerInterface {
	
	private static NegateAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a NegateAnalyzer
	 */
	public static NegateAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new NegateAnalyzer();
		}
		return singleton;
	}

	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the negate token
		tokens.pop();
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Negation(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
