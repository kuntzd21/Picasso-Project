package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.language.expressions.Exp;
import picasso.parser.language.expressions.Log;
import picasso.parser.language.expressions.RgbToYCrCb;
import picasso.parser.language.expressions.Sin;
import picasso.parser.language.expressions.Tan;
import picasso.parser.language.expressions.YCrCbtoRGB;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.IdentifierToken;

/**
 * Handles parsing the RgbToYCrCb function.
 * 
 * @author Nick Steinert
 * 
 */
public class RgbToYCrCbAnalyzer extends UnaryFunctionAnalyzer {
	
	private static RgbToYCrCbAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a RgbToYCrCbAnalyzer
	 */
	public static RgbToYCrCbAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new RgbToYCrCbAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the RgbToYCrCb token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "RgbToYCrCb Function Token") {
			throw new ParseException("Not a RgbToYCrCb function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new RgbToYCrCb(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
