package picasso.parser.language.expressions;

import picasso.view.commands.Reader;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ImageWrap function in the Picasso language.
 * 
 * @author Linkimals
 */
public class ImageWrap extends ExpressionTreeNode {
	
	private Image image;
	private ExpressionTreeNode xExpression;
	private ExpressionTreeNode yExpression;
	
	public ImageWrap(Image image, ExpressionTreeNode xExpr, ExpressionTreeNode yExpr) {
		
		this.image = image;
		this.xExpression = xExpr;
		this.yExpression = yExpr;
	}
	
	/**
	 * Evaluate x expression, evaluate y expression, wrap both, then retrieve the color in
	 * the image at the wrapped position and return it 
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xColor = this.xExpression.evaluate(x, y);
		RGBColor yColor = this.yExpression.evaluate(x, y);
		
		double xDouble = Wrap.wrapping(xColor.getBlue());
		double yDouble = Wrap.wrapping(yColor.getBlue());
		
		return image.evaluate(xDouble, yDouble);
		
		
		}

	@Override
	public String toString() {
		return "ImageWrap";
	}
}
