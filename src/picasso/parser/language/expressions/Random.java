package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the random function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Random extends ExpressionTreeNode {

	/**
	 * Evaluates this expression at the given x,y point by evaluating the random value of
	 * the function's parameters.
	 * 
	 * @return the color from evaluating the randomized value of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		double red = Math.random();
		double green = Math.random();
		double blue = Math.random();

		return new RGBColor(red, green, blue);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Random)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns "Random", the representation of this variable in Picasso expressions
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Random";
	}
}
