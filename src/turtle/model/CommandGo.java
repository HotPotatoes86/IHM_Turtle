package turtle.model;

public final class CommandGo {
	
	public static void use(Turtle t){
		CommandUndo.writeSave("go()");
		for (int x : t.getActualPattern().getParts()){
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
		}
	}
	
	public static void undo(Turtle t){
		for (int x : t.getActualPattern().getParts()){
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
		}
	}
	
	public static void use(int k, Turtle t){
		for (int i=0; i<k; i++){
			CommandGo.use(t);
		}
	}
}
