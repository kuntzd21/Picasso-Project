package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the multiplication function in the Picasso language.
 * 
 * @author Linkimals
 *
 */

public class Multiplication extends BinaryOperator {

	/**
	 * 
	 */
	public Multiplication(ExpressionTreeNode param, ExpressionTreeNode param2) {
		super(param, param2);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the product of
	 * the function's parameters.
	 * 
	 * @return the color from evaluating the sum of the expression's parameters
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		
		double red = result.getRed() * result2.getRed();
		double green = result.getGreen() * result2.getGreen();
		double blue = result.getBlue() * result2.getBlue();

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
		if (!(obj instanceof Multiplication)) {
			return false;
		}
		Multiplication a = (Multiplication) obj;
		return param.equals(a.param);
	}

}
