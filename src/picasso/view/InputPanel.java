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

@SuppressWarnings("serial")

public class InputPanel extends JPanel {
private Canvas myView;
TextField tF = new TextField("", 30);
public static String expression;

	public InputPanel(Canvas view) {

		myView = view;


}
	public void add(String buttonText) {
		JButton button = new JButton(buttonText);
		//button.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
				//action.execute(myView.getPixmap());
				myView.refresh();
		//	}
	//	});
				
		add(tF);
		add(button);
		expression = tF.getText();

	}

}
