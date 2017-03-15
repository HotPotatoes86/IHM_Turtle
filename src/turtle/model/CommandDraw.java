package turtle.model;

public final class CommandDraw {

	public static void use(Turtle t) {
		t.setDraw(!t.getDraw());
	}
}
