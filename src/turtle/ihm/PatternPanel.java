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

public class PatternPanel extends JPanel{

	//----------------------Attributes----------------------//
	private static final long serialVersionUID = 6331445393754951714L;

	private boolean isCurrentPattern = false;	//if the pattern is the current or the list of all patterns
	private Turtle turtle;
	private int centerX;
	private int centerY;
	private final static int LINE_WIDTH = 10;
	
	//----------------------Constructors----------------------//
	public PatternPanel(Turtle t){
		super();
		this.turtle = t;
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	public PatternPanel(Turtle t, boolean bool){
		this(t);
		this.isCurrentPattern = bool;
	}
	
	//----------------------Methods----------------------//
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.centerX = (int)this.getSize().getWidth()/2;
		this.centerY = (int)this.getSize().getHeight()/2;
		for (int i=1; i<5; i++){
			this.drawCircle(g, this.centerX, this.centerY, i);
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.LIGHT_GRAY);
        for (int i=0; i<this.centerX*2; i+=10){
        	for (int j=0; j<this.centerY*2; j+=10){
        		g2.draw(new Line2D.Float(i, j, i, j+10));
        		g2.draw(new Line2D.Float(i, j, i+10, j));
        	}
        }
		if (isCurrentPattern){
			this.drawPattern(g2, Color.BLUE, this.turtle.getActualPattern());
		}else{
			Color[] tabColor = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.GRAY, Color.PINK, Color.ORANGE};
			int i=0;
			for (Pattern p : this.turtle.getPatterns()){
				this.drawPattern(g2, tabColor[i], p);
				if (i==tabColor.length-1){
					i=0;
				}else{
					i++;
				}
			}
		}
	}
	
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }
	
	public void drawPattern(Graphics2D g2, Color c, Pattern p){
		int posx=this.centerX;
		int posy=this.centerY;
		for (int x : p.getParts()){
	        g2.setStroke(new BasicStroke(2));
	        g2.setColor(c);
	        int p1=posx;
	        int p2=posy;
	        switch (x){
				case 0: posy -=LINE_WIDTH;
						break;
				case 1:	posx +=LINE_WIDTH;
						posy -=LINE_WIDTH;
						break;
				case 2: posx +=LINE_WIDTH;
						break;
				case 3:	posx +=LINE_WIDTH;
						posy +=LINE_WIDTH;
						break;
				case 4: posy +=LINE_WIDTH;
						break;
				case 5:	posx -=LINE_WIDTH;
						posy +=LINE_WIDTH;
						break;
				case 6: posx -=LINE_WIDTH;
						break;
				case 7:	posx -=LINE_WIDTH;
						posy -=LINE_WIDTH;
						break;
				default: 
					break;
			}
	        g2.draw(new Line2D.Float(p1, p2, posx, posy));
		}
	}
}
