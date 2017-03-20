package turtle.model;

import turtle.ihm.History;

public final class CommandDraw {

	public static void use(Turtle t) {
		t.setDraw(!t.getDraw());
		CommandUndo.writeSave("draw()");
		History.addText("draw()");
	}
	
	public static void draw(Turtle t) {
		
	}
}
