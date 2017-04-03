package turtle.model;

public final class CommandDraw {

	/**
	 * use the command draw
	 * @param t the turtle
	 */
	public static void use(Turtle t) {
		t.setDraw(!t.getDraw());
		t.addCommand("draw()");
	}
	
	/**
	 * undo the command draw
	 * @param t the turtle
	 */
	public static void undo(Turtle t) {
		t.setDraw(!t.getDraw());
	}
	
}
