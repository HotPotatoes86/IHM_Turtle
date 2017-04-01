package turtle.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

public class Turtle {

	//----------------------Attributes----------------------//
	private Color actualColor;
	private ArrayList<Color> colorsHistory;
	public static int BOARD_SIZE = 15;	//height = width
	private int posx=0, posy=0;	//turtle's position
	private int actual_pattern=0;
	private boolean draw = false;
	private ArrayList<Object[]> patternsDrawed;
	private Stack<String> commands;
	
	/*
	 * List of possible patterns
	 */
	private ArrayList<Pattern> patterns; 
	
	//----------------------Constructors----------------------//
	public Turtle(ArrayList<Pattern> p, Color defaultColor, int size){
		this.patterns = p;
		this.actualColor = defaultColor;
		this.patternsDrawed = new ArrayList<>();
		this.commands = new Stack<>();
		this.colorsHistory = new ArrayList<>();
		this.colorsHistory.add(Color.RED);
		Turtle.BOARD_SIZE = size;
	}
	
	//Default Patterns
	public Turtle(Color defaultColor, int size){
		this(PatternFactory.createSimplePattern(1), defaultColor, size);
	}

	//Default Patterns & Color
	public Turtle(int size){
		this(PatternFactory.createTurningPattern(), Color.RED, size);
	}
	
	//----------------------Methods----------------------//
	public void addPatternDrawed(int x, int y, Color c) {
		Object[] tab = new Object[3];
		tab[0] = x;
		tab[1] = y;
		tab[2] = c;
		this.patternsDrawed.add(tab);
	}
	
	public ArrayList<Color> getColorsHistory(){
		return this.colorsHistory;
	}
	
	public ArrayList<Object[]> getPatternDrawed(){
		return this.patternsDrawed;
	}
	
	public void deleteLastPatternDrawed() {
		this.patternsDrawed.remove(this.patternsDrawed.size()-1);
	}
	
	public Stack<String> getCommands(){
		return this.commands;
	}
	
	public void addCommand(String cmd) {
		this.commands.push(cmd);
	}
	
	public void setDraw(boolean b) {
		this.draw = b;
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
	
	public void setColor(Color c) {
		this.actualColor = c;
	}
	
	public Color getColor(){
		return this.actualColor;
	}
	
	public void setActualPattern(int n) {
		this.actual_pattern = n;
	}
	
	public int getNumberActualPattern() {
		return this.actual_pattern;
	}
	
	public void setCoordinates(int x, int y) {
		this.posx = x;
		this.posy = y;
	}
	
	public ArrayList<Pattern> getPatterns(){
		return this.patterns;
	}
	
	public Pattern getActualPattern(){
		return this.patterns.get(this.actual_pattern);
	}
	
	public void setPatterns(ArrayList<Pattern> p){
		this.patterns = p;
	}
	
}