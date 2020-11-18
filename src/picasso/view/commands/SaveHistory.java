/**
 * 
 */
package picasso.view.commands;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.InputPanel;

import javax.swing.JOptionPane;

/**
 * @author Linkimals
 *
 */
public class SaveHistory implements Command<Pixmap> {
	
	private String history = "";
	private String exprString;

	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		exprString = createExpressionString();
		history = history + exprString + "\n";
		JOptionPane.showMessageDialog(null, history, "Expression history", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Creates string of expression based on the text field in InputPanel to be stored
	 * in history.
	 */
	protected String createExpressionString() {
		return InputPanel.tF.getText();

	}
	
}
