package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import turtle.model.Turtle;

public class MainWindow extends JFrame{
	
    public MainWindow(){
        super("I'm a pretty turtle");
        this.add(new Grid());
        this.add(new Info(new Turtle()), BorderLayout.EAST);
        Box westBox = Box.createVerticalBox();
        westBox.add(new Instructions());
        westBox.add(new Command());
        this.add(westBox,BorderLayout.WEST);
    }
    
    public static void makeIt(){
    	MainWindow window = new MainWindow();
    	window.pack();
    	window.setLocationRelativeTo(null);
    	/*window.setMinimumSize(new Dimension(500,400));
    	window.setPreferredSize(new Dimension(500,400));*/
    	window.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				makeIt();
			}
		});
	}
}
