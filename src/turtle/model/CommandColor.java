package turtle.model;

import java.awt.Color;
import java.lang.reflect.Field;

public final class CommandColor{

	/**
	 * use the command go and verify the parameter
	 * @param t the turtle
	 * @param par the parameter in String
	 * @return true if the parameter is correct or false
	 */
	public static boolean use(Turtle turtle, String parameters){
		Color color;
		try {
			//if the field is a color
		    Field field = Class.forName("java.awt.Color").getField(parameters);
		    color = (Color)field.get(null);
		    turtle.setColor(color); 
		    turtle.getColors().add(color);
		    turtle.addCommand("color(" + parameters + ")");
			return true;
		} catch (Exception e) {
		    return false;
		}
	}
	
	public static void undo(Turtle turtle){
		turtle.getColors().remove(turtle.getColors().size()-1);
		turtle.setColor(turtle.getColors().get(turtle.getColors().size()-1));
	}
	
}
