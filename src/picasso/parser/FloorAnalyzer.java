package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.functions.FloorToken;
import picasso.parser.tokens.NumberToken;

/**
 * Handles parsing the floor function.
 * 
 * @author Sara Sprenkle
 * 
 */
public class FloorAnalyzer extends UnaryFunctionAnalyzer {
	
	private static FloorAnalyzer singleton;

	public static FloorAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new FloorAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the floor token
		FloorToken ftoken = (FloorToken) tokens.pop();
		
		// Check if the floor token is a function.
		if (ftoken.isFunction() != true) {
			throw new ParseException("Not a function.");
		}
		
		// the parameter is the next token on the stack.
		NumberToken ntoken = (NumberToken) tokens.pop();
		
		// But, it needs to be processed
		
		double value = ntoken.value();
		
		if (value < -1 || value > 1) {
			throw new ParseException("Constant is out of range [-1, 1]");
		}
		
		return new Floor(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
