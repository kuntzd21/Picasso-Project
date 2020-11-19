package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the julia fractal function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Julia extends ExpressionTreeNode {

	/**
	 * Evaluates this expression at the given x,y 
	 * point recursively calling the julia expression
	 * until either at limit or breaks out of acceptable
	 * boundaries
	 * 
	 * @return the color from evaluating the randomized value of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		int count = 0;
		double iter = 100;
		double red;
		double green;
		double blue;
		x = x * 2;
		y = y * 2;
		double cX = -0.4;
		double cY = 0.6;
	
		while (x*x + y*y < 20 && count < iter){
			double temporaryX = x*x - y*y + cX;
			y = 2*x*y+ cY;
			x = temporaryX;
			count += 1;
			}
		if (count == iter) {
		red = 0;
		green = -1;
		blue = 1;}
		else if (count > iter/3){
		red = count/iter;
		green = -1;
		blue = count/iter;
		}
		else {
			red = -1;
			green = -1;
			blue = -1;
		}
		
		return new RGBColor(red, green, blue);}
		
	
	
	/**
	 * Tests for equality
	 * 
	 * @return true if equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Julia)) {
			return false;
		}
		return true;
	}

	/**
	 *  @return "Julia", the representation 
	 * of this variable in Picasso expressions
	 */
	@Override
	public String toString() {
		return "Julia";
	}
}
