package picasso.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.view.commands.Evaluater;
/**
 * This class represents 
 * a panel for text input
 * and a button to evaluate
 * the typed expression
 * 
 * @author linkimals
 */
@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	private Canvas myView;
	public static TextField tF = new TextField("", 20);
	/**
	 * Creates panel that will update the given picasso.view.
	 * 
	 * @param view the Canvas that the panel's buttons update
	 */
	public InputPanel(Canvas view) {
		myView = view;


}
	/**
	 * Add the text field
	 * and evaluater as a button with the given 
	 * button text. When the button
	 * is clicked, the command is executed and the 
	 * associated canvas is updated.
	 * 
	 * @param buttonText the text for the button
	 * @param action     the action associated with the new button
	 */
	public void add(String buttonText, final Command<Pixmap> action) {
		JButton button = new JButton(buttonText);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.execute(myView.getPixmap());
				myView.refresh();
			}
		});
				
		add(tF);
		add(button);

	}

}
