package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;

import turtle.model.Turtle;

public class BeginnerWindow extends JFrame{

	private static final long serialVersionUID = -3346917639937664350L;

	public final static int BOARD_SIZE = 20;
	
	/**
	 * Frame with the beginner version of interface
	 */
	public BeginnerWindow(){
		super("I'm a pretty turtle");
		Turtle turtle = new Turtle(BOARD_SIZE);
		Grid grid = new Grid(turtle);
		EastBox info = new EastBox(turtle, grid);
        Box westBox = Box.createVerticalBox();
        History hist = new History();
        westBox.add(hist);
        westBox.add(new Command(turtle, grid, info.getActualPanel(), info.getActualColor()));
        this.add(grid);
        this.add(info, BorderLayout.EAST);
        this.add(westBox,BorderLayout.WEST);
	}
}
