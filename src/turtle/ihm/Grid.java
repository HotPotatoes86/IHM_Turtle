package turtle.ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import turtle.model.Turtle;

public class Grid extends JPanel{
    
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = 7892049671166136728L;
	
	private Turtle turtle;
	private int size;

	//----------------------Constructors----------------------//
	/**
	 * the grid where the turtle move
	 * @param t turtle on the grid
	 * @param size size of the grid
	 */
	public Grid(Turtle t){
		super(new GridLayout(20,20));
		this.turtle = t;
		this.size = Turtle.BOARD_SIZE;
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		for (int i=0; i<size*size; i++){
			JLabel l = new JLabel();
			l.setBorder(BorderFactory.createLoweredBevelBorder());
			l.setPreferredSize(new Dimension(20,20));
			this.add(l);
		}
	}
	
	//----------------------Methods----------------------//
	//TODO fonction pas sur, marche pas
	public void update(){
		this.paintComponent(getGraphics());
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
		g.drawOval(this.turtle.getX(), this.turtle.getY(), 10, 10);
	}
}
