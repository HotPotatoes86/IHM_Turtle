package turtle.model;

import java.awt.Color;

public final class CommandInit {

	/**
	 * use the command init
	 * @param t the turtle
	 */
	public static void use(Turtle t) {
		//empty the stack of commands
		while (!t.getCommands().isEmpty()) {
			t.getCommands().pop(); //remove the head
		}
		//we return to the default parameters
		t.setCoordinates(0, 0);
		t.setActualPattern(0);
		//we remove all the pattern drawed in the list
		while(!t.getPatternDrawed().isEmpty()) {
			t.deleteLastPatternDrawed();
		}
		//same for the colors
		while(!t.getColorsHistory().isEmpty()) {
			t.getColorsHistory().remove(t.getColorsHistory().size()-1);
		}
		//we return to the default parameters
		t.setColor(Color.RED);
		t.getColorsHistory().add(Color.RED);
	}
}
