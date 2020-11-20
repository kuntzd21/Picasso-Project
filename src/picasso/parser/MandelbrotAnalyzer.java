package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Mandelbrot;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Mandelbrot function.
 * 
 * @author Linkimals
 * 
 */
public class MandelbrotAnalyzer implements SemanticAnalyzerInterface {
	
	private static MandelbrotAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is a RandomAnalyzer
	 */
	public static MandelbrotAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new MandelbrotAnalyzer();
		}
		return singleton;
	}
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the random token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "Mandelbrot Function Token") {
			throw new ParseException("Not a mandelbrot function token.");
		}
		
		return new Mandelbrot();
	}
}
