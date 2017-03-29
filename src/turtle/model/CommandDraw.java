package turtle.model;

import turtle.ihm.History;

public final class CommandDraw {

	public static void use(Turtle t) {
		t.setDraw(!t.getDraw());
		t.addCommand("draw()");
		History.addText("draw()");
	}
	
	public static void undo(Turtle t) {
		t.setDraw(!t.getDraw());
	}
	
}
