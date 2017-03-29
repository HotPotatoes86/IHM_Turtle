package turtle.model;

import java.util.Stack;

import turtle.ihm.History;

public final class CommandReplay {

	public static void init(Turtle t) {
		while (!t.getCommands().isEmpty()) {
			History.deleteLastLine(t);
		}
		t.setCoordinates(0, 0);
		while(!t.getPatternDrawed().isEmpty()) {
			t.deleteLastPatternDrawed();
		}
	}
	
	public static void use(Turtle t) {
		try{
			Thread thread = new Thread(){
				public void run() {
					Stack<String> temp = new Stack<>();
					while (!t.getCommands().isEmpty()) {
						temp.push(t.getCommands().peek());
						t.getCommands().pop();
					}
					while (!temp.isEmpty()) {
						switch (temp.peek()) {
							case "GO": CommandGo.use(t, ""); break;
							case "TURN": CommandTurn.use(t, ""); break;
							case "DRAW": CommandDraw.use(t); break;
							case "COLOR": CommandColor.use(t, ""); break;
						}
						try{
							Thread.sleep(400);
						}
						catch(Exception e){
							System.out.println(e);
						}
						temp.pop();
					}
				}
			};
			thread.start();
			Thread.sleep(2000);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
