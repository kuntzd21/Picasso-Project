package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the division function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Division extends BinaryOperator {

	public Division(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	/**
	 * Evaluates this expression at the given x,y point by dividing
	 * the function's parameters.
	 * 
	 * @return the resultant color from dividing the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = left.evaluate(x, y);
		RGBColor result2 = right.evaluate(x, y);
		
		double red;
		double green;
		double blue;
		
		if (result2.getRed() == 0) {
			red = 0;
		}
		else {
			red = result.getRed()/result2.getRed();
		}
		if (result2.getGreen() == 0) {
			green = 0;
		}
		else {
			green = result.getGreen()/result2.getGreen();
		}
		if (result2.getBlue() == 0) {
			blue = 0;
		}
		else {
			blue = result.getBlue()/result2.getBlue();
		}

		return new RGBColor(red, green, blue);
	}

}
