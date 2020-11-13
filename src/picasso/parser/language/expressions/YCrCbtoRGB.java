package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the RgbToYCrCb function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Nick Steinert
 */
public class YCrCbtoRGB extends UnaryFunction {

	/**
	 * Create a log expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to YCrCbtoRGB
	 */
	public YCrCbtoRGB(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the YCrCbtoRGB of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the YCrCbtoRGB of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor c = param.evaluate(x, y);
		double red = c.getRed() + c.getBlue() * 1.4022;
		double green = c.getRed() + c.getGreen() * -0.3456 + c.getBlue() * -0.7145;
		double blue = c.getRed() + c.getGreen() * 1.7710;
		return new RGBColor(red, green, blue);

	}
}
