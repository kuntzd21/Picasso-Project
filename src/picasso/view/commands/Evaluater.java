package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import picasso.view.InputPanel;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluater implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;

	protected static double zoomDomainMin = DOMAIN_MIN;
	protected static double zoomDomainMax = DOMAIN_MAX;
	
	public static double zoomInFactor = 0.9;
	public static double zoomOutFactor = 1.1;
	
	private static ExpressionTreeNode expr;
	

	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		zoomDomainMin = DOMAIN_MIN;
		zoomDomainMax = DOMAIN_MAX;
		try {
			expr = createExpression();
		}
		catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		paintPixmap(target);
	}

	protected void paintPixmap(Pixmap target) {
		// evaluate it for each pixel
		Dimension size = target.getSize();
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = imageToDomainScale(imageY, size.height);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = imageToDomainScale(imageX, size.width);
				Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
				target.setColor(imageX, imageY, pixelColor);
			}
		}
	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = zoomDomainMax - zoomDomainMin;
		return ((double) value / bounds) * range + zoomDomainMin;
	}
/*
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}
*/
	
	/**
	 * Creates expression tree based on the text field in InputPanel
	 */
	protected ExpressionTreeNode createExpression() {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).


		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		return expTreeGen.makeExpression(InputPanel.tF.getText());

		// return new Multiply( new X(), new Y() );
	}

}
