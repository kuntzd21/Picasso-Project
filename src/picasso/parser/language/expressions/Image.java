package picasso.parser.language.expressions;

import picasso.view.commands.Reader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import picasso.parser.language.ExpressionTreeNode;
import picasso.view.commands.Evaluater;
import picasso.model.Pixmap;
import javax.imageio.*;

/**
 * Represents the Image function in the Picasso language.
 * 
 * @author Linkimals
 */
public class Image extends ExpressionTreeNode {
	
	private String filename;
	private BufferedImage buffImage;
	
	public Image(String filename) {
		this.filename = filename;
		try {
			this.buffImage = ImageIO.read(new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		
		int imageX = toIntX(x);
		int imageY = toIntY(y);
		
		Color c = new Color(buffImage.getRGB(imageX, imageY));
		return new RGBColor(c);
		
	}
		
	protected int toIntX(double value) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) ((value - Evaluater.DOMAIN_MIN) / range * (buffImage.getWidth() - 1));
	}
	
	protected int toIntY(double value) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) ((value - Evaluater.DOMAIN_MIN) / range * (buffImage.getHeight() - 1));
	}
	
	@Override
	public String toString() {
		return "Image";
	}
}
