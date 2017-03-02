import javax.swing.SwingUtilities;

import turtle.model.Turtle;

/*
 * Class launching the application
 */

public class Main {
	
	public static void makeIt(){
		Turtle my_turtle = new Turtle();
		my_turtle.display();
		my_turtle.turn(2);
		my_turtle.go();
		my_turtle.display();
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