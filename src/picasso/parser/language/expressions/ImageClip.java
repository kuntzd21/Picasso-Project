package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ImageClip function in the Picasso language.
 * 
 * @author Linkimals
 */
public class ImageClip extends ExpressionTreeNode {
	
	private Image image;
	private ExpressionTreeNode xExpression;
	private ExpressionTreeNode yExpression;
	
	/**
	 * Creates an ImageClip object, which is an image object that is clipped according to
	 * the x-coordinate expression and the y-coordinate expression
	 * 
	 * @param image the image to be displayed and clipped
	 * @param xExpr the x-coordinate expression that will be clamped
	 * @param yExpr the y-coordinate expression that will be clamped
	 */
	public ImageClip(Image image, ExpressionTreeNode xExpr, ExpressionTreeNode yExpr) {
		
		this.image = image;
		this.xExpression = xExpr;
		this.yExpression = yExpr;
		
	}
	
	/**
	 * Evaluate x expression, evaluate y expression, clamp both, then retrieve the color in
	 * the image at the clamped position and return it 
	 * 
	 * @param x the x position of the image
	 * @param y the y position of the image
	 * @return The RGBColor of a pixel as an RGBColor object
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xColor = this.xExpression.evaluate(x, y);
		RGBColor yColor = this.yExpression.evaluate(x, y);
		
		double xDouble = Clamp.clamping(xColor.getBlue());
		double yDouble = Clamp.clamping(yColor.getBlue());
		
		return image.evaluate(xDouble, yDouble);
		
		}

}
