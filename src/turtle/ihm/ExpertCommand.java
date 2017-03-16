package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import turtle.model.Turtle;

public class ExpertCommand extends JPanel{

	private static final long serialVersionUID = -2697483271813355451L;

	private TextArea text;
	private JButton applyButton;
	private Turtle turtle;
	
	public ExpertCommand(Turtle t) {
		super(new BorderLayout());
		this.text = new TextArea(20,20);
		this.turtle = t;
		this.add(this.text);
		this.initButton();
	}
	
	/**
	 * initialize the apply button
	 */
	public void initButton() {
		this.applyButton = new JButton("Apply");
		this.applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//Lecture de jtext area + lecture commandes
			}
		});
		this.add(this.text);
		this.add(this.applyButton, BorderLayout.SOUTH);
	}
}
