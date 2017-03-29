package turtle.model;

public final class CommandDraw {

	public static void use(Turtle t) {
		t.setDraw(!t.getDraw());
		t.addCommand("draw()");
	}
	
	public static void undo(Turtle t) {
		t.setDraw(!t.getDraw());
	}
	
}
