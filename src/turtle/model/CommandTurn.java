package turtle.model;

public final class CommandTurn{
	
	public static void use(Turtle t){
		CommandUndo.writeSave("turn()");
		if (t.getNumberActualPattern()<t.getPatterns().size()-1){
			t.setActualPattern(t.getNumberActualPattern()+1);
		}else{
			t.setActualPattern(0);
		}
	}
	
	public static void use(int k, Turtle t){
		for (int i=0; i<k; i++){
			CommandTurn.use(t);
		}
	}
}
