package turtle.model;

public final class CommandTurn{
	
	/**
	 * use the command go and verify the parameter
	 * @param t the turtle
	 * @param par the parameter in String
	 * @return true if the parameter is correct or false
	 */
	public static boolean use(Turtle t, String par) {
		if (par.isEmpty() || par.equals("")) {
			CommandTurn.use(t);
			return true;
		}else {
			try {
				//if the value is a integer
				int value = Integer.parseInt(par);
				if (value<=0) return false;
				for (int i=0; i<value; i++){
					CommandTurn.use(t);
				}
				return true;
			} catch (Exception e) {
				//if the value isn't a integer, we return false
				return false;
			}
		}
	}
	
	public static void use(Turtle t){
		t.addCommand("turn()");
		if (t.getNumberActualPattern()<t.getPatterns().size()-1){
			t.setActualPattern(t.getNumberActualPattern()+1);
		}else{
			t.setActualPattern(0);
		}
	}
	
	public static void undo(Turtle t, String parameters){
		try {
			int value = Integer.parseInt(parameters);
			for (int i=0; i<value; i++) {
				CommandTurn.undo(t);
			}
		}catch (Exception e) {
			CommandTurn.undo(t);
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
