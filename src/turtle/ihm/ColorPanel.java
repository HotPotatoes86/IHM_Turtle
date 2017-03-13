package turtle.ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import turtle.model.Pattern;
import turtle.model.Turtle;

public class ColorPanel extends JPanel{

	private static final long serialVersionUID = 7209905720807974452L;

	public ColorPanel(Turtle t){
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(t.getColor());
		this.setOpaque(true);
	}
	
	//----------------------Methods----------------------//
	/*@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int centerX = (int)this.getSize().getWidth()/2;
		int centerY = (int)this.getSize().getHeight()/2;
		for (int i=1; i<5; i++){
			this.drawCircle(g, this.centerX, this.centerY, i);
		}
	}
	
	public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }*/
}
