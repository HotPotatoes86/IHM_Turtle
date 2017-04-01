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
	public static int BOX_SIZE = 20;

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
		this.setSize(new Dimension(this.board_size*BOX_SIZE+10, this.board_size*BOX_SIZE+10));
		this.repaint();
	}
	
	//----------------------Methods----------------------//
	/**
	 * 
	 * @return the size of the board
	 */
	public int getBoardSize() {
		return this.board_size;
	}
	
	/**
	 * draws the turtle, the lines of the grid and the patterns drawed on the panel
	 */
	@Override
	public void paintComponent(Graphics g){
		//The thickness of the pencil will be increased according to the importance of the elements in the panel
		super.paintComponent(g);
		//------Grid
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1)); //here the method to change the pencil's thickness
        g2.setColor(Color.LIGHT_GRAY);
        for (int i=0; i<this.board_size+1; i++){
        	for (int j=0; j<this.board_size+1; j++){
        		//draws the column's and the line's borders
        		g2.draw(new Line2D.Float(i*BOX_SIZE+10, j*BOX_SIZE+10, i*BOX_SIZE+10, this.board_size*BOX_SIZE+10));
            	g2.draw(new Line2D.Float(j*BOX_SIZE+10, i*BOX_SIZE+10, this.board_size*BOX_SIZE+10, i*BOX_SIZE+10));
        	}
        }
        //------Turtle
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);;
        int radius = 5;
        //draw a circle to represent the turtle
        int posX = this.turtle.getX()*BOX_SIZE + 10 - BOX_SIZE/2 + radius;
        int posY = this.turtle.getY()*BOX_SIZE + 10 - BOX_SIZE/2 + radius;
		g2.draw(new Ellipse2D.Double(posX, posY, 2.0 * radius, 2.0 * radius));
		//when the draw mode is active, the turtle is filled with its color 
		if (this.turtle.getDraw()) {
			Ellipse2D.Double circle = new Ellipse2D.Double(posX, posY, 2.0 * radius, 2.0 * radius);
			g2.setColor(this.turtle.getColor());;
			g2.fill(circle);
		}
		//------Patterns
		g2.setStroke(new BasicStroke(5));
        boolean test = false;
        int x=0, y=0;
        //the tab contains the first position of X and Y and then the last position (in the next passage in the loop)
        for (Object[] tab : this.turtle.getPatternDrawed()) {
        	try {
        		if (test) {
            		test=false;
            		g2.setColor((Color)tab[2]);
            		g2.draw(new Line2D.Float(x*BOX_SIZE+10, y*BOX_SIZE+10, (int)tab[0]*BOX_SIZE+10, (int)tab[1]*BOX_SIZE+10));
            	}else {
            		test=true;
            		x=(int)tab[0];
            		y=(int)tab[1];
            	}
        	}catch (Exception e) {
        		System.out.println(e);
        	}
        }
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
