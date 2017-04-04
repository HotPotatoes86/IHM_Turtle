package turtle.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import turtle.model.CommandInit;
import turtle.model.CommandReplay;
import turtle.model.CommandUndo;
import turtle.model.Turtle;

public class EastBox extends Box {
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = -124758012473642027L;
	
	private PatternPanel my_patterns;
    private PatternPanel my_current_pattern;
    private ColorPanel my_current_color;
        
    private JButton init;
    private JButton undo;
    private JButton replay;
    private JButton quit;
    
    private Turtle turtle;
    private Grid grid;
    
    private boolean isExpert;
    
  //----------------------Constructors----------------------//
    public EastBox(Turtle t, Grid g, boolean isExpert) {
        super(BoxLayout.PAGE_AXIS);
        
        this.turtle = t;
        this.grid = g;
        this.my_patterns = new PatternPanel(t);
        this.my_current_pattern = new PatternPanel(t,true);
        this.my_current_color = new ColorPanel(t);
        this.isExpert = isExpert;
        
        Box current_info_content = Box.createHorizontalBox();
        current_info_content.add(this.my_current_pattern);
        current_info_content.add(this.my_current_color);
        
        //initialize the buttons
        this.initButtons();
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new GridLayout(2,2));
        panel_button.add(this.init);
        panel_button.add(this.undo);
        panel_button.add(this.replay);
        panel_button.add(this.quit);
        
        this.add(my_patterns);
        this.add(current_info_content); 
        this.add(panel_button); 
   }
    
  //----------------------Methods----------------------//
    public void repaintall() {
    	this.grid.repaint();
		this.my_current_pattern.repaint();
		this.my_current_color.setBackground(this.turtle.getColor());
    }
    
    public ColorPanel getActualColor(){
    	return this.my_current_color;
    }
   
    public PatternPanel getActualPanel(){
    	return this.my_current_pattern;
    }
    
    /**
     * initialize the buttons of the box
     */
    public void initButtons(){
    	 this.init = new JButton("Init");
    	 this.init.addActionListener(new ActionListener() {
        	 @Override
        	 public void actionPerformed(ActionEvent event) {
        		 //uses the command init
        		 CommandInit.use(EastBox.this.turtle);
        		 //if it's the beginner interface, we delete all the history
        		 if (!isExpert) History.deleteAll();
        		 EastBox.this.repaintall();
        	 }
         });
         this.undo = new JButton("Undo");
         this.undo.addActionListener(new ActionListener() {
        	 @Override
        	 public void actionPerformed(ActionEvent event) {
        		 //we remove the last command in the history
        		 History.deleteLastLine(EastBox.this.turtle);
        		 //uses the command undo
        		 CommandUndo.use(EastBox.this.turtle);
        		 EastBox.this.repaintall();
        	 }
         });
         this.replay = new JButton("Replay");
         this.replay.addActionListener(new ActionListener(){
  			@Override
  			public void actionPerformed(ActionEvent event) {
  				//uses the command replay
  				//initializes the board
  				CommandReplay.init(EastBox.this.turtle);
  				EastBox.this.repaintall();
  				//and then replays
  				CommandReplay.use(EastBox.this.turtle, EastBox.this.grid, EastBox.this.my_current_pattern, EastBox.this.my_current_color);
  				EastBox.this.repaintall();
  			}
          });
         this.quit = new JButton("Quit");
         //exits the program
         this.quit.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent event) {
 				System.exit(0);
 			}
         });
    }
    
    
    
}
