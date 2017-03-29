package turtle.model;

import turtle.ihm.ColorPanel;
import turtle.ihm.Grid;
import turtle.ihm.History;
import turtle.ihm.PatternPanel;

public final class CommandInit {

	public static void use(Turtle t, Grid g, PatternPanel pp, ColorPanel cp) {
		while (!t.getCommands().isEmpty()) {
			History.deleteLastLine(t);
			t.getCommands().pop();
		}
		t.setCoordinates(0, 0);
		while(!t.getPatternDrawed().isEmpty()) {
			t.deleteLastPatternDrawed();
		}
		pp.repaint();
		cp.repaint();
		g.repaint();
	}
}
