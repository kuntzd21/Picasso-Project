package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Nick Steinert
 */
public class Wrap extends UnaryFunction {

	/**
	 * Create a ceiling expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to ceiling
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the wrap of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the wrap of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		double red = result.getRed();
		while (red >= 1 && red <= -1) {
			if (red >= 1) {
				red = red - 1;
			}
			else if (red <= -1) {
				red = red + 1;
			}
		}
		
		double green = result.getGreen();
		while (green >= 1 && green <= -1) {
			if (green >= 1) {
				green = green - 1;
			}
			else if (green <= -1) {
				green = green + 1;
			}
		}
		 
		double blue = result.getBlue();
		while (blue >= 1 && blue <= -1) {
			if (blue >= 1) {
				blue = blue - 1;
			}
			else if (blue <= -1) {
				blue = blue + 1;
			}
		}
		
		return new RGBColor(red, green, blue);
	}
}
