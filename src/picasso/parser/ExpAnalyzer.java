package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.language.expressions.Exp;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the exponent function.
 * 
 * @author Nick Steinert
 * 
 */
public class ExpAnalyzer extends UnaryFunctionAnalyzer {
	
	private static ExpAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a ExpAnalyzer
	 */
	public static ExpAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ExpAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the exp token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Exp Function Token") {
			throw new ParseException("Not an exp function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Exp(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
