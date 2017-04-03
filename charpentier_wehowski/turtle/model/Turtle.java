package turtle.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

public class Turtle {

	//----------------------Attributes----------------------//
	private Color actualColor;
	private ArrayList<Color> colorsHistory;	//history of the turtle's color
	public static int BOARD_SIZE = 15;		//height = width
	private int posx=0, posy=0;				//turtle's position
	private int actual_pattern=0;			//number of the actual pattern
	private boolean draw = false;			//draw mode
	private ArrayList<Object[]> patternsDrawed;
	private Stack<String> commandsHistory;
	
	/*
	 * List of possible patterns
	 */
	private ArrayList<Pattern> patterns; 
	
	//----------------------Constructors----------------------//
	public Turtle(ArrayList<Pattern> p, Color defaultColor, int size){
		this.patterns = p;
		this.actualColor = defaultColor;
		this.patternsDrawed = new ArrayList<>();
		this.commandsHistory = new Stack<>();
		this.colorsHistory = new ArrayList<>();
		this.colorsHistory.add(Color.RED);
		Turtle.BOARD_SIZE = size;
	}
	
	//Default Patterns
	public Turtle(Color defaultColor, int size){
		this(PatternFactory.createSimplePattern(2), defaultColor, size);
	}

	//Default Patterns & Color
	public Turtle(int size){
		this(PatternFactory.createTurningPattern(), Color.RED, size);
	}
	
	//----------------------Methods----------------------//
	/**
	 * add a pattern to the list of the drawed pattern
	 * tab[0] = horizontal position
	 * tab[1] = vertical position
	 * tab[2] = color of the pattern
	 * @param x horizontal position
	 * @param y vertical position
	 * @param c color of the pattern
	 */
	public void addPatternDrawed(int x, int y, Color c) {
		Object[] tab = new Object[3];
		tab[0] = x;
		tab[1] = y;
		tab[2] = c;
		this.patternsDrawed.add(tab);
	}
		
	/**
	 * delete the last pattern drawed
	 */
	public void deleteLastPatternDrawed() {
		this.patternsDrawed.remove(this.patternsDrawed.size()-1);
	}
		
	/**
	 * add a command to the stack of commands
	 * @param cmd the name of the command
	 */
	public void addCommand(String cmd) {
		this.commandsHistory.push(cmd);
	}
	
	//----------------------Getters----------------------//
	public ArrayList<Color> getColorsHistory(){
		return this.colorsHistory;
	}
	
	public ArrayList<Object[]> getPatternDrawed(){
		return this.patternsDrawed;
	}
	
	public Stack<String> getCommands(){
		return this.commandsHistory;
	}
	
	public boolean getDraw() {
		return this.draw;
	}
	
	public int getX(){
		return this.posx;
	}
	
	public int getY(){
		return this.posy;
	}
	
	public Color getColor(){
		return this.actualColor;
	}
	
	public int getNumberActualPattern() {
		return this.actual_pattern;
	}
	
	public Pattern getActualPattern(){
		return this.patterns.get(this.actual_pattern);
	}
	
	public ArrayList<Pattern> getPatterns(){
		return this.patterns;
	}
	
	//----------------------Setters----------------------//
	public void setDraw(boolean b) {
		this.draw = b;
	}
	
	public void setColor(Color c) {
		this.actualColor = c;
	}

	public void setActualPattern(int n) {
		this.actual_pattern = n;
	}

	public void setCoordinates(int x, int y) {
		this.posx = x;
		this.posy = y;
	}
	
	public void setPatterns(ArrayList<Pattern> p){
		this.patterns = p;
	}
	
}