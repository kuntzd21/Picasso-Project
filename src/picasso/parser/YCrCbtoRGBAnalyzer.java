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
 * Handles parsing the YCrCbtoRGB function.
 * 
 * @author Nick Steinert
 * 
 */
public class YCrCbtoRGBAnalyzer extends UnaryFunctionAnalyzer {
	
	private static YCrCbtoRGBAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a YCrCbtoRGBAnalyzer
	 */
	public static YCrCbtoRGBAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new YCrCbtoRGBAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the YCrCbtoRGB token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "YCrCbtoRGB Function Token") {
			throw new ParseException("Not a YCrCbtoRGB function token.");
		}
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new YCrCbtoRGB(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
		
	}

}
