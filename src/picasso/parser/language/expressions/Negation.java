package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the negate operator in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Negation extends UnaryOperator {

	public Negation(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the negated value of
	 * the function's parameters.
	 * 
	 * @return the color from evaluating the negated value of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		double red = -result.getRed();
		double green = -result.getGreen();
		double blue = -result.getBlue();

		return new RGBColor(red, green, blue);
	}
}
	
