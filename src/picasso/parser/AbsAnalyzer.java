package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Abs;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the absolute value function.
 * 
 * @author Sara Sprenkle
 * 
 */
public class AbsAnalyzer extends UnaryFunctionAnalyzer {
	
	private static AbsAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is an AbsAnalyzer
	 */
	public static AbsAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new AbsAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the floor token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Absolute Value Function Token") {
			throw new ParseException("Not an abs function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Abs(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
