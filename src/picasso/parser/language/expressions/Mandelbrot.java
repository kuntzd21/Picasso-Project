package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the mandelbrot fractal function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Mandelbrot extends ExpressionTreeNode {

	/**
	 * Evaluates this expression at the given x,y 
	 * point recursively calling the Mandelbrot expression
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
		double originalX = x * 2;
		double originalY = y * 2;
		x = 0;
		y = 0;
	
		while (x*x + y*y < 4 && count < iter){
			double temporaryX = x*x - y*y + originalX;
			y = 2*x*y + originalY;
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
		if (!(obj instanceof Mandelbrot)) {
			return false;
		}
		return true;
	}

	/**
	 * @return "Mandelbrot", the representation 
	 * of this variable in Picasso expressions
	 *
	 */
	@Override
	public String toString() {
		return "Mandelbrot";
	}
}
