package turtle.model;

import turtle.ihm.History;

public final class CommandInit {

	public static void use(Turtle t) {
		while (!t.getCommands().isEmpty()) {
			History.deleteLastLine(t);
			t.getCommands().pop();
		}
		t.setCoordinates(0, 0);
		while(!t.getPatternDrawed().isEmpty()) {
			t.deleteLastPatternDrawed();
		}
	}
}
