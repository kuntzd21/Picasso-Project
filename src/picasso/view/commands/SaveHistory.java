/**
 * 
 */
package picasso.view.commands;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.InputPanel;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * @author Linkimals
 *
 */
public class SaveHistory implements Command<Pixmap> {
	
	List<Object> history = new ArrayList<>();

	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		String exprString = createExpressionString();
		history.add(exprString);
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
