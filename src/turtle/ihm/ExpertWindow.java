package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;

import turtle.model.Turtle;

public class ExpertWindow extends JFrame{

	private static final long serialVersionUID = -3346917639937664350L;

	/**
	 * Frame with the expert version of interface
	 */
	public ExpertWindow(Turtle turtle){
		super("I'm a pretty turtle");
        this.add(new Grid());
        this.add(new Info(turtle), BorderLayout.EAST);
        Box westBox = Box.createVerticalBox();
        westBox.add(new Instructions());
        westBox.add(new Command(turtle));
        this.add(westBox,BorderLayout.WEST);
	}
}
