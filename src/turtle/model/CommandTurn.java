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
			t.addCommand("turn()");
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
				t.addCommand("turn(" + value + ")");
				return true;
			} catch (Exception e) {
				//if the value isn't a integer, we return false
				return false;
			}
		}
	}
	
	/**
	 * use the command
	 * @param t the turtle
	 */
	public static void use(Turtle t){
		if (t.getNumberActualPattern()<t.getPatterns().size()-1){
			//the pattern is the next
			t.setActualPattern(t.getNumberActualPattern()+1);
		}else{
			//the pattern is the number 0
			t.setActualPattern(0);
		}
	}
	
	/**
	 * read the parameters and use the undo method
	 * @param t the turtle
	 * @param parameters the parameters of the command
	 */
	public static void undo(Turtle t, String parameters){
		try {
			int value = Integer.parseInt(parameters);
			for (int i=0; i<value; i++) {
				CommandTurn.undo(t);
			}
		}catch (Exception e) {
			//there are no parameters
			CommandTurn.undo(t);
		}
	}
	
	/**
	 * undo the command turn
	 * @param t the turtle
	 */
	public static void undo(Turtle t){
		if (t.getNumberActualPattern()>0){
			//the pattern is the precedent
			t.setActualPattern(t.getNumberActualPattern()-1);
		}else{
			//the pattern is the last
			t.setActualPattern(t.getPatterns().size()-1);
		}
	}
}
