package turtle.model;

import java.awt.Color;

public final class CommandInit {

	public static void use(Turtle t) {
		while (!t.getCommands().isEmpty()) {
			t.getCommands().pop();
		}
		t.setCoordinates(0, 0);
		t.setActualPattern(0);
		while(!t.getPatternDrawed().isEmpty()) {
			t.deleteLastPatternDrawed();
		}
		while(!t.getColorsHistory().isEmpty()) {
			t.getColorsHistory().remove(t.getColorsHistory().size()-1);
		}
		t.setColor(Color.RED);
		t.getColorsHistory().add(Color.RED);
	}
}
