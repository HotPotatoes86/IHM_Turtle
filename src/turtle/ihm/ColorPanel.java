package turtle.ihm;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import turtle.model.Turtle;

public class ColorPanel extends JPanel{

	private static final long serialVersionUID = 7209905720807974452L;

	/**
	 * a simple panel where the color is displayed
	 * @param t
	 */
	public ColorPanel(Turtle t){
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(t.getColor());
		this.setOpaque(true);
	}
}
