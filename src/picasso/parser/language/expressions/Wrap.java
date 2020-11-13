package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Linkimals
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
		red = wrapfunctionality(red);
		
		double green = result.getGreen();
		green = wrapfunctionality(green);
		 
		double blue = result.getBlue();
		blue = wrapfunctionality(blue);
		
		return new RGBColor(red, green, blue);
	}

	/**
	 * Method that contains wrap functionality.
	 * 
	 * @param color
	 * @return wrapped color
	 */
	private double wrapfunctionality(double color) {
		while (color >= 1 && color <= -1) {
			if (color >= 1) {
				color = color - 1;
			}
			else if (color <= -1) {
				color = color + 1;
			}
		}
		return color;
	}
}
