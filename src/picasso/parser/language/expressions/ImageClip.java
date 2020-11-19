package picasso.parser.language.expressions;

import picasso.view.commands.Reader;

import java.awt.Color;

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
	
	public ImageClip(Image image, ExpressionTreeNode xExpr, ExpressionTreeNode yExpr) {
		
		this.image = image;
		this.xExpression = xExpr;
		this.yExpression = yExpr;
		
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xColor = this.xExpression.evaluate(x, y);
		RGBColor yColor = this.yExpression.evaluate(x, y);
		
		double xDouble = Clamp.clamping(xColor.getBlue());
		double yDouble = Clamp.clamping(yColor.getBlue());
		
		return image.evaluate(xDouble, yDouble);
		
		}

	@Override
	public String toString() {
		return "ImageClip";
	}
}
