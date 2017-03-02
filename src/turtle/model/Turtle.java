package turtle.model;

import java.awt.Color;
import java.util.ArrayList;

public class Turtle {

	//----------------------Attributes----------------------//
	private Color actualColor;
	public final static int BOARD_SIZE = 15;	//height = width
	private int[][] board;
	private int posx=0, posy=0;	//turtle's position
	private int actual_pattern=0;
	
	/*
	 * List of possible patterns
	 */
	private ArrayList<Pattern> patterns; 
	
	//----------------------Constructors----------------------//
	public Turtle(ArrayList<Pattern> p, Color defaultColor){
		this.patterns = p;
		this.actualColor = defaultColor;
		this.board = new int[Turtle.BOARD_SIZE][Turtle.BOARD_SIZE];
	}
	
	//Default Patterns
	public Turtle(Color defaultColor){
		this(PatternFactory.createSimplePattern(1), defaultColor);
	}

	//Default Patterns & Color
	public Turtle(){
		this(PatternFactory.createSimplePattern(2), Color.RED);
	}
	
	//----------------------Methods----------------------//
	public void setPatterns(ArrayList<Pattern> p){
		this.patterns = p;
	}
	
	public void go(){
		if (this.actual_pattern>=0){
			for (int x : this.patterns.get(this.actual_pattern).getParts()){
				switch (x){
					case 0: if (this.posy>0) this.posy--;
						break;
					case 1:	if (this.posy>0 && this.posx<Turtle.BOARD_SIZE-1){
								this.posy--;
								this.posx++;
							}
						break;
					case 2: if (this.posx<Turtle.BOARD_SIZE-1) this.posx++;
						break;
					case 3: if (this.posy<Turtle.BOARD_SIZE-1 && this.posx<Turtle.BOARD_SIZE-1){
								this.posy++;
								this.posx++;
							}
						break;
					case 4: if (this.posy<Turtle.BOARD_SIZE-1) this.posy++;
						break;
					case 5: if (this.posy<Turtle.BOARD_SIZE-1 && this.posx>0){
								this.posy++;
								this.posx--;
							}
					case 6: if (this.posx>0) this.posx--;
						break;
					case 7: if (this.posy>0 && this.posx>0){
								this.posy--;
								this.posx--;
							}
					default: 
						break;
				}
			}
		}
	}
	
	public void go(int k){
		for (int i=0; i<k; i++){
			this.go();
		}
	}
	
	public void turn(){
		if (this.actual_pattern>=0){
			if (this.actual_pattern<this.patterns.size()-1){
				this.actual_pattern++;
			}else{
				this.actual_pattern=0;
			}
		}
	}
	
	public void turn(int k){
		for (int i=0; i<k; i++){
			this.turn();
		}
	}
	
	public void draw(){
		
	}
	
	public void color(Color col){
		this.actualColor = col;
	}
	
	public void undo(){
		
	}
	
	public void init(){
		this.posx=0;
		this.posy=0;
	}
	
	//TODO TEMP POUR TEST
	public void display(){
		System.out.println("Affichage du plateau :");
		for (int j=0; j<Turtle.BOARD_SIZE; j++){
			for (int i=0; i<Turtle.BOARD_SIZE; i++){
				if (this.posx==i && this.posy==j){
					System.out.print("X");
				}else{
					System.out.print("_");
				}
			}
			System.out.println("");
		}
	}
}