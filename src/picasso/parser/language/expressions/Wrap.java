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
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
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
		red = wrapping(red);
		
		double green = result.getGreen();
		green = wrapping(green);
		 
		double blue = result.getBlue();
		blue = wrapping(blue);
		
		return new RGBColor(red, green, blue);
	}

	/**
	 * Method that contains wrap functionality.
	 * 
	 * @param color
	 * @return wrapped color
	 */
	static double wrapping(double color) {
		while (color > 1 || color < -1) {
			if (color > 1) {
				color = color - 2;
			}
			else if (color < -1) {
				color = color + 2;
			}
		}
		return color;
	}
}
