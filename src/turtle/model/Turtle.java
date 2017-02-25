package turtle.model;

import java.awt.Color;
import java.util.ArrayList;

public class Turtle {

	//----------------------Attributes----------------------//
	private Color actualColor;
	
	/*
	 * List of possible patterns
	 */
	private ArrayList<Pattern> patterns; 
	private Pattern actualPattern;
	
	//----------------------Constructors----------------------//
	public Turtle(Color defaultColor){
		this.actualColor = defaultColor;
		this.patterns = new ArrayList<>();
	}

	public Turtle(){
		this(Color.RED);
	}
	
	//----------------------Methods----------------------//
	public void setPatterns(ArrayList<Pattern> p){
		this.patterns = p;
	}
	
	public void go(){
		
	}
	
	public void go(int k){
		
	}
	
	public void turn(){
		
	}
	
	public void turn(int k){
		
	}
	
	public void draw(){
		
	}
	
	public void color(Color col){
		this.actualColor = col;
	}
	
	public void undo(){
		
	}
	
	public void init(){
		
	}
}