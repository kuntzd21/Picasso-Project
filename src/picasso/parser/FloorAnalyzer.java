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
		
		// Check if the floor token is a function.
		if (ftoken.toString() != "Floor Function Token") {
			throw new ParseException("Not a floor function.");
		}
		
		// the parameter is the next token on the stack.
		//IdentifierToken vtoken = (IdentifierToken) tokens.pop();
		
		
		// But, it needs to be processed
		//if (vtoken.toString() != "Variable Token: ") {
		//	throw new ParseException("Not a variable.");
		//}
		
		return new Floor(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
