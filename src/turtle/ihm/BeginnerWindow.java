package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Box;
import javax.swing.JFrame;

import turtle.model.Turtle;

public class BeginnerWindow extends JFrame implements ComponentListener{

	private static final long serialVersionUID = -3346917639937664350L;

	private int board_size;
	private Grid grid;
	private EastBox info;
	private Box westBox;
	
	/**
	 * Frame with the beginner version of interface
	 */
	public BeginnerWindow(int size){
		super("I'm a pretty turtle");
		//we use a component listener to adapt the grid's size to the window's size
		this.addComponentListener(this);
		//we initialize the variables
		this.board_size = size;
		Turtle turtle = new Turtle(this.board_size);
		this.grid = new Grid(turtle);
		this.info = new EastBox(turtle, grid, false);
        this.westBox = Box.createVerticalBox();
        History hist = new History(false); //false = beginner interface
        westBox.add(hist);
        westBox.add(new BeginnerCommand(turtle, grid, info.getActualPanel(), info.getActualColor()));
        //we add all the components to the window
        this.add(grid);
        this.add(info, BorderLayout.EAST);
        this.add(westBox,BorderLayout.WEST);
	}

	@Override
	public void componentHidden(ComponentEvent event) {
		
	}

	@Override
	public void componentMoved(ComponentEvent event) {
		
	}

	/**
	 * adapt the grid's size to the window's size 
	 */
	@Override
	public void componentResized(ComponentEvent event) {
		int widthSize = this.getWidth()-this.westBox.getWidth()-this.info.getWidth();
		if (this.getHeight()>widthSize) {
			Grid.BOX_SIZE = widthSize/this.board_size;
		}else {
			Grid.BOX_SIZE = this.getHeight()/this.board_size;
		}
		this.grid.repaint();
	}

	@Override
	public void componentShown(ComponentEvent event) {
		
	}
}
