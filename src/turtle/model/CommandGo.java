package turtle.model;

public final class CommandGo {
	
	/**
	 * use the command go and verify the parameter
	 * @param t the turtle
	 * @param par the parameter in String
	 * @return true if the parameter is correct or false
	 */
	public static boolean use(Turtle t, String par) {
		if (par.isEmpty() || par.equals("")) {
			t.addCommand("go()");
			CommandGo.use(t);
			return true;
		}else {
			try {
				//if the value is a integer
				int value = Integer.parseInt(par);
				if (value<=0) return false;
				t.addCommand("go(" + value + ")");
				for (int i=0; i<value; i++){
					CommandGo.use(t);
				}
				return true;
			} catch (Exception e) {
				//if the value isn't a integer, we return false
				return false;
			}
		}
	}
	
	public static void use(Turtle t){
		for (int x : t.getActualPattern().getParts()){
			if (t.getDraw()) t.addPatternDrawed(t.getX(), t.getY(), t.getColor());
			switch (x){
				case 0: if (t.getY()>0) t.setCoordinates(t.getX(), t.getY()-1);
					break;
				case 1:	if (t.getY()>0 && t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()+1, t.getY()-1);
					break;
				case 2: if (t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()+1, t.getY());
					break;
				case 3: if (t.getY()<Turtle.BOARD_SIZE-1 && t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()+1, t.getY()+1);
					break;
				case 4: if (t.getY()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX(), t.getY()+1);
					break;
				case 5: if (t.getY()<Turtle.BOARD_SIZE-1 && t.getX()>0) t.setCoordinates(t.getX()-1, t.getY()+1);
					break;
				case 6: if (t.getX()>0) t.setCoordinates(t.getX()-1, t.getY());
					break;
				case 7: if (t.getY()>0 && t.getX()>0) t.setCoordinates(t.getX()-1, t.getY()-1);
					break;
				default: 
					break;
			}
			if (t.getDraw()) t.addPatternDrawed(t.getX(), t.getY(), t.getColor());
		}
	}
	
	public static void undo(Turtle t, String parameters){
		try {
			int value = Integer.parseInt(parameters);
			for (int i=0; i<value; i++) {
				CommandGo.undo(t);
			}
		}catch (Exception e) {
			CommandGo.undo(t);
		}
	}
	
	public static void undo(Turtle t) {
		for (int x : t.getActualPattern().getParts()){
			if (t.getDraw()) t.deleteLastPatternDrawed();
			switch (x){
				case 0: if (t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX(), t.getY()+1);
					break;
				case 1:	if (t.getX()>0 && t.getY()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()-1, t.getY()+1);
					break;
				case 2: if (t.getX()>0) t.setCoordinates(t.getX()-1, t.getY());
					break;
				case 3: if (t.getY()>0 && t.getX()>0) t.setCoordinates(t.getX()-1, t.getY()-1);
					break;
				case 4: if (t.getY()>0) t.setCoordinates(t.getX(), t.getY()-1);
					break;
				case 5: if (t.getY()>0 && t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()+1, t.getY()-1);
					break;
				case 6: if (t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()+1, t.getY());
					break;
				case 7: if (t.getY()<Turtle.BOARD_SIZE-1 && t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()+1, t.getY()+1);
					break;
				default: 
					break;
			}
			if (t.getDraw()) t.deleteLastPatternDrawed();
		}
	}

}
