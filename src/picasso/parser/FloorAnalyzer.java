package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the floor function.
 * 
 * @author Sara Sprenkle
 * 
 */
public class FloorAnalyzer extends UnaryFunctionAnalyzer {
	
	private static FloorAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a FloorAnalyzer
	 */
	public static FloorAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new FloorAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the floor token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Floor Function Token") {
			throw new ParseException("Not a floor function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Floor(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
