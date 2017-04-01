package turtle.model;

import java.util.ArrayList;

public final class CommandGo {
	
	/**
	 * use the other method use and verify the parameter
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
	
	/**
	 * use the command go
	 * @param t the turtle
	 */
	public static void use(Turtle t){
		//Interpreter of the integers of the pattern parts
		for (int x : t.getActualPattern().getParts()){
			if (t.getDraw()) t.addPatternDrawed(t.getX(), t.getY(), t.getColor());
			switch (x){
				//top
				case 0: if (t.getY()>0) t.setCoordinates(t.getX(), t.getY()-1);
					break;
				case 1:	if (t.getY()>0 && t.getX()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX()+1, t.getY()-1);
					break;
				//right
				case 2: if (t.getX()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX()+1, t.getY());
					break;
				case 3: if (t.getY()<Turtle.BOARD_SIZE && t.getX()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX()+1, t.getY()+1);
					break;
				//bottom
				case 4: if (t.getY()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX(), t.getY()+1);
					break;
				case 5: if (t.getY()<Turtle.BOARD_SIZE && t.getX()>0) t.setCoordinates(t.getX()-1, t.getY()+1);
					break;
				//left
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
		//an intermediate variable is used which is the inverse of the pattern's parts
		ArrayList<Integer> temp = t.getActualPattern().getParts();
		ArrayList<Integer> patternParts = new ArrayList<>();
		while (!temp.isEmpty()) {
			patternParts.add(temp.get(temp.size()-1));
			temp.remove(temp.size()-1);
		}
		//we can now read the parts from the end
		for (int x : patternParts){
			if (t.getDraw()) t.deleteLastPatternDrawed();
			switch (x){
				case 0: if (t.getX()<Turtle.BOARD_SIZE && t.getY()>0) t.setCoordinates(t.getX(), t.getY()+1);
					break;
				case 1:	if (t.getX()>0 && t.getY()<Turtle.BOARD_SIZE && t.getY()>0 && t.getX()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX()-1, t.getY()+1);
					break;
				case 2: if (t.getX()>0 && t.getX()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX()-1, t.getY());
					break;
				case 3: if (t.getY()>0 && t.getX()>0 && t.getY()<Turtle.BOARD_SIZE && t.getX()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX()-1, t.getY()-1);
					break;
				case 4: if (t.getY()>0 && t.getY()<Turtle.BOARD_SIZE) t.setCoordinates(t.getX(), t.getY()-1);
					break;
				case 5: if (t.getY()>0 && t.getX()<Turtle.BOARD_SIZE && t.getY()<Turtle.BOARD_SIZE && t.getX()>0) t.setCoordinates(t.getX()+1, t.getY()-1);
					break;
				case 6: if (t.getX()<Turtle.BOARD_SIZE && t.getX()>0) t.setCoordinates(t.getX()+1, t.getY());
					break;
				case 7: if (t.getY()<Turtle.BOARD_SIZE && t.getX()<Turtle.BOARD_SIZE && t.getY()>0 && t.getX()>0) t.setCoordinates(t.getX()+1, t.getY()+1);
					break;
				default: 
					break;
			}
			if (t.getDraw()) t.deleteLastPatternDrawed();
		}
	}

}
