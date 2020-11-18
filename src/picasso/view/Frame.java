package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 *
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame(Dimension size) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Save", new Writer());
		commands.add("Zoom In", new ZoomInEvaluater());
		commands.add("Zoom Out", new ZoomOutEvaluater());
		
		//add panel for user input at bottom
		InputPanel input = new InputPanel(canvas);
		input.add("Evaluate",new ThreadedCommand<Pixmap>(canvas, new Evaluater()));
		input.add("Save to history",new ThreadedCommand<Pixmap>(canvas, new SaveHistory()));

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(input, BorderLayout.SOUTH);
		pack();
	}
}
