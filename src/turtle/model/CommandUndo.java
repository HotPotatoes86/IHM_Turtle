package turtle.model;

import turtle.ihm.ColorPanel;
import turtle.ihm.Grid;
import turtle.ihm.PatternPanel;

public final class CommandUndo {
	
	public static void use(Turtle t, Grid g, PatternPanel pp, ColorPanel cp) {
		if (!t.getCommands().isEmpty()) {
			switch (t.getCommands().peek()) {	// look the head of the stack
				case "go()":
					CommandGo.undo(t);
					g.repaint();
					break;
				case "turn()":
					CommandTurn.undo(t);
					pp.repaint();
					break;
				case "color()":
					CommandColor.undo(t);
					cp.repaint();
					break;
				case "draw()":
					CommandDraw.undo(t);
					break;
				default:
					break;
			}
			t.getCommands().pop();	// remove the head of the stack
		}
	}
	
}
