/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exponentiate function in the Picasso language.
 * 
 * @author Linkimals
 *
 */
public class Exponentiate extends BinaryOperator {

	public Exponentiate(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
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
		
		double red = Math.pow(result.getRed(), result2.getRed());
		double green = Math.pow(result.getGreen(), result2.getGreen());
		double blue = Math.pow(result.getBlue(), result2.getBlue());

		return new RGBColor(red, green, blue);
	}
	
}
