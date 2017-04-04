package turtle.model;

import java.awt.Color;
import java.util.Stack;

import turtle.ihm.ColorPanel;
import turtle.ihm.Grid;
import turtle.ihm.PatternPanel;

public final class CommandReplay {

	/**
	 * same as the command init without delete the command history
	 * @param t
	 */
	public static void init(Turtle t) {
		//we return to the default parameters
		t.setCoordinates(0, 0);
		t.setActualPattern(0);
		//we remove all the pattern drawed in the list
		while(!t.getPatternDrawed().isEmpty()) {
			t.deleteLastPatternDrawed();
		}
		//same for the colors
		while(!t.getColorsHistory().isEmpty()) {
			t.getColorsHistory().remove(t.getColorsHistory().size()-1);
		}
		//we return to the default parameters
		t.setColor(Color.RED);
		t.getColorsHistory().add(Color.RED);		
		t.setDraw(false);
	}
	
	public static void use(Turtle t, Grid g, PatternPanel pp, ColorPanel cp) {
		try{
			Thread thread = new Thread(){
				public void run() {
					Stack<String> temp = new Stack<>();
					while (!t.getCommands().isEmpty()) {
						temp.push(t.getCommands().peek());
						t.getCommands().pop();
					}
					while (!temp.isEmpty()) {
						String cmd = temp.peek() /*top of the stack*/, command="", parameters="";
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
						switch (command) {
							case "go": CommandGo.use(t, parameters); break;
							case "turn": CommandTurn.use(t, parameters); break;
							case "draw": CommandDraw.use(t); break;
							case "color": CommandColor.use(t, parameters); break;
							default: break;
						}
						//History.addText(temp.peek());
						try{
							Thread.sleep(400);
						}
						catch(Exception e){
							System.out.println(e);
						}
						g.repaint();
						pp.repaint();
						cp.setBackground(t.getColor());
						temp.pop();
					}
				}
			};
			thread.start();
			Thread.sleep(400);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
