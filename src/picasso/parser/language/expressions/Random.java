package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the random function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Random {

	public Random(ExpressionTreeNode param) {
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the random value of
	 * the function's parameters.
	 * 
	 * @return the color from evaluating the randomized value of the expression's parameters
	 */
	public RGBColor evaluate(double x, double y) {
		
		double red = Math.random();
		double green = Math.random();
		double blue = Math.random();

		return new RGBColor(red, green, blue);
	}
}
