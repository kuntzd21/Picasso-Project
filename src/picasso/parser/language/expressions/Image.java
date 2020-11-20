package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import picasso.parser.language.ExpressionTreeNode;
import picasso.view.commands.Evaluater;
import javax.imageio.*;

/**
 * Represents an image in the Picasso language.
 * 
 * @author Linkimals
 */
public class Image extends ExpressionTreeNode {
	
	public static final Color DEFAULT_COLOR = Color.BLACK;
	private String filename;
	private static BufferedImage buffImage;
	
	/**
	 * Create an image object from the given image file.
	 * 
	 * @param filename the image file
	 */
	public Image(String filename) {
		this.filename = filename;
		try {
			buffImage = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.err.println("Not an image file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Evaluates the RGBColor at a pixel in the image file filename.
	 * 
	 * @param x the x position of the pixel
	 * @param y the y position of the pixel
	 * @return The RGBColor of a pixel as an RGBColor object
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		int imageX = toIntX(x);
		int imageY = toIntY(y);

		if (isInBounds(imageX, imageY)) {
			Color c = new Color(buffImage.getRGB(imageX, imageY));
			return new RGBColor(c);
		}
		else {
			return new RGBColor(DEFAULT_COLOR);
		}
	}
	
	/**
	 * Maps a coordinate to a positive integer within the width of the frame proportional to
	 * value's original position.
	 * 
	 * @param value an x coordinate
	 * @return a positive integer that represents a position within the frame
	 */
	protected int toIntX(double value) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) ((value - Evaluater.DOMAIN_MIN) / range * (buffImage.getWidth() - 1));
	}
	
	/**
	 * Maps a coordinate to a positive integer within the width of the frame proportional to
	 * value's original position.
	 * 
	 * @param value a y coordinate
	 * @return a positive integer that represents a position within the frame
	 */
	protected int toIntY(double value) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) ((value - Evaluater.DOMAIN_MIN) / range * (buffImage.getHeight() - 1));
	}

	/**
	 * Determine if the given (x,y) coordinate is within the bounds of this image.
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return true if the given (x,y) coordinate is within the bounds of this
	 *         image.
	 */
	public static boolean isInBounds(int x, int y) {
		return (0 <= x && x < buffImage.getWidth()) && (0 <= y && y < buffImage.getHeight());
	}
	
}
