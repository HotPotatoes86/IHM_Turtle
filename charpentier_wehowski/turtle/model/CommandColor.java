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
		    turtle.setColor(color); 				//set the new color of turtle
		    turtle.getColorsHistory().add(color);	//add to the history of colors
		    turtle.addCommand("color(" + parameters + ")");	//add the command to the history of commands
			return true;
		} catch (Exception e) {
			//if not return false
		    return false;
		}
	}
	
	/**
	 * undo the command color
	 * @param turtle the turtle
	 */
	public static void undo(Turtle turtle){
		//remove the last color of the history
		turtle.getColorsHistory().remove(turtle.getColorsHistory().size()-1);
		//the new color is the new last color
		turtle.setColor(turtle.getColorsHistory().get(turtle.getColorsHistory().size()-1));
	}
	
}
