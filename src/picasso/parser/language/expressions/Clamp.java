package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the clamp function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Linkimals
 */
public class Clamp extends UnaryFunction {

	/**
	 * Create a clamp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to clamp
	 */
	public Clamp(ExpressionTreeNode param) {
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
		red = clamping(red);
		
		double green = result.getGreen();
		green = clamping(green);
		 
		double blue = result.getBlue();
		blue = clamping(blue);
		
		return new RGBColor(red, green, blue);
	}

	/**
	 * Method that contains clamping functionality.
	 * 
	 * @param color
	 * @return clamped color
	 */
	private double clamping(double color) {
		if (color < -1) {
			color = -1;
		}
		else if (color > 1 ) {
			color = 1;
		}
		return color;
	}
}
