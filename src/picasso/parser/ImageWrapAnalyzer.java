package picasso.parser;

import java.util.Stack;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the imageWrap function.
 * 
 * @author Linkimals
 * 
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {
	
	private static ImageWrapAnalyzer singleton;

	/**
	 * Getter method for singleton class state.
	 * 
	 * @return the singleton class state, which is an ImageWrapAnalyzer
	 */
	public static ImageWrapAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new ImageWrapAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Need to remove the imageWrap token
		Token ftoken = (Token) tokens.pop();
		
		if (ftoken.toString() != "ImageWrap Function Token") {
			throw new ParseException("Not an image wrap function token.");
		}
		
		ExpressionTreeNode y = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode x = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		Image image = (Image) SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new ImageWrap(image, x, y);
		
	}

}
