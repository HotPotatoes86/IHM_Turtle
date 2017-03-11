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
	
	private final String chemin = "save.txt";
    private final File fichier = new File(chemin); 
    private int nbSaveLines=0;
	
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
		this(PatternFactory.createSimplePattern(2), Color.RED, size);
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
	
	public ArrayList<Pattern> getPatterns(){
		return this.patterns;
	}
	
	public Pattern getActualPattern(){
		return this.patterns.get(this.actual_pattern);
	}
	
	public void writeSave(String txt){
		try {
            final FileWriter writer = new FileWriter(fichier,true);
            try {
            	this.nbSaveLines++;
                writer.write(txt+"\n");
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	
	public void setPatterns(ArrayList<Pattern> p){
		this.patterns = p;
	}
	
	public void go(){
		if (this.actual_pattern>=0){
			this.writeSave("go()");
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
			this.writeSave("turn()");
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
		this.draw = true;
	}
	
	public void stopDraw(){
		this.draw = false;
	}
	
	public void color(Color col){
		this.writeSave("color("+col+")");
		this.actualColor = col;
	}
	
	public static boolean deleteLine(String fileName, int lineNumber) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            StringBuffer sb = new StringBuffer(); 
            String line;    
            int nbLinesRead = 0;       
            while ((line = reader.readLine()) != null) {
                if (nbLinesRead != lineNumber) {
                    sb.append(line + "\n");
                }
                nbLinesRead++;
            }
            reader.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(sb.toString());
            out.close();
 
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
	public void undo(){
		Turtle.deleteLine("sauvegarde.txt",this.nbSaveLines-1);
		this.nbSaveLines--;
	}
	
	public void init(){
		this.posx=0;
		this.posy=0;
		this.actual_pattern=0;
		try{
	        this.fichier.delete();
	        this.nbSaveLines=0;
	    }catch (Exception e) {
	        System.out.println(e);
	    }
	}
}