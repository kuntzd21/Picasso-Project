package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the imageClip function.
 * 
 * @author Linkimals
 * 
 */
public class ImageClipAnalyzer implements SemanticAnalyzerInterface {
	
	private static ImageClipAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is an ImageClipAnalyzer
	 */
	public static ImageClipAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ImageClipAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the imageClip token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "ImageClip Function Token") {
			throw new ParseException("Not an image clip function token.");
		}
		
		ExpressionTreeNode y = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode x = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		Image image = (Image) SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new ImageClip(image, x, y);
		
	}

}
