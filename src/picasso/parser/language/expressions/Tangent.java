package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the tangent function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Linkimals
 */
public class Tangent extends UnaryFunction {

	/**
	 * Create a tangent expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to tangent
	 */
	public Tangent(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the tangent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the tangent of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red;
		double green;
		double blue;
		
		if (Math.cos(result.getRed()) == 0) {
			red = 0;}
		else {
			red = Math.tan(result.getRed());
		}
				
		if (Math.cos(result.getGreen()) == 0) {
			green = 0;}
		else {
			green = Math.tan(result.getGreen());
		}

		if (Math.cos(result.getBlue()) == 0) {
			blue = 0;}
		else {
			blue = Math.tan(result.getBlue());
		}

		return new RGBColor(red, green, blue);
	}
}
