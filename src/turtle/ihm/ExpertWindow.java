package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import turtle.model.Turtle;

public class ExpertWindow extends JFrame implements ComponentListener{

	private static final long serialVersionUID = -3346917639937664350L;

	private int board_size;
	private EastBox info;
	private Grid grid;
	private ExpertCommand commands;
	
	/**
	 * Frame with the expert version of interface
	 */
	public ExpertWindow(int size){
		super("I'm a pretty turtle");
		this.addComponentListener(this);
		//we initialize each elements of the frame
		this.board_size = size;
		Turtle turtle = new Turtle(this.board_size);
		this.grid = new Grid(turtle);
		this.info = new EastBox(turtle, grid, true);
		this.commands = new ExpertCommand(turtle, grid, info.getActualPanel(), info.getActualColor());
		
		//we add the elements to the frame
        this.add(grid);
        this.add(info, BorderLayout.EAST);
        this.add(commands,BorderLayout.WEST);
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
		int widthSize = this.getWidth()-this.commands.getWidth()-this.info.getWidth();
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
