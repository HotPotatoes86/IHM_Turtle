package turtle.model;

import java.awt.Color;
import java.lang.reflect.Field;

import turtle.ihm.History;

public final class CommandColor {

	public static void use(Turtle t, String col){
		Color color;
		try {
		    Field field = Class.forName("java.awt.Color").getField(col);
		    color = (Color)field.get(null);
		    t.setColor(color); 
			t.addCommand("color(" + col + ")");
			History.addText("color(" + col + ")");
		} catch (Exception e) {
		    color = null;
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
