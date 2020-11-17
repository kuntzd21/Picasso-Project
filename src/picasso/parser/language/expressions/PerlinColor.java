package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Perlin Color function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Nick Steinert
 */
public class PerlinColor extends BinaryOperator {

	/**
	 * Create a Perlin Color expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to Perlin Color
	 */
	public PerlinColor(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left,right);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the perlin color of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the perlin color of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor value1 = left.evaluate(x, y);
		RGBColor value2 = right.evaluate(x, y);
		double red = ImprovedNoise.noise(value1.getRed() + 0.3, value2.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(value1.getBlue() + 0.1, value2.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(value1.getGreen() - 0.8, value2.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);

	}
}
