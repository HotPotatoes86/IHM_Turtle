package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;

import turtle.model.Turtle;

public class ExpertWindow extends JFrame{

	private static final long serialVersionUID = -3346917639937664350L;

	public final static int BOARD_SIZE = 20;
	
	/**
	 * Frame with the expert version of interface
	 */
	public ExpertWindow(){
		super("I'm a pretty turtle");
		Turtle turtle = new Turtle(BOARD_SIZE);
        this.add(new Grid(turtle));
        this.add(new Info(turtle), BorderLayout.EAST);
        Box westBox = Box.createVerticalBox();
        westBox.add(new History());
        westBox.add(new Command(turtle));
        this.add(westBox,BorderLayout.WEST);
	}
}
