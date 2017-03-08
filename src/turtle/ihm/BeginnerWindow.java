package turtle.ihm;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;

import turtle.model.Turtle;

public class BeginnerWindow extends JFrame{

	private static final long serialVersionUID = -3346917639937664350L;

	public BeginnerWindow(){
		super("I'm a pretty turtle");
        this.add(new Grid());
        this.add(new Info(new Turtle()), BorderLayout.EAST);
        Box westBox = Box.createVerticalBox();
        westBox.add(new Instructions());
        westBox.add(new Command());
        this.add(westBox,BorderLayout.WEST);
	}
}
