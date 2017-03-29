package turtle.model;

import turtle.ihm.Grid;
import turtle.ihm.History;

public final class CommandGo {
	
	public static void use(Turtle t, String par) {
		try {
			//if the value is a integer
			int value = Integer.parseInt(par);
			for (int i=0; i<value; i++){
				CommandGo.use(t);
			}
		} catch (Exception e) {
			//if the value isn't a integer, we ignore it
			par = "";
			CommandGo.use(t);
		}
	}
	
	public static void use(Turtle t){
		t.addCommand("go()");
		History.addText("go()");
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
	
	public static void undo(Turtle t){
		for (int x : t.getActualPattern().getParts()){
			if (t.getDraw()) t.deleteLastPatternDrawed();
			switch (x){
				case 0: if (t.getY()>0) t.setCoordinates(t.getX(), t.getY()+1);
					break;
				case 1:	if (t.getY()>0 && t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()-1, t.getY()+1);
					break;
				case 2: if (t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()-1, t.getY());
					break;
				case 3: if (t.getY()<Turtle.BOARD_SIZE-1 && t.getX()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX()-1, t.getY()-1);
					break;
				case 4: if (t.getY()<Turtle.BOARD_SIZE-1) t.setCoordinates(t.getX(), t.getY()-1);
					break;
				case 5: if (t.getY()<Turtle.BOARD_SIZE-1 && t.getX()>0) t.setCoordinates(t.getX()+1, t.getY()-1);
					break;
				case 6: if (t.getX()>0) t.setCoordinates(t.getX()+1, t.getY());
					break;
				case 7: if (t.getY()>0 && t.getX()>0) t.setCoordinates(t.getX()+1, t.getY()+1);
					break;
				default: 
					break;
			}
			if (t.getDraw()) t.deleteLastPatternDrawed();
		}
	}

}
