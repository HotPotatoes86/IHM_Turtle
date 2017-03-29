package turtle.model;

import turtle.ihm.History;

public final class CommandTurn{
	
	public static void use(Turtle t, String par) {
		try {
			//if the value is a integer
			int value = Integer.parseInt(par);
			for (int i=0; i<value; i++){
				CommandTurn.use(t);
			}
		} catch (Exception e) {
			//if the value isn't a integer, we ignore it
			par = "";
			CommandTurn.use(t);
		}
	}
	
	public static void use(Turtle t){
		t.addCommand("turn()");
		History.addText("turn()");
		if (t.getNumberActualPattern()<t.getPatterns().size()-1){
			t.setActualPattern(t.getNumberActualPattern()+1);
		}else{
			t.setActualPattern(0);
		}
	}
	
	public static void undo(Turtle t){
		if (t.getNumberActualPattern()>0){
			t.setActualPattern(t.getNumberActualPattern()-1);
		}else{
			t.setActualPattern(t.getPatterns().size()-1);
		}
	}
}
