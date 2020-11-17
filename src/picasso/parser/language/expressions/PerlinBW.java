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
public class PerlinBW extends BinaryOperator {

	/**
	 * Create a Perlin BW expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to Perlin BW
	 */
	public PerlinBW(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left,right);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the perlin bw of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the perlin bw of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor value1 = left.evaluate(x, y);
		RGBColor value2 = right.evaluate(x, y);
		double grey = ImprovedNoise.noise(value1.getRed() + value2.getRed(), value1.getGreen() + value2.getGreen(),
				value1.getBlue() + value2.getBlue());
		return new RGBColor(grey, grey, grey);

	}
}
