package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import picasso.view.*;


/**
 * Evaluate a zoom in expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Nick Steinert
 */
public class ZoomInEvaluater extends Evaluater implements Command<Pixmap> {
	
	
	/**
	 * Evaluate a zoom in expression for each point in the image.
	 */
	@Override
	public void execute(Pixmap target) {
		zoomDomainMax *= zoomInFactor;
		zoomDomainMin *= zoomInFactor;
		paintPixmap(target);
	}
	

	/**
	 * Convert from image space to the new zoom domain space.
	 */
	
/*
	@Override
	protected double imageToDomainScale(int value, int bounds) {
		double range = zoomDomainMax - zoomDomainMin;
		return ((double) value / bounds) * range + zoomDomainMin;
	}
*/

}
