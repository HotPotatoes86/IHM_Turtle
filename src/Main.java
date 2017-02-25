import javax.swing.SwingUtilities;

import turtle.model.PatternFactory;
import turtle.model.Turtle;

/*
 * Class launching the application
 */

public class Main {
	
	public static void makeIt(){
		Turtle my_turtle = new Turtle();
		my_turtle.setPatterns(PatternFactory.createSimplePattern(2));
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