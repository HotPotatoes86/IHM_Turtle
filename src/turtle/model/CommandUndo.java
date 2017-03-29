package turtle.model;

public final class CommandUndo {
	
	public static void use(Turtle t) {
		if (!t.getCommands().isEmpty()) {
			switch (t.getCommands().peek()) {	// look the head of the stack
				case "go()":
					CommandGo.undo(t);
					break;
				case "turn()":
					CommandTurn.undo(t);
					break;
				case "color()":
					CommandColor.undo(t);
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
