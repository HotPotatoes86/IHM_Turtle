package turtle.model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import turtle.ihm.Grid;
import turtle.ihm.PatternPanel;

public class Turtle {

	//----------------------Attributes----------------------//
	private Color actualColor;
	public static int BOARD_SIZE = 15;	//height = width
	private int posx=0, posy=0;	//turtle's position
	private int actual_pattern=0;
	private boolean draw = false;
	private ArrayList<Integer[]> patternsDrawed;
	
	public final static String chemin = "save.txt";
    private final static File fichier = new File(chemin); 
	
	/*
	 * List of possible patterns
	 */
	private ArrayList<Pattern> patterns; 
	
	//----------------------Constructors----------------------//
	public Turtle(ArrayList<Pattern> p, Color defaultColor, int size){
		this.patterns = p;
		this.actualColor = defaultColor;
		this.patternsDrawed = new ArrayList<>();
		Turtle.BOARD_SIZE = size;
        try {
        	Turtle.fichier.delete();
            Turtle.fichier .createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
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
	public void addDrawedPattern(int x, int y) {
		Integer[] tab = new Integer[2];
		tab[0] = x;
		tab[1] = y;
		this.patternsDrawed.add(tab);
	}
	
	public ArrayList<Integer[]> getDrawedPatterns(){
		return this.patternsDrawed;
	}
	
	public void deleteLastDrawedPattern() {
		this.patternsDrawed.remove(this.patternsDrawed.size()-1);
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
	
	public void go(){
		CommandGo.use(this);
	}
	
	public void go(int k){
		CommandGo.use(k, this);
	}
	
	public void turn(){
		CommandTurn.use(this);
	}
	
	public void turn(int k){
		CommandTurn.use(k, this);
	}
	
	public void draw() {
		CommandDraw.use(this);
	}
	
	/**
	 * undo the last command
	 * @param g the grid to repaint
	 * @param p the pattern panel to repaint
	 */
	public void undo(Grid g, PatternPanel p) {
		CommandUndo.use(this, g, p);
	}
	
	public void color(Color col){
		CommandUndo.writeSave("color("+col+")");
		this.actualColor = col;
	}
	
	public void init(){
		this.posx=0;
		this.posy=0;
		this.actual_pattern=0;
		try{
	        Turtle.fichier.delete();
	        Turtle.fichier.createNewFile();
	        //this.nbSaveLines=0;
	    }catch (Exception e) {
	        System.out.println(e);
	    }
	}
}