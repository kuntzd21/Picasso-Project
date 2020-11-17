package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the arc tangent function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Linkimals
 */
public class ATangent extends UnaryFunction {

	/**
	 * Create a tangent expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to arc tangent
	 */
	public ATangent(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the arc tangent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the arc tangent of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red;
		double green;
		double blue;
		
		if (Math.sin(result.getRed()) == 0) {
			red = 0;}
		else {
			red = Math.atan(result.getRed());
		}
				
		if (Math.sin(result.getGreen()) == 0) {
			green = 0;}
		else {
			green = Math.atan(result.getGreen());
		}

		if (Math.sin(result.getBlue()) == 0) {
			blue = 0;}
		else {
			blue = Math.atan(result.getBlue());
		}

		return new RGBColor(red, green, blue);
	}
}
