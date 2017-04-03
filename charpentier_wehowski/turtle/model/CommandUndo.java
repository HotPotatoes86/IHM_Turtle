package turtle.model;

public final class CommandUndo {
	
	/**
	 * use the command
	 * @param t the turtle
	 */
	public static void use(Turtle t) {
		if (!t.getCommands().isEmpty()) {
			String cmd = t.getCommands().peek() /*top of the stack*/, command="", parameters="";
			boolean found = false;	// if the command is found
			//we found the command's name and the parameter
			for (int i=0; i<cmd.length()-1; i++) {	//we remove the last character which is ')' like all commands
				if (found) {
					parameters = parameters + cmd.charAt(i);
				}else if (cmd.charAt(i)=='(') {
					//beginning of the parameter
					found = true;
				}else {
					command = command + cmd.charAt(i);
				}
			}
			//the command is found, we use the undo method of the command
			switch (command) {
				case "go":
					CommandGo.undo(t, parameters);
					break;
				case "turn":
					CommandTurn.undo(t, parameters);
					break;
				case "color":
					CommandColor.undo(t);
					break;
				case "draw":
					CommandDraw.undo(t);
					break;
				default:
					break;
			}
			t.getCommands().pop();	// remove the head of the stack
		}
	}
	
}
