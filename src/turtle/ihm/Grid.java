package turtle.ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import turtle.model.Turtle;

public class Grid extends JPanel{
    
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = 4333155750571403673L;
	
	private Turtle turtle;
	private int board_size;
	public final static int BOX_SIZE = 20;

	//----------------------Constructors----------------------//
	/**
	 * the grid where the turtle move
	 * @param t turtle on the grid
	 * @param board_size board_size of the grid
	 */
	public Grid(Turtle t){
		this.turtle = t;
		this.board_size = Turtle.BOARD_SIZE;
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setSize(new Dimension(this.board_size*BOX_SIZE, this.board_size*BOX_SIZE));
		this.repaint();
	}
	
	//----------------------Methods----------------------//
	public int getBoardSize() {
		return this.board_size;
	}
	
	/**
	 * draw a line on the panel (the grid)
	 * @param g graphics
	 * @param x1 beginning of the line (x)
	 * @param x2 beginning of the line (x)
	 * @param y1 end of the line (y)
	 * @param y2 end of the line (y)
	 * @param c color of the line
	 */
	public void paintComponent(Graphics g, int x1, int x2, int y1, int y2, Color c){
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c);
        g2.draw(new Line2D.Float(x1, y1, x2, y2));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.LIGHT_GRAY);
        for (int i=0; i<this.board_size; i++){
        	for (int j=0; j<this.board_size; j++){
        		g2.draw(new Line2D.Float(i*BOX_SIZE, j*BOX_SIZE, i*BOX_SIZE, this.board_size*BOX_SIZE));
            	g2.draw(new Line2D.Float(j*BOX_SIZE, i*BOX_SIZE, this.board_size*BOX_SIZE, i*BOX_SIZE));
        	}
        }
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);;
        int radius = 5;
		g2.draw(new Ellipse2D.Double(this.turtle.getX()*BOX_SIZE + radius, this.turtle.getY()*BOX_SIZE + radius, 2.0 * radius, 2.0 * radius));
	}
	
	@Override
	public Dimension getPreferredSize(){
		return this.getSize();
	}

	@Override
	public Dimension getSize(){
		return (new Dimension(this.getBoardSize()*Grid.BOX_SIZE, this.getBoardSize()*Grid.BOX_SIZE));
	}

}
