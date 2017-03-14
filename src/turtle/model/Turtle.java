package turtle.model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Turtle {

	//----------------------Attributes----------------------//
	private Color actualColor;
	public static int BOARD_SIZE = 15;	//height = width
	private int[][] board;
	private int posx=0, posy=0;	//turtle's position
	private int actual_pattern=0;
	private boolean draw = false;
	
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
		Turtle.BOARD_SIZE = size;
		this.board = new int[Turtle.BOARD_SIZE][Turtle.BOARD_SIZE];
        try {
        	this.fichier.delete();
            this.fichier .createNewFile();
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
	
	public void draw(){
		this.draw = true;
	}
	
	public void stopDraw(){
		this.draw = false;
	}
	
	public void undo() {
		CommandUndo.use();
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
	        this.fichier.delete();
	        this.fichier.createNewFile();
	        //this.nbSaveLines=0;
	    }catch (Exception e) {
	        System.out.println(e);
	    }
	}
}