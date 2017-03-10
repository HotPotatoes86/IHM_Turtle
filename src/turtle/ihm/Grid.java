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

public class Grid extends JPanel{
    
	private static final long serialVersionUID = 7892049671166136728L;

	/**
	 * the grid where the turtle move
	 */
	public Grid(){
		super(new GridLayout(20,20));
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		for (int i=0; i<20*20; i++){
			JLabel l = new JLabel();
			l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			l.setPreferredSize(new Dimension(20,20));
			this.add(l);
		}
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
}
