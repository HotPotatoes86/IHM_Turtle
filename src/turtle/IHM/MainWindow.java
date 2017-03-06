package turtle.IHM;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import turtle.model.Turtle;

public class MainWindow extends JFrame{
    public MainWindow(){
        super("I'm a pretty turtle");
        
    }
    
    public static void makeIt(){

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
