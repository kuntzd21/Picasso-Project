package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Wrap;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the wrap function.
 * 
 * @author Linkimals
 * 
 */
public class WrapAnalyzer extends UnaryFunctionAnalyzer {
	
	private static WrapAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a WrapAnalyzer
	 */
	public static WrapAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new WrapAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the wrap token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Wrap Function Token") {
			throw new ParseException("Not a wrap function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Wrap(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
