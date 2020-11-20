package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the image function.
 * 
 * @author Linkimals
 * 
 */
public class ImageAnalyzer implements SemanticAnalyzerInterface {
	
	private static ImageAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is an ImageAnalyzer
	 */
	public static ImageAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ImageAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the image token
		StringToken ftoken = (StringToken) tokens.pop();
		
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Image(ftoken.getString());
		
	}

}
