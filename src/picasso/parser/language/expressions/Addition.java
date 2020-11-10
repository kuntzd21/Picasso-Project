package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the addition function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Addition extends BinaryOperator {

	public Addition(ExpressionTreeNode param, ExpressionTreeNode param2) {
		super(param, param2);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the sum of
	 * the function's parameters.
	 * 
	 * @return the color from evaluating the sum of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = left.evaluate(x, y);
		RGBColor result2 = right.evaluate(x, y);
		
		double red = result.getRed() + result2.getRed();
		double green = result.getGreen() + result2.getGreen();
		double blue = result.getBlue() + result2.getBlue();

		return new RGBColor(red, green, blue);
	}
	
}
