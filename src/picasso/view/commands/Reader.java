package picasso.view.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.InputPanel;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 */
public class Reader extends FileCommand<Pixmap> {
	String fileName;
	String exp;
	String expression;
	Evaluater evaluator;

	/**
	 * Creates a Reader object, which prompts users for image files to open
	 */
	public Reader() {
		super(JFileChooser.OPEN_DIALOG);
	}

	public Reader(Evaluater evaluator) {
		this();
		this.evaluator = evaluator;
		
	}

	/**
	 * Displays the image file on the given target.
	 */
	public void execute(Pixmap target) {
		fileName = getFileName();
		String extension = fileName.substring(fileName.indexOf("."));
		if (extension.equals(".exp")) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				exp = "";
				while (reader.readLine() != null) {
					exp = exp + reader.readLine();
					expression = exp;
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			InputPanel.tF.setText(expression);
		} else {
			if (fileName != null) {
				//target.read(fileName);
				String uncutFilename = fileName;
				String finalString = uncutFilename.substring(uncutFilename.indexOf("images"));
				InputPanel.tF.setText("\""+finalString+"\"");
				
			}
		}
		evaluator.execute(target);
	}
}
