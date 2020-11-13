package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ceiling function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Linkimals
 */
public class Absolute extends UnaryFunction {

	/**
	 * Create a ceiling expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to ceiling
	 */
	public Absolute(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the ceiling of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the ceiling of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.abs(result.getRed());
		double green = Math.abs(result.getGreen());
		double blue = Math.abs(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
